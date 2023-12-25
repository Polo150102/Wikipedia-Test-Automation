package com.globant.test;

import com.globant.pages.HomePage;
import com.globant.pages.SearchResults;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class FirstTest extends BaseTest {

    /*WebDriver driver = null;
    HomePage homePage;*/
    //SoftAssert softAssert = new SoftAssert();

    /*@BeforeTest
    public void beforeTest(){
        String driverpath = "/Users//aleja//OneDrive//Documents//Globant-Curso//Guia_WebAutomation//Introduction_To_WebAutomation//src//Utils//chromedriver.exe";

        System.setProperty("webdriver.chrome.driver", driverpath);

        driver = new ChromeDriver();

        homePage = new HomePage(driver, "https://wikipedia.org/");
    }

    @AfterTest
    public void afterTest()
    {
        driver.close();
    }*/

    @Test
    public void testWikiYoutubeTutorial(){
        HomePage homepage = getHomePage();
        //String driverpath = "/Users//aleja//OneDrive//Documents//Globant-Curso//Guia_WebAutomation//Introduction_To_WebAutomation//src//Utils//chromedriver.exe";
        //System.setProperty("webdriver.chrome.driver", driverpath);
        //driver = new ChromeDriver();

        //driver.navigate().to("https://wikipedia.org/");

        WebElement searchInput = driver.findElement(By.id("searchInput"));
        //WebElement footerlink = driver.findElement(By.xpath("/html/body/div[10]/div[1]/div/div[3]/a/span"));

        //WebElement footerlink = driver.findElement(By.cssSelector(".footer-sidebar .footer-sidebar-text .jsl10n"));


        searchInput.sendKeys("Selenium");

        //String text = footerlink.getText();
        //System.out.println("Texto del elemento 1 : " + text);
        /*
        tring text = footerlink.getText();
        System.out.println("Texto del elemento: " + text);*/
        //Assert.assertEquals(footerlink.getText(),"Puedes apoyar nuestro trabajo con una donación.");

        WebElement submitBtn = driver.findElement(By.cssSelector("button[type=\"submit\"]"));

        //List<WebElement> lang_list = driver.findElements(By.className("central-featured-lang"));

        WebDriverWait wait = new WebDriverWait(driver, 30);

        WebElement footerlink =
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".footer-sidebar .footer-sidebar-text .jsl10n")));

        List<WebElement> lang_list =
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("central-featured-lang")));

        //Assert.assertEquals(footerlink.getText(),"Puedes apoyar nuestro trabajo con una donación.");
        softAssert.assertEquals(footerlink.getText(),"Puedes apoyar nuestro trabajo con una donación.");

        //Assert.assertEquals(lang_list.size(),10);
        softAssert.assertEquals(lang_list.size(),10);

        //Assert.assertTrue(submitBtn.isDisplayed());
        softAssert.assertTrue(submitBtn.isDisplayed());

        submitBtn.click();
        //driver.close();
        softAssert.assertAll();
    }

    @Test
    public void testWikipediaUsingPOM(){
        HomePage homePage = getHomePage();
        homePage.setBarText("Selenium");

        softAssert.assertEquals(homePage.getFooterText(),"Puedes apoyar nuestro trabajo con una donación.");

        SearchResults searchResults = homePage.clickOnSearch();

        softAssert.assertEquals(searchResults.getPageText(),"Selenium");

        softAssert.assertAll();
    }
}
