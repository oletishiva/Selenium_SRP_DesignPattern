package com.oleti.seleniumdesign.srp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchResultsPage {

    private SearchWidget searchWidget;
    private ResultStat resultStat;

    public SearchResultsPage(final WebDriver driver)
    {
        this.searchWidget= PageFactory.initElements(driver,SearchWidget.class);
        this.resultStat=PageFactory.initElements(driver,ResultStat.class);
    }

    public SearchWidget getSearchWidget() {
        return searchWidget;
    }

    public ResultStat getResultStat() {
        return resultStat;
    }


}
