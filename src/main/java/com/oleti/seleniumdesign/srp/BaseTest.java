package com.oleti.seleniumdesign.srp;

import com.oleti.utils.logs.Log;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest {

    public WebDriver driver;

    @Parameters("browser")
    @BeforeTest
    public void setupDriver(String browser)
    {
        if(browser.equalsIgnoreCase("firefox"))
        {
            Log.info("Setting Up firefox Driver");
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();
        }
        if(browser.equalsIgnoreCase("chrome")) {
            Log.info("Setting Up Chrome Driver");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
    }

    @AfterTest
    public void tearDown()
    {
        Log.info("Browser Quit");
       driver.quit();
    }

    public  WebDriver getDriver()
    {
         return driver;
    }
}
