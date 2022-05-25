package ru.gb.mobile_tests.cucumber.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ru.gb.mobile_tests.base.BaseTest;
import ru.gb.mobile_tests.pages.LoginPage;

public class LoginSteps extends BaseTest {
    LoginPage loginPage;

    @Given("User is on Login page")
    public void user_is_on_Login_page() {
        loginPage = openApp().clickMainMenuLoginButton();
    }

    @When("User click login button")
    public void user_click_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("User should see error message {string}")
    public void user_should_see_error_message(String string) {
        loginPage.checkLoginErrorText(string);
    }
}
