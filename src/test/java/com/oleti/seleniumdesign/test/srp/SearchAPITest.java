package com.oleti.seleniumdesign.test.srp;

import com.oleti.utils.logs.Log;
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
    public void getRepositoires(String keyword)
    {
        startTest("API Test Case : Search With Keyword "+ keyword,"Using API Call Search with Repository Name :" + keyword);
        String  response= given().log().all().queryParam("q", keyword).header("Content-Type","application/json")
                .when().get("search/repositories")
                .then().statusCode(200)
                .extract().response().asString();

        JsonPath js=new JsonPath(response);
        int totalRepositiories=js.getInt("total_count");
        Log.info("Total number of repositories with " +keyword +"="+totalRepositiories);
        if(totalRepositiories>1)
        {
            for(int i=0;i<10;i++){
               /* Log.info(js.getString("full_name: "+ "items[" + i + "].full_name"));
                Log.info("Repo Url: "+ js.getString("items[" + i + "].owner.url"));
                Log.info(js.getString("forks: "+"items[" + i + "].forks"));
                Log.info(js.getString("open_issues: "+"items[" + i + "].open_issues"));
                Log.info(js.getString("watchers: "+"items[" + i + "].watchers"));

                 */

                 System.out.println(js.getString("items[" + i + "].full_name"));
                //  dataInfo(js.getString( "Repository name: items[" + i + "].full_name"));
            }
        }
        else
        {
            Log.error("Search Keyword "+keyword+" is wrong,try with correct keyword for search");
        }


    }

}
