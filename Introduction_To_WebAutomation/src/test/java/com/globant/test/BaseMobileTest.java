package com.globant.test;

import com.globant.pages.HomePage;
import com.globant.pages.HomeScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;


public class BaseMobileTest {
    SoftAssert softAssert = new SoftAssert();
    public static AndroidDriver<AndroidElement> driver;

    Dotenv dotenv;

    //public Logger log = LoggerFactory.getLogger(BaseMobileTest.class);

    @BeforeTest
    public void beforeTest(){
        dotenv = Dotenv.load();
        DesiredCapabilities capabilities = this.environmentSetup();
        try{
            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723"),
                    capabilities);
        }
        catch (MalformedURLException exception)
        {
            exception.printStackTrace();
        }
        //log.info("Appium Session ID: "+ driver.getSessionId());
        //log.info("Driver CapabilitieS: "+ driver.getCapabilities().asMap());
    }

    private DesiredCapabilities environmentSetup()
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, dotenv.get("DEVICE_NAME"));
        capabilities.setCapability("appium:appPackage","com.wdiodemoapp");
        capabilities.setCapability("appium:appActivity", "com.wdiodemoapp.MainActivity");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,dotenv.get("PLATFORM_NAME"));
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,dotenv.get("AUTOMATION_NAME"));

        return capabilities;
    }

    public HomeScreen getHomeScreen()
    {
        return new HomeScreen(driver);
    }

    @AfterTest
    public void afterTest()
    {
        //driver.quit();
    }
}
