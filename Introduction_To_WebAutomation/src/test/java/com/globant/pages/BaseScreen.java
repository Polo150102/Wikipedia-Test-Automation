package com.globant.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseScreen {

    AndroidDriver<AndroidElement> driver;

    public BaseScreen(AndroidDriver<AndroidElement> driver)
    {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(
                driver), this);
    }

    protected void clickOnElement(AndroidElement element){
        WebDriverWait wait = new WebDriverWait(driver, 15);
        //Usa wait para ver si un elemento es mostrado en pantalla
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

}
