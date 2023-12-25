package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResults extends BasePage{

    @FindBy(className = "firstHeading")
    private WebElement pageTitle;

    public String getPageText()
    {
        this.isElementDisplayed(this.pageTitle);
        return this.pageTitle.getText();
    }
    public SearchResults(WebDriver driver){
        super(driver);
    }
}
