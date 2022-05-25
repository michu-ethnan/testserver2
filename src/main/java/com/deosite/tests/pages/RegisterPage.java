package com.deosite.tests.pages;

import net.serenitybdd.screenplay.targets.Target;

public class RegisterPage {

    public static Target REGISTER_BUTTON = Target.the("Register Button").locatedBy("(//a[@data-test='registration-link'])[1]");
    public static Target NAME_INPUT = Target.the("Name input").locatedBy("//input[@name='firstName']");
    public static Target LAST_NAME_INPUT = Target.the("Last name input").locatedBy("//input[@name='lastName']");
    public static Target AGREEMENT_CHECKBOX = Target.the("Agreement checkbox").locatedBy("(//div[@data-test='registration-agreement'])[1]");
    public static Target REGISTER_SUBMIT_BUTTON = Target.the("Submit button").locatedBy("//button[@type='submit']");
}
