package com.deosite.tests.pages;

import net.serenitybdd.screenplay.targets.Target;

public class LoginPage {

    public static Target LOGIN_BUTTON = Target.the("Login Button").locatedBy("//a[@data-test='login-link']");
    public static Target EMAIL_INPUT = Target.the("Email input").locatedBy("//input[@name='email']");
    public static Target PASSWORD_INPUT = Target.the("Password input").locatedBy("//input[@name='password']");
    public static Target SUBMIT_BUTTON = Target.the("Submit button").locatedBy("//button[@data-test='login-button']");
    public static Target MY_ACCOUNT_BUTTON = Target.the("My Account Button").locatedBy("//a[@data-test='my-account-link']");
}