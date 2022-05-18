package ru.gb.mobile_tests.base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import ru.gb.mobile_tests.pages.MainPage;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

import static com.codeborne.selenide.Selenide.close;

public class BaseTest {
    public MainPage openApp(){
        WebDriver driver = null;
        try {
           driver = getAppiumDriver();
        }catch (MalformedURLException | URISyntaxException e){
            e.printStackTrace();
            System.out.println("Problem with URL or filepath");
        }
        WebDriverRunner.setWebDriver(driver);
        return new MainPage();
    }

    public WebDriver getAppiumDriver() throws MalformedURLException, URISyntaxException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        switch (System.getProperty("platform")){
            case "Android" :
                capabilities.setCapability("deviceName", "Pixel");
                capabilities.setCapability("platformName", "Android");
                capabilities.setCapability("platformVersion", "10");
                capabilities.setCapability("udid", "emulator-5554");
                capabilities.setCapability("automationName", "UiAutomator2");
                URL resource = getClass().getClassLoader().getResource("Android-NativeDemoApp-0.2.1.apk");
                File file = Paths.get(resource.toURI()).toFile();
                String absolutePath = file.getAbsolutePath();
                capabilities.setCapability("app", absolutePath);
                break;
            case "iOS" :
                capabilities.setCapability("deviceName", "iPhone");
                capabilities.setCapability("platformName", "iOS");
                capabilities.setCapability("platformVersion", "15");
                capabilities.setCapability("udid", "2E20F3A4-ACC1-4799-A4F5-83358E56AB2E");
                capabilities.setCapability("automationName", "XCUITest");
                URL resource1 = getClass().getClassLoader().getResource("iOS-RealDevice-NativeDemoApp-0.2.1.ipa.zip");
                File file1 = Paths.get(resource1.toURI()).toFile();
                String absolutePath1 = file1.getAbsolutePath();
                capabilities.setCapability("app", absolutePath1);
                break;
        }

        Configuration.reportsFolder = "screenshots/actual";

        return new AppiumDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @AfterClass
    public void setDown(){
        close();
    }

}
