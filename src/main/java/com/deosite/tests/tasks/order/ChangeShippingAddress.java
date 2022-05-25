package com.deosite.tests.tasks.order;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static com.deosite.tests.pages.CheckoutPage.SHIPPING_ADDRESS_SELECT;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ChangeShippingAddress implements Task {

    @Override
    @Step("{0} changes shipping address")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(SHIPPING_ADDRESS_SELECT)
        );
        SHIPPING_ADDRESS_SELECT.resolveFor(actor).selectByIndex(1);
    }

    public static Task changeShippingAddress() {
        return instrumented(ChangeShippingAddress.class);
    }
}
