package ru.gb.mobile_tests.pages;

import io.qameta.allure.Step;
import ru.gb.mobile_tests.locators.LocatorService;
import ru.gb.mobile_tests.locators.interfaceces.MainPageLocators;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    public MainPageLocators locator (){
        return LocatorService.MAIN_PAGE_LOCATORS;
    }
    @Step("Кликаем по кнопке Login в меня на главном экране")
    public LoginPage clickMainMenuLoginButton(){
        $(locator().mainMenuLoginButton()).click();
        return new LoginPage();
    }
}
