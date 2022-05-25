package com.deosite.tests.tasks.order;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static com.deosite.tests.pages.CheckoutPage.SUBMIT_BUTTON;
import static com.deosite.tests.pages.PaymentPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class Pay implements Task {

    private final String paymentType;

    public Pay(String paymentType) {
        this.paymentType = paymentType;
    }

    @Override
    @Step("{0} sets payment method")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SUBMIT_BUTTON, isClickable()),
                Click.on(SUBMIT_BUTTON),
                WaitUntil.the(PLACE_ORDER_BUTTON, isPresent()).forNoMoreThan(100).seconds()
        );
        switch (paymentType) {
            case "card":
                break;
            case "transfer":
                actor.attemptsTo(Click.on(TRANSFER_PAYMENT_CHECKBOX));
                break;
            case "pickup":
                actor.attemptsTo(Click.on(PICKUP_PAYMENT_CHECKBOX));
                break;
        }
    }

    public static Task by(String paymentType) {
        return Instrumented.instanceOf(Pay.class).withProperties(paymentType);
    }
}