package ru.gb.mobile_tests;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class MyFirstTest {
    @BeforeEach
    public DesiredCapabilities prepareCapability() throws MalformedURLException, URISyntaxException {
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
        return capabilities;
    }

    @Test
    public void CheckAuth() throws MalformedURLException, URISyntaxException {
        MobileDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), prepareCapability());
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        MobileElement menuLoginButton = (MobileElement) driver.findElementByAccessibilityId("Login");
        menuLoginButton.click();
        MobileElement loginButton = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"button-LOGIN\"]/android.view.ViewGroup");
        loginButton.click();
        MobileElement error = (MobileElement) driver.findElementByXPath("//android.widget.ScrollView[@content-desc=\"Login-screen\"]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.TextView[1]");
        error.click();
        Assert.assertEquals(error.getText(), "Please enter a valid email address");
        driver.quit();
    }
    @Test
    public void CheckSignUpPositive() throws MalformedURLException, URISyntaxException {
        MobileDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), prepareCapability());
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        MobileElement loginButton = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"Login\"]/android.widget.TextView");
        loginButton.click();
        MobileElement signUpButton = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"button-sign-up-container\"]/android.view.ViewGroup/android.widget.TextView");
        signUpButton.click();
        MobileElement email = (MobileElement) driver.findElementByAccessibilityId("input-email");
        email.sendKeys("1@1.ru");
        MobileElement password = (MobileElement) driver.findElementByAccessibilityId("input-password");
        password.sendKeys("12345678");
        MobileElement repeatPassword = (MobileElement) driver.findElementByAccessibilityId("input-repeat-password");
        repeatPassword.sendKeys("12345678");
        MobileElement signUpClick = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"button-SIGN UP\"]/android.view.ViewGroup");
        signUpClick.click();
        MobileElement alertTitle = (MobileElement) driver.findElementById("android:id/alertTitle");
        alertTitle.click();
        MobileElement message = (MobileElement) driver.findElementById("android:id/message");
        message.click();
        Assert.assertEquals(alertTitle.getText(), "Signed Up!");
        Assert.assertEquals(message.getText(), "You successfully signed up!");
        driver.quit();
    }
    @Test
    public void CheckSignUpNegative() throws MalformedURLException, URISyntaxException {
        MobileDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), prepareCapability());
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        MobileElement loginButton = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"Login\"]/android.widget.TextView");
        loginButton.click();
        MobileElement signUpButton = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"button-sign-up-container\"]/android.view.ViewGroup/android.widget.TextView");
        signUpButton.click();
        MobileElement email = (MobileElement) driver.findElementByAccessibilityId("input-email");
        email.sendKeys("1@1.ru");
        MobileElement password = (MobileElement) driver.findElementByAccessibilityId("input-password");
        password.sendKeys("12345678");
        MobileElement repeatPassword = (MobileElement) driver.findElementByAccessibilityId("input-repeat-password");
        repeatPassword.sendKeys("12345699");
        MobileElement signUpClick = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"button-SIGN UP\"]/android.view.ViewGroup");
        signUpClick.click();
        MobileElement alertTitle = (MobileElement) driver.findElementById("android:id/alertTitle");
        alertTitle.click();
        MobileElement message = (MobileElement) driver.findElementById("android:id/message");
        message.click();
        Assert.assertEquals(alertTitle.getText(), "Failure");
        Assert.assertEquals(message.getText(), "Some fields are not valid!");
        driver.quit();
    }
}
