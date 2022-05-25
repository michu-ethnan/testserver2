package com.deosite.tests.tasks.order;

import com.deosite.tests.abilities.Load;
import com.deosite.tests.model.order.OrderWithoutEmailAddress;
import com.deosite.tests.pages.CheckoutPage;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.thucydides.core.annotations.Step;

public class FillInBillingDataWithoutEmailAddress implements Task {

    private final String userType;

    public FillInBillingDataWithoutEmailAddress(String userType) {
        this.userType = userType;
    }

    @Override
    @Step("{0} fills in billing data")
    public <T extends Actor> void performAs(T actor) {
        OrderWithoutEmailAddress orderWithoutEmailAddress = Load.as(actor).orderWithoutEmailAddress(userType);

        actor.attemptsTo(SendKeys.of(orderWithoutEmailAddress.getName()).into(CheckoutPage.NAME_BILLING_INPUT));
        actor.attemptsTo(SendKeys.of(orderWithoutEmailAddress.getSurname()).into(CheckoutPage.SURNAME_BILLING_INPUT));
        actor.attemptsTo(SendKeys.of(orderWithoutEmailAddress.getStreet()).into(CheckoutPage.STREET_BILLING_INPUT));
        actor.attemptsTo(SendKeys.of(orderWithoutEmailAddress.getCity()).into(CheckoutPage.CITY_BILLING_INPUT));
        actor.attemptsTo(SendKeys.of(orderWithoutEmailAddress.getPostCode()).into(CheckoutPage.POST_CODE_BILLING_INPUT));
        actor.attemptsTo(SendKeys.of(orderWithoutEmailAddress.getNumber()).into(CheckoutPage.NUMBER_BILLING_INPUT));

        actor.attemptsTo(
                Click.on(CheckoutPage.SHIPPING_ADDRESS_IS_THE_SAME_CHECKBOX)
        );
    }

    public static Task type(String userType) {
        return Instrumented.instanceOf(FillInBillingDataWithoutEmailAddress.class).withProperties(userType);
    }
}
