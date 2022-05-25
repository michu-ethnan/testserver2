package com.deosite.tests.tasks.order;

import com.deosite.tests.abilities.Load;
import com.deosite.tests.model.order.Company;
import com.deosite.tests.model.order.Order;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static com.deosite.tests.pages.CheckoutPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class FillInBillingData implements Task {

    private final String userType;

    public FillInBillingData(String userType) {
        this.userType = userType;
    }

    @Override
    @Step("{0} fills in billing data as #userType")
    public <T extends Actor> void performAs(T actor) {
        Order order = Load.as(actor).order(userType);

        actor.attemptsTo(SendKeys.of(order.getEmail()).into(EMAIL_INPUT));

        if (order.getClass() == Company.class) {
            actor.attemptsTo(
                    WaitUntil.the(AS_COMPANY_BILLING_CHECKBOX, isPresent()),
                    Click.on(AS_COMPANY_BILLING_CHECKBOX),
                    SendKeys.of(((Company) order).getCompanyName()).into(COMPANY_NAME_BILLING_INPUT),
                    SendKeys.of(((Company) order).getNip()).into(NIP_BILLING_INPUT)
            );
        }

        //COUNTRY_BILLING_INPUT.resolveFor(actor).selectByVisibleText(order.getCountry());

        actor.attemptsTo(
                SendKeys.of(order.getName()).into(NAME_BILLING_INPUT),
                SendKeys.of(order.getSurname()).into(SURNAME_BILLING_INPUT),
                SendKeys.of(order.getStreet()).into(STREET_BILLING_INPUT),
                SendKeys.of(order.getCity()).into(CITY_BILLING_INPUT),
                SendKeys.of(order.getPostCode()).into(POST_CODE_BILLING_INPUT),
                SendKeys.of(order.getNumber()).into(NUMBER_BILLING_INPUT)
        );
    }

    public static Task type(String userType) {
        return Instrumented.instanceOf(FillInBillingData.class).withProperties(userType);
    }
}
