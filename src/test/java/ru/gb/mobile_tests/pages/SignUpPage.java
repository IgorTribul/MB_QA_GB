package ru.gb.mobile_tests.pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import ru.gb.mobile_tests.locators.SignUpPageLocators;

import static com.codeborne.selenide.Selenide.$;
import static ru.gb.mobile_tests.locators.SignUpPageLocators.ALERT_TEXT_NEGATIVE;
import static ru.gb.mobile_tests.locators.SignUpPageLocators.ALERT_TEXT_POSITIVE;

public class SignUpPage {
    public SignUpPageLocators locator(){
        return new SignUpPageLocators();
    }

    @Step("Вводим валидный email")
    public SignUpPage sendEmailAddressPositive(){
        $(locator().emailField()).sendKeys("1@1.ru");
        return new SignUpPage();
    }
    @Step("Вводим невалидный email")
    public SignUpPage sendEmailAddressNegative(){
        $(locator().emailField()).sendKeys("фвфвы");
        return new SignUpPage();
    }
    @Step("Вводим валидный password")
    public SignUpPage sendPasswordPositive(){
        $(locator().passwordField()).sendKeys("12345678");
        return new SignUpPage();
    }
    @Step("Повторно вводим валидный password")
    public SignUpPage sendRepeatPasswordPositive(){
        $(locator().repeatPasswordField()).sendKeys("12345678");
        return new SignUpPage();
    }
    @Step("Кликаем по кнопке логин в форме")
    public SignUpPage clickSignUpButton(){
        $(locator().signUpButton()).click();
        return new SignUpPage();
    }
    @Step("Проверяем текс сообщения об ошибке регистрации")
    public void checkAlertMessageTextPositive(String string){
        $(locator().alertMessage()).shouldHave(Condition.text(string));
//        return new SignUpPage();
    }
    @Step("Проверяем текс сообщения об успешной регистрации")
    public SignUpPage checkAlertMessageTextNegative(String string){
        $(locator().alertMessage()).shouldHave(Condition.text(string));
        return new SignUpPage();
    }





}
