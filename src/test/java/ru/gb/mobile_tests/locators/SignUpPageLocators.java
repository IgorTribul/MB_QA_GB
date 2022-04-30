package ru.gb.mobile_tests.locators;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class SignUpPageLocators {
    public static String ALERT_TEXT_POSITIVE = "You successfully signed up!";
    public static String ALERT_TEXT_NEGATIVE = "Some fields are not valid!";

    public By emailField(){
        return MobileBy.AccessibilityId("input-email");
    }
    public By passwordField(){
        return MobileBy.AccessibilityId("input-password");
    }
    public By repeatPasswordField(){
        return MobileBy.AccessibilityId("input-repeat-password");
    }
    public By alertTitle(){
        return MobileBy.AccessibilityId("android:id/alertTitle");
    }
    public By signUpButton(){
        return MobileBy.AccessibilityId("button-SIGN UP");
    }
    public By alertMessage(){
        return By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView");
    }


}
