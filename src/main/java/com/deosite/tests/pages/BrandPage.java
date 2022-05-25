package com.deosite.tests.pages;

import net.serenitybdd.screenplay.targets.Target;

public class BrandPage {
    public static Target BRAND_LIST = Target.the("Brand list").locatedBy("//*[@id=\"__app__\"]//div/button[@url]");
}
