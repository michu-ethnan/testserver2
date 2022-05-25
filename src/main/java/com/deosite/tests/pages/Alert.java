package com.deosite.tests.pages;

import net.serenitybdd.screenplay.targets.Target;

public class Alert {

    public static Target ALERT_BOX = Target.the("Added to cart alert").locatedBy("//div[@data-test='message-success']//p");
}
