package ru.gb.mobile_tests.pages;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import ru.gb.mobile_tests.locators.LocatorService;
import ru.gb.mobile_tests.locators.interfaceces.LoginPageLocators;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    public LoginPageLocators locator(){
        return LocatorService.LOGIN_PAGE_LOCATORS;
    }

    @Step("Кликаем по кнопке логин в форме")
    public LoginPage clickLoginButton(){
        $(locator().loginButton()).click();
        return new LoginPage();
    }
    @Step("Переходим в форму регистрации нового пользователя")
    public SignUpPage openSignUpPage() {
        $(locator().signUpContainerButton()).click();
        return new SignUpPage();
    }
    @Step("Проверяем текст ошибки")
    public LoginPage checkLoginErrorText(){
        $(locator().loginErrorText())
                .shouldHave(Condition.text("Please enter a valid email address"));
        return new LoginPage();
    }
}
