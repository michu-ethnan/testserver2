package com.deosite.tests.tasks.order;

import com.deosite.tests.pages.CheckoutPage;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

public class SelectShippingAddress implements Task {
    private final int number;

    public SelectShippingAddress(int number){
        this.number = number;
    }
    @Override
    @Step("{0} selects #billling country")

    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(

                Click.on(CheckoutPage.SHIPPING_ADDRESS_LIST.resolveAllFor(actor).get(number))
        );
    }
    public static SelectShippingAddress byShippingAddress(int number){
        return Instrumented.instanceOf(SelectShippingAddress.class).withProperties(number);
    }
}
