package com.globant.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomeScreen extends BaseScreen {

    @AndroidFindBy(className="//android.widget.Button[@content-desc=\"Webview\"]")
    private AndroidElement createAccountBtn;

    public HomeScreen(AndroidDriver<AndroidElement> driver)
    {
        super(driver);
    }


    public void clickOnCreateAccountBtn(){
        clickOnElement(this.createAccountBtn);
    }

}
