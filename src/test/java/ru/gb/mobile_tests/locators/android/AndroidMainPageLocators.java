package ru.gb.mobile_tests.locators.android;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import ru.gb.mobile_tests.locators.interfaceces.MainPageLocators;

public class AndroidMainPageLocators implements MainPageLocators {
    @Override
    public By mainMenuLoginButton(){
        return MobileBy.AccessibilityId("Login");
    }

}
