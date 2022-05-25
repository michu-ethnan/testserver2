package com.deosite.tests.tasks.order;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static com.deosite.tests.pages.CheckoutPage.BILLING_ADDRESS_SELECT;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ChangeBillingAddress implements Task {

    @Override
    @Step("{0} changes billing address")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BILLING_ADDRESS_SELECT)
        );
        BILLING_ADDRESS_SELECT.resolveFor(actor).selectByIndex(0);
    }

    public static Task changeBillingAddress() {
        return instrumented(ChangeBillingAddress.class);
    }
}
