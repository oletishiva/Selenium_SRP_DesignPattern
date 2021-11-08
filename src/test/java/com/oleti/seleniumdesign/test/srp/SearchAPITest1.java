package com.oleti.seleniumdesign.test.srp;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

public class SearchAPITest1 {

    public static void main(String args[])
    {
        RestAssured.baseURI="https://api.github.com";
        String  response= given().log().all().queryParam("q", "cypress").header("Content-Type","application/json")
                .when().get("search/repositories")
                .then().statusCode(200)
                .extract().response().asString();

        JsonPath js=new JsonPath(response);
        int totalRepositiories=js.getInt("total_count");
        System.out.println("totalRepositiories"+totalRepositiories);

        if(totalRepositiories>1)
        {
            for(int i=0;i<10;i++)
                System.out.println(js.getString("items["+i+"].full_name"));

        }


    }
}
