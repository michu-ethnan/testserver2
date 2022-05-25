package com.deosite.tests.tasks.order;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static com.deosite.tests.pages.PaymentPage.AGREEMENT_CHECKBOX;
import static com.deosite.tests.pages.PaymentPage.PLACE_ORDER_BUTTON;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class Place implements Task {

    @Override
    @Step("{0} agrees to policy and places order")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(AGREEMENT_CHECKBOX, isPresent()).forNoMoreThan(100).seconds(),
                Click.on(AGREEMENT_CHECKBOX),
                Click.on(PLACE_ORDER_BUTTON)
        );
    }

    public static Task order() {
        return instrumented(Place.class);
    }
}
