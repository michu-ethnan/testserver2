package com.deosite.tests.pages;

import net.serenitybdd.screenplay.targets.Target;

public class SuccessPage {

    public static Target SUCCESS_ORDER_MESSAGE = Target.the("Success order message").locatedBy("//div[@data-test='thank-you-header']");
    public static Target ADDITIONAL_SUCCESS_INFO = Target.the("Additional success info").locatedBy("//div[@data-test='additional-success-info']");

    public static Target BACK_TO_HOME_PAGE_BUTTON = Target.the("Back to home page button").locatedBy("//a[@data-test='back-to-home-page']");

}
