package ru.gb.mobile_tests;

import io.appium.java_client.MobileBy;
import org.testng.annotations.Test;
import ru.gb.mobile_tests.base.BaseTest;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;

public class ScreenshotHelper extends BaseTest {

    @Test
    public void createScreen(){
        openApp();
        File actualScreen = $(MobileBy.AccessibilityId("Home-screen")).screenshot();
    }
}
