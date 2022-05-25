package ru.gb.mobile_tests.tests;
import jdk.jfr.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.gb.mobile_tests.base.BaseTest;
import ru.gb.mobile_tests.listeners.AllureListener;


@Listeners(AllureListener.class)
public class CheckSignUpFormTests extends BaseTest {

    @Test
    @Description("Проверяем успешную регистрацию")
    public void checkSignUpPositive(){
        openApp()
                .clickMainMenuLoginButton()
                .openSignUpPage()
                .sendEmailAddressPositive()
                .sendPasswordPositive()
                .sendRepeatPasswordPositive()
                .clickSignUpButton()
                .checkAlertMessageTextPositive("You successfully signed up!");
    }

    @Test
    @Description("Проверяем неуспешную регистрацию")
    public void checkSignUpNegative(){
        openApp()
                .clickMainMenuLoginButton()
                .openSignUpPage()
                .sendEmailAddressNegative()
                .sendPasswordPositive()
                .sendRepeatPasswordPositive()
                .clickSignUpButton()
                .checkAlertMessageTextNegative("Some fields are not valid!");
    }
}
