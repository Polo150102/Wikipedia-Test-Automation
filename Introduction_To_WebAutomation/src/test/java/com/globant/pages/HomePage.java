package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(id = "searchInput")
    private WebElement searchInput;

    @FindBy(css = "button[type=\"submit\"]")
    private WebElement submitBtn;

    @FindBy(css = ".footer-sidebar .footer-sidebar-text .jsl10n")
    private WebElement footerText;

    @FindBy(className = "central-featured-lang")
    private List<WebElement> lang_list;


    public void setBarText(String text){
        this.searchInput.sendKeys(text);
    }

    public SearchResults clickOnSearch(){
        this.submitBtn.click();
        return new SearchResults(this.driver);
    }

    public String getFooterText()
    {
        this.isElementDisplayed(this.footerText);
        return this.footerText.getText();
    }

    public HomePage(WebDriver driver, String url){
        super(driver);
        this.driver.get(url);
    }
}