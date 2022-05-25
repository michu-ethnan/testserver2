package com.deosite.tests.actions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static com.deosite.tests.pages.CheckoutPage.EMAIL_INPUT;
import static com.deosite.tests.pages.MiniCart.GO_TO_CHECKOUT_BUTTON;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class OpenCheckoutPage implements Interaction {

    @Override
    @Step("{0} opens checkout page")
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(GO_TO_CHECKOUT_BUTTON, isPresent()),
                Click.on(GO_TO_CHECKOUT_BUTTON),
                WaitUntil.the(EMAIL_INPUT, isPresent()).forNoMoreThan(100).seconds()
        );

    }
}
