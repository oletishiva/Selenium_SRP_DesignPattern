package com.oleti.seleniumdesign.srp;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ResultStat extends AbstractComponent{

    @FindBy(css = "div[class='d-flex flex-column flex-md-row flex-justify-between border-bottom pb-3 position-relative'] h3")
    private WebElement searchCountStat;


    @FindBy(xpath = "//li//div[@class='f4 text-normal']//a[text()]")
    private List<WebElement> repositoryResults;

    public ResultStat(WebDriver driver) {
        super(driver);
    }

    public String  getSearchRepoCount()
    {
        return this.searchCountStat.getText();
    }


    public List<WebElement> getRepositoryNames()
    {
         return this.repositoryResults;
    }

    @Override
    public boolean isDisplayed() {
        Uninterruptibles.sleepUninterruptibly(1000, TimeUnit.MILLISECONDS);
        return this.wait.until((driver) -> this.searchCountStat.isDisplayed());
    }
}
