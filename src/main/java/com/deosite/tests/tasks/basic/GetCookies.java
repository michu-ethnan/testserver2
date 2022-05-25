package com.deosite.tests.tasks.basic;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.util.Set;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class GetCookies implements Task {

    @Override
    @Step("{0} gets cookies")
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = getDriver();
        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println(cookies);
    }

    public static GetCookies cookies() {
        return new GetCookies();
    }
}
