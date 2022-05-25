package com.deosite.tests.tasks.account;

import com.deosite.tests.pages.AccountPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ClearAddressForm implements Task {

    @Override
    @Step("{0} clears an address form")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Clear.field(AccountPage.NAME_INPUT),
                Clear.field(AccountPage.LAST_NAME_INPUT),
                Clear.field(AccountPage.STREET_INPUT),
                Clear.field(AccountPage.CITY_INPUT),
                Clear.field(AccountPage.POSTAL_CODE_INPUT),
                Clear.field(AccountPage.PHONE_INPUT)
        );
    }


    public static ClearAddressForm clearForm() {
        return instrumented(ClearAddressForm.class);
    }
}
