package com.deosite.tests.tasks.order;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static com.deosite.tests.pages.CheckoutPage.PICKUP_LOCATION_LIST;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class SelectPickUpLocation implements Task {

    private int number;
    public SelectPickUpLocation(int number){
        this.number = number;
    }
    @Override
    @Step("{0} selects #pickup location")
    public <T extends Actor> void performAs(T actor){
        actor.attemptsTo(
                WaitUntil.the(PICKUP_LOCATION_LIST, isPresent()),
                Click.on(PICKUP_LOCATION_LIST.resolveAllFor(actor).get(number))
        );
    }
    public static SelectPickUpLocation byLocation(int number){
        return Instrumented.instanceOf(SelectPickUpLocation.class).withProperties(number);
    }
}
