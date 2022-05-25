package ru.gb.mobile_tests.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import ru.gb.mobile_tests.locators.MainPageLocators;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    public MainPageLocators locator (){
        return new MainPageLocators();
    }
    @Step("Кликаем по кнопке Login в меню на главном экране")
    public LoginPage clickMainMenuLoginButton(){
        $(locator().mainMenuLoginButton()).click();
        return new LoginPage();
    }
}
