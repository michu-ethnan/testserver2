package com.deosite.tests.tasks.account;

import com.deosite.tests.abilities.Load;
import com.deosite.tests.model.account.NewAddress;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.thucydides.core.annotations.Step;

import static com.deosite.tests.pages.AccountPage.*;

public class FillInAddressForm implements Task {

    private final String userType;

    public FillInAddressForm(String userType) {
        this.userType = userType;
    }

    @Override
    @Step("{0} fills in address form as #userType")
    public <T extends Actor> void performAs(T actor) {
        NewAddress newAddress = Load.as(actor).newAddress(userType);

        actor.attemptsTo(SendKeys.of(newAddress.getName()).into(NAME_INPUT));
        actor.attemptsTo(SendKeys.of(newAddress.getLastName()).into(LAST_NAME_INPUT));
        actor.attemptsTo(SendKeys.of(newAddress.getStreet()).into(STREET_INPUT));
        actor.attemptsTo(SendKeys.of(newAddress.getCity()).into(CITY_INPUT));
        actor.attemptsTo(SendKeys.of(newAddress.getPostalCode()).into(POSTAL_CODE_INPUT));
        actor.attemptsTo(SendKeys.of(newAddress.getPhone()).into(PHONE_INPUT));
    }

    public static Task type(String userType) {
        return Instrumented.instanceOf(FillInAddressForm.class).withProperties(userType);
    }
}
