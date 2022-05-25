package com.deosite.tests.pages;

import net.serenitybdd.screenplay.targets.Target;

public class CardPaymentPage {

    public static Target FIRST_BANK_LOGO = Target.the("Bank Logo").locatedBy("/html/body/main/div[2]/div[3]/section/div/a[1]");

    public static Target LOGIN_BUTTON = Target.the("Login Button").locatedBy("/html/body/div/div/div/main/div/div/form/button");

    public static Target PAYMENT_BUTTON = Target.the("Payment Button").locatedBy("//*[@id=\"pay_by_link_pay\"]");

    public static Target ACCEPT_BUTTON = Target.the("Accept button").locatedBy("//*[@id=\"reagulation-accept-button" +
            "\"]");
}
