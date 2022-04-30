package ru.gb.mobile_tests.locators;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class MainPageLocators {
    public By mainMenuLoginButton(){
        return MobileBy.AccessibilityId("Login");
    }

}
