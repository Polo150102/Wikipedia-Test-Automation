package com.globant.test;

import com.globant.pages.HomeScreen;
import org.testng.annotations.Test;

public class FirstMobileTest extends BaseMobileTest{


    @Test(groups = "mobile")
    public void testMobile(){

        HomeScreen homeScreen = getHomeScreen();
        homeScreen.clickOnCreateAccountBtn();

        //log.info("First test");
    }
}
