package com.oleti.seleniumdesign.srp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchSuggestion extends AbstractComponent{

    private WebDriverWait wait;

    @FindBy (css = "js-navigation-item js-jump-to-suggestion")
    private List<WebElement> suggestions;

    public SearchSuggestion(WebDriver driver) {
        super(driver);
    }


    public void clickSuggestionByIndex(int index)
    {
        this.suggestions.get(index-1).click();
    }

    @Override
    public boolean isDisplayed() {

        return this.wait.until(d -> this.suggestions.size()>2);

    }
}
