package com.deosite.tests.tasks.order;

import com.deosite.tests.abilities.Load;
import com.deosite.tests.model.order.Company;
import com.deosite.tests.model.order.Order;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.thucydides.core.annotations.Step;

import static com.deosite.tests.pages.CheckoutPage.*;

public class FillInShippingData implements Task {

    private final String userType;

    public FillInShippingData(String userType) {
        this.userType = userType;
    }

    @Override
    @Step("{0} fills in shipping data as #userType")
    public <T extends Actor> void performAs(T actor) {
        Order order = Load.as(actor).order(userType);

        actor.attemptsTo(
                Click.on(SHIPPING_ADDRESS_IS_THE_SAME_CHECKBOX));

        if (order.getClass() == Company.class) {
            actor.attemptsTo(
                    Click.on(AS_COMPANY_SHIPPING_CHECKBOX),
                    SendKeys.of(((Company) order).getCompanyName()).into(COMPANY_NAME_SHIPPING_INPUT)
            );
        }

       // COUNTRY_SHIPPING_INPUT.resolveFor(actor).selectByVisibleText(order.getCountry());

        actor.attemptsTo(
                SendKeys.of(order.getName()).into(NAME_SHIPPING_INPUT),
                SendKeys.of(order.getSurname()).into(SURNAME_SHIPPING_INPUT),
                SendKeys.of(order.getStreet()).into(STREET_SHIPPING_INPUT),
                SendKeys.of(order.getCity()).into(CITY_SHIPPING_INPUT),
                SendKeys.of(order.getPostCode()).into(POST_CODE_SHIPPING_INPUT),
                SendKeys.of(order.getNumber()).into(NUMBER_SHIPPING_INPUT)
        );
    }

    public static Task type(String userType) {
        return Instrumented.instanceOf(FillInShippingData.class).withProperties(userType);
    }
}
