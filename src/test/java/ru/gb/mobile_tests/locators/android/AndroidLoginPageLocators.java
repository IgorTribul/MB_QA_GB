package ru.gb.mobile_tests.locators.android;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import ru.gb.mobile_tests.locators.interfaceces.LoginPageLocators;

public class AndroidLoginPageLocators implements LoginPageLocators {
    public By loginButton(){
        return MobileBy.AccessibilityId("button-LOGIN");
    }
    public By signUpContainerButton(){
        return By.xpath("//android.view.ViewGroup[@content-desc=\"button-sign-up-container\"]/android.view.ViewGroup/android.widget.TextView");
    }

    public By loginErrorText(){
        return By.xpath("//android.widget.ScrollView[@content-desc=\"Login-screen\"]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.TextView[1]");
    }

}
