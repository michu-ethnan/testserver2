package com.deosite.tests.actions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.Interaction;
import net.thucydides.core.annotations.Step;

import static com.deosite.tests.pages.LoginPage.MY_ACCOUNT_BUTTON;

public class OpenAccountPage implements Interaction {

    @Override
    @Step("{0} opens My Account page")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(MY_ACCOUNT_BUTTON));
    }
}
