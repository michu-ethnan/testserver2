package com.deosite.tests.pages;

import net.serenitybdd.screenplay.targets.Target;

public class HomePage {

    public static Target SECOND_BANNER = Target.the("Recently viewed product").locatedBy("//*[@id=\"__app__\"]/div[2]/div[3]/div/div[3]/div/div[1]");
    public static Target MAIN_BANNER = Target.the("Main banner").locatedBy("//*[@id=\"__app__\"]/div[2]/div[3]/div" +
            "/div[1]/div/div/div[1]");
    public static Target INSPIRATIONS_BANNER = Target.the("Inspirations banner").locatedBy("//*[@id=\"__app__\"]/div" +
            "[2]/div[3]/div/div[8]/div");
    public static Target DAJAR_LOGO = Target.the("Dajar logo").locatedBy("(//a[@title='Dajar'])[1]");
}
