package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected boolean isElementDisplayed(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 15);
        //Usa wait para ver si un elemento es mostrado en pantalla
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.isDisplayed();
    }
}
