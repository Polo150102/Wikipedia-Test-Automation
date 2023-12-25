package com.globant.test;

import com.globant.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

public class BaseTest {
    SoftAssert softAssert = new SoftAssert();
    WebDriver driver = null;
    HomePage homePage;

    @BeforeTest
    public void beforeTest(){
        String driverpath = "/Users//aleja//OneDrive//Documents//Globant-Curso//Guia_WebAutomation//Introduction_To_WebAutomation//src//Utils//chromedriver.exe";

        System.setProperty("webdriver.chrome.driver", driverpath);

        driver = new ChromeDriver();
    }

    @AfterTest
    public void afterTest()
    {
        driver.close();
    }

    public HomePage getHomePage()
    {
        return new HomePage(driver,"https://wikipedia.org/");
    }
}
