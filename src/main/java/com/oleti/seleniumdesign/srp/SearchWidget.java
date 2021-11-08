package com.oleti.seleniumdesign.srp;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchWidget extends AbstractComponent{

    @FindBy(xpath = "//input[@data-test-selector='nav-search-input']")
    private WebElement searchBox;




    public SearchWidget(WebDriver driver) {
        super(driver);
    }


    public void enter(String keyword)
    {
        this.searchBox.clear();
        this.searchBox.sendKeys(keyword);
        this.searchBox.sendKeys(Keys.ENTER);

    }


    @Override
    public boolean isDisplayed() {
        return this.wait.until((driver) -> this.searchBox.isDisplayed());
    }
}
