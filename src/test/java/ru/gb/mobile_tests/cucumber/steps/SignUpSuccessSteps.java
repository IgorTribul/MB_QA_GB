package ru.gb.mobile_tests.cucumber.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ru.gb.mobile_tests.base.BaseTest;
import ru.gb.mobile_tests.pages.LoginPage;
import ru.gb.mobile_tests.pages.SignUpPage;

public class SignUpSuccessSteps extends BaseTest {
    SignUpPage signUpPage;

    @Given("User is on Sign Up page")
    public void user_is_on_Sign_Up_page() {
        signUpPage = openApp()
                .clickMainMenuLoginButton()
                .openSignUpPage();
    }

    @When("User send valid email address")
    public void user_send_valid_email_address() {
        signUpPage.sendEmailAddressPositive();
    }

    @When("User send valid password")
    public void user_send_valid_password() {
        signUpPage.sendPasswordPositive();
    }

    @When("User confirm valid password")
    public void user_confirm_valid_password() {
        signUpPage.sendRepeatPasswordPositive();
    }

    @When("User click sign up button")
    public void user_click_sign_up_button() {
        signUpPage.clickSignUpButton();
    }

    @Then("User should see message {string}")
    public void user_should_see_message(String string) {
        signUpPage.checkAlertMessageTextPositive("You successfully signed up!");
    }
}

