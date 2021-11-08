package com.oleti.seleniumdesign.srp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GitHubMainPage
{
    private WebDriver driver;
    private SearchWidget searchWidget;
    private SearchResultsPage searchResults;

    public GitHubMainPage(final WebDriver driver)
    {
        this.driver=driver;
        this.searchWidget= PageFactory.initElements(driver,SearchWidget.class);
        this.searchResults=PageFactory.initElements(driver, SearchResultsPage.class);
    }

    public void goTo()
    {
        this.driver.get("https://github.com");
    }

    public SearchWidget getSearchWidget()
    {
        return searchWidget;
    }

    public SearchResultsPage getSearchResults()
    {
        return searchResults;
    }

}
