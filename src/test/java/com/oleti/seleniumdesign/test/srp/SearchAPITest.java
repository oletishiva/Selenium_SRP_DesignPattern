package com.oleti.seleniumdesign.test.srp;

import com.oleti.utils.testdata.SearchKeyword;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.oleti.utils.extentreports.ExtentTestManager.startTest;
import static io.restassured.RestAssured.given;

public class SearchAPITest {

    @BeforeTest
    public void setUpBaseUrl() {
        RestAssured.baseURI="https://api.github.com";
    }

    @Test(dataProvider = "searchKeyword", dataProviderClass = SearchKeyword.class)
    public void getRepositoires(String Keyword)
    {
        startTest("API Test Case : Search With Keyword "+ Keyword,"Using API Call Search with Repository Name :" + Keyword);
        String  response= given().log().all().queryParam("q", Keyword).header("Content-Type","application/json")
                .when().get("search/repositories")
                .then().statusCode(200)
                .extract().response().asString();

        JsonPath js=new JsonPath(response);
        int totalRepositiories=js.getInt("total_count");
        System.out.println("totalRepositories"+totalRepositiories);

        if(totalRepositiories>1)
        {
            for(int i=0;i<10;i++)
                System.out.println(js.getString("items[" + i + "].full_name"));
           //  dataInfo(js.getString( "Repository name: items[" + i + "].full_name"));

        }


    }

}
