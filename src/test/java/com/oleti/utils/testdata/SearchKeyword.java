package com.oleti.utils.testdata;

import org.testng.annotations.DataProvider;

public class SearchKeyword {


    @DataProvider(name = "searchKeyword")
    public Object[][] searchKeywordData(){
        return new Object[][] {{"cypress"}, {"selenium"},{"ROBOTFRAMEWORK"}, {"data +ana"},{"MetRIcs"},{" appium "},{"*&*"}};
    }


}
