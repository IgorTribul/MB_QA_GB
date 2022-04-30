package ru.gb.mobile_tests.base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.android.AndroidDriver;
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
import static com.codeborne.selenide.Selenide.closeWindow;

public class BaseTest {
    public MainPage openApp(){
        WebDriver driver = null;
        try {
           driver = getAndroidDriver();
        }catch (MalformedURLException | URISyntaxException e){
            e.printStackTrace();
            System.out.println("Problem with URL or filepath");
        }
        WebDriverRunner.setWebDriver(driver);
        return new MainPage();
    }

    public WebDriver getAndroidDriver() throws MalformedURLException, URISyntaxException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Pixel");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "10");
        capabilities.setCapability("udid", "emulator-5554");
        capabilities.setCapability("automationName", "UiAutomator2");
        URL resource = getClass().getClassLoader().getResource("Android-NativeDemoApp-0.2.1.apk");
        File file = Paths.get(resource.toURI()).toFile();
        String absolutePath = file.getAbsolutePath();
        capabilities.setCapability("app", absolutePath);

        Configuration.reportsFolder = "screenshots/actual";

        return new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @AfterClass
    public void setDown(){
        close();
    }

}
