package com.deosite.tests.tasks.order;

import com.deosite.tests.pages.CheckoutPage;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static com.deosite.tests.pages.CheckoutPage.DELIVERY_TYPE_PICKUP_POINT;
import static com.deosite.tests.pages.CheckoutPage.PICKUP_POINT_SELECT;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class ChooseDelivery implements Task {

    private final String deliveryType;

    public ChooseDelivery(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    @Override
    @Step("{0} chooses #deliveryType as order delivery")
    public <T extends Actor> void performAs(T actor) {
        if (deliveryType.contains("pickup")) {
            actor.attemptsTo(
                    Click.on(DELIVERY_TYPE_PICKUP_POINT),
                    Click.on(PICKUP_POINT_SELECT),
                    SelectPickUpLocation.byLocation(1),
                    WaitUntil.the(CheckoutPage.SUBMIT_BUTTON, isClickable()).forNoMoreThan(50).seconds()
            );

        }
    }

    public static ChooseDelivery byType(String deliveryType) {
        return Instrumented.instanceOf(ChooseDelivery.class).withProperties(deliveryType);
    }
}
