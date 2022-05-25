package com.deosite.tests.actions;

import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static com.deosite.tests.pages.LoginPage.LOGIN_BUTTON;

public class OpenLoginPage implements Interaction {

    @Override
    @Step("{0} opens login page")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(LOGIN_BUTTON));
    }
}
