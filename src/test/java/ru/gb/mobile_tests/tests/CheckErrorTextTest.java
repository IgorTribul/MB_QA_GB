package ru.gb.mobile_tests.tests;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.gb.mobile_tests.base.BaseTest;
import ru.gb.mobile_tests.listeners.AllureListener;

@Listeners(AllureListener.class)
public class CheckErrorTextTest extends BaseTest {

    @Test
    @Description("Проверяем сообщение об ошибке при невалидном email")
    public void checkEmptyEmail(){
        openApp()
                .clickMainMenuLoginButton()
                .clickLoginButton()
                .checkLoginErrorText();
    }
}
