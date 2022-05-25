package com.deosite.tests.tasks.order;

import com.deosite.tests.pages.SuccessPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.deosite.tests.pages.CardPaymentPage.*;
import static com.deosite.tests.pages.CookiesNotification.ACCEPT_COOKIES_BUTTON;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class CardPayment implements Task {

    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(FIRST_BANK_LOGO, isClickable()),
                Click.on(FIRST_BANK_LOGO),
                WaitUntil.the(LOGIN_BUTTON, isPresent()),
                Click.on(LOGIN_BUTTON),
                WaitUntil.the(PAYMENT_BUTTON, isPresent()),
                Click.on(PAYMENT_BUTTON),
                WaitUntil.the(ACCEPT_COOKIES_BUTTON, isPresent()).forNoMoreThan(50).seconds(),
                Click.on(ACCEPT_COOKIES_BUTTON),
                WaitUntil.the(SuccessPage.SUCCESS_ORDER_MESSAGE, isPresent()).forNoMoreThan(100).seconds()
        );
    }

    public static Task order() {
        return instrumented(CardPayment.class);
    }
}
