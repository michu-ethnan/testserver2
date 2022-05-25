package com.deosite.tests.pages;

import net.serenitybdd.screenplay.targets.Target;

public class CookiesNotification {

    public static Target ACCEPT_COOKIES_BUTTON = Target.the("Accept Cookies Button").locatedBy("//button[@data-test='accept-cookies-button']");
    public static Target SEE_MORE_BUTTON = Target.the("See more button").locatedBy("//*[@id=\"__app__\"]/div[1]/div" +
            "/div/p/span");
    public static Target COOKIES_POLICY = Target.the("Cookies policy").locatedBy("//*[@id=\"__app__\"]/div[1]/div/div" +
            "/p/a");
    public static Target SELECT_COOKIES_BUTTON = Target.the("Select cookies button").locatedBy("//*[@id=\"__layers__\"]/div/div[2]/div/div[3]/div/div/div/div[1]/div/div/div/button[2]/div[1]");
    public static Target ACCEPT_SELECTED_COOKIES_BUTTON = Target.the("Accept selected cookies button").locatedBy(
            "//*[@id=\"__layers__\"]/div/div[2]/div/div[3]/div/div/div/div[2]/div[6]/button[1]");
    public static Target ANALYTICAL_COOKIES_TAB = Target.the("Analytical cookies tab").locatedBy("//button[@id" +
            "='analytic" +
            "']");
    public static Target TRACKING_COOKIES_TAB = Target.the("Tracking cookies tab").locatedBy("//button[@id='tracking" +
            "']");
    public static Target ANALYTICAL_COOKIES_CHECKBOX = Target.the("Analytical cookies checkbox").locatedBy("//*[@id" +
            "=\"analytic\"]/div/div/div[1]/div/div");
    public static Target TRACKING_COOKIES_CHECKBOX = Target.the("Tracking cookies checkbox").locatedBy("//*[@id" +
            "=\"tracking\"]/div/div/div[1]/div/div");

}
