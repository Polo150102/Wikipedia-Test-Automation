package StepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import static io.restassured.RestAssured.given;

public class TestStarWars {

    private WebDriver driver;

    private String characterName;


    @Before
    public void setup()
    {
        driver = new ChromeDriver();
    }

    @Given("I am an user at the Wikipedia WebPage requesting SW character {int}")
    public void Given_I_am_an_user_at_the_Wikipedia_WebPage_requesting_SW_character(Integer number)
    {

        driver.get("https://wikipedia.org");
        driver.manage().window().maximize();
        characterName = getStarWarsCharacter(number);
    }

    @When("I search the requested character name on Wikipedia search page")
    public void I_search_the_requested_character_name_on_Wikipedia_search_page() throws InterruptedException {
        WebElement searchInput = driver.findElement(By.id("searchInput"));
        searchInput.sendKeys(characterName);
        WebElement searchButton = driver.findElement(By.cssSelector("#search-form > fieldset > button > i"));
        searchButton.click();
        Thread.sleep(2000);

    }

    @Then("I should be able to see the article page correctly displayed for the requested character")
    public void I_should_be_able_to_see_the_article_page_correctly_displayed_for_the_requested_character() {
        WebElement pageTitle = driver.findElement(By.cssSelector(".mw-page-title-main"));
        Assert.assertTrue(pageTitle.isDisplayed());
        Assert.assertEquals(characterName, pageTitle.getText());

    }

    private String getStarWarsCharacter(int characterNUmber)
    {
        Response responseCharacter;
        responseCharacter = given().get("https://swapi.dev/api/people/"+characterNUmber+"/");
        Assert.assertEquals(responseCharacter.getStatusCode(),200);
        String name_character = responseCharacter.path("name");

        return name_character;
    }

    @After
    public void quitBrowser()
    {
        driver.quit();
    }
}
