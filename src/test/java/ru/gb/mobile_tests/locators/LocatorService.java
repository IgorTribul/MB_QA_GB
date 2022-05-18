package ru.gb.mobile_tests.locators;

import ru.gb.mobile_tests.locators.android.AndroidLoginPageLocators;
import ru.gb.mobile_tests.locators.android.AndroidMainPageLocators;
import ru.gb.mobile_tests.locators.android.AndroidSignUpPageLocators;
import ru.gb.mobile_tests.locators.interfaceces.LoginPageLocators;
import ru.gb.mobile_tests.locators.interfaceces.MainPageLocators;
import ru.gb.mobile_tests.locators.interfaceces.SignUpPageLocators;
import ru.gb.mobile_tests.locators.ios.IOSLoginPageLocators;
import ru.gb.mobile_tests.locators.ios.IOSMainPageLocators;
import ru.gb.mobile_tests.locators.ios.IOSSignUpPageLocators;

public class LocatorService {
    public static final LoginPageLocators LOGIN_PAGE_LOCATORS = System.getProperty("platform")
            .equals("Android") ? new AndroidLoginPageLocators() : new IOSLoginPageLocators();
    public static final MainPageLocators MAIN_PAGE_LOCATORS = System.getProperty("platform")
            .equals("Android") ? new AndroidMainPageLocators() : new IOSMainPageLocators();
    public static final SignUpPageLocators SIGN_UP_PAGE_LOCATORS = System.getProperty("platform")
            .equals("Android") ? new AndroidSignUpPageLocators() : new IOSSignUpPageLocators();
}
