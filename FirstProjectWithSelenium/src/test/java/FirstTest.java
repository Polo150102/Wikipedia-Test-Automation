import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//import org.testng.annotations.Test;
import org.junit.Test;
import org.junit.Assert;

import java.util.List;

import static java.lang.Thread.sleep;

public class FirstTest {
    WebDriver driver = null;

    @Test
    public void testWiki()
    {
        String driverPath = "/Users/aleja/OneDrive/Documents/Globant-Curso/Guia_WebAutomation/FirstProjectWithSelenium/src/utils/chromedriver-win64/chromedriver.exe";

        System.setProperty("webdriver.chrome.driver", driverPath);

        driver = new ChromeDriver();

        //Navigate to the webpage (https://wikipedia.org)
        driver.navigate().to("https://wikipedia.org");

        //Write in the search box the text “Microsoft”
        WebElement searchInput = driver.findElement(By.id("searchInput"));
        searchInput.sendKeys("Microsoft");

        //Wait for the new webpage to load
        WebElement searchButton = driver.findElement(By.cssSelector("#search-form > fieldset > button > i"));
        searchButton.click();
        //Get the title of the new webpage and check if it matches with “Microsoft”,
        // print a message in the console indicating whether it matches or not.

        WebElement pageTitle = driver.findElement(By.cssSelector("#firstHeading > span"));
        Assert.assertEquals(pageTitle.getText(),"Microsoft");

        if(pageTitle.getText().equals("Microsoft"))
        {
            System.out.println("The page title matches 'Microsoft'.");
        }else{
            System.out.println("The page title does not match 'Microsoft'.");
        }

        //Get all the anchor links on the web page (hint: find by HTML tag “a”),
        // and for each one of them, print on the console its respective text.
        List<WebElement> listaEtiquetas = driver.findElements(By.tagName("a"));
        for(WebElement elementA : listaEtiquetas){
            String texto = elementA.getText(); //Obtiene el texto dentro de la etiqueta <a>
            String href = elementA.getAttribute("href"); //Obtiene el valor del atributo href, osea enlaces
            System.out.println("Texto:" + texto);
            System.out.println("href: " + href);
            System.out.println("-----------------");
        }

        //sleep(3000);

        //driver.close();
        driver.quit();
    }

}
