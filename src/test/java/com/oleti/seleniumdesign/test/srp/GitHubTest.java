package com.oleti.seleniumdesign.test.srp;

import com.oleti.seleniumdesign.srp.BaseTest;
import com.oleti.seleniumdesign.srp.GitHubMainPage;
import com.oleti.seleniumdesign.srp.SearchResultsPage;
import com.oleti.utils.logs.Log;
import com.oleti.utils.testdata.SearchKeyword;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.oleti.utils.extentreports.ExtentTestManager.startTest;

public class GitHubTest extends BaseTest {

    private GitHubMainPage gitHubMainPage;
    private SearchResultsPage searchResultsPage;

    @BeforeTest
    public void setUppages() {
        this.gitHubMainPage = new GitHubMainPage(driver);
        this.searchResultsPage = new SearchResultsPage(driver);
    }

    @Test(dataProvider = "searchKeyword", dataProviderClass = SearchKeyword.class)
    public void gitHubFlow(String keyword) {
        startTest("Test Case : Search With Keyword "+ keyword,"Search with Repository Name:" + keyword);
        gitHubMainPage.goTo();
        gitHubMainPage.getSearchWidget().enter(keyword);
        int repositoriesCount = Integer.parseInt(searchResultsPage.getResultStat().getSearchRepoCount().replaceAll("[^0-9]", ""));
        System.out.println(repositoriesCount);
        System.out.println(searchResultsPage.getResultStat().getSearchRepoCount());
        Assert.assertTrue(gitHubMainPage.getSearchWidget().isDisplayed());
        Assert.assertTrue(searchResultsPage.getResultStat().isDisplayed());
        Assert.assertTrue(repositoriesCount >= 1);
        Log.info("*********************************");
        Log.info("Printing First Page Results of:" + keyword);
        for (WebElement e : searchResultsPage.getResultStat().getRepositoryNames()) {

            Log.info(e.getText());

        }
        Log.info("*********************************");

    }
}
