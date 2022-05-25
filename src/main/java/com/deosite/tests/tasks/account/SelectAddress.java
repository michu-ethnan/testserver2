package com.deosite.tests.tasks.account;

import com.deosite.tests.pages.AccountPage;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsText;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class SelectAddress implements Task {

    private final int number;

    public SelectAddress(int number) {
        this.number = number;
    }

    @Override
    @Step("{0} selects address from the address book")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(AccountPage.ADDRESS_LIST, isPresent()),
                Click.on(AccountPage.ADDRESS_LIST.resolveAllFor(actor).get(number)),
                WaitUntil.the(AccountPage.MY_ACCOUNT_SUBHEADER, containsText("Edytuj adres"))
        );
    }

    public static SelectAddress byNumber(int number) {
        return Instrumented.instanceOf(SelectAddress.class).withProperties(number);
    }
}
