package com.deosite.tests.tasks.order;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static com.deosite.tests.pages.CheckoutPage.COUNTRY_BILLING_INPUT_LIST;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class SelectBillingCountry implements Task {
    private final int number;

    public SelectBillingCountry(int number){
        this.number = number;
    }
    @Override
    @Step("{0} selects #billling country")

    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(COUNTRY_BILLING_INPUT_LIST, isPresent()),
                Click.on(COUNTRY_BILLING_INPUT_LIST.resolveAllFor(actor).get(number))
        );
    }
    public static SelectBillingCountry byCountry(int number){
        return Instrumented.instanceOf(SelectBillingCountry.class).withProperties(number);
    }
}
