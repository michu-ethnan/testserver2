package com.deosite.tests.tasks.login;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static com.deosite.tests.pages.LoginPage.MY_ACCOUNT_BUTTON;
import static com.deosite.tests.pages.LoginPage.SUBMIT_BUTTON;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class SubmitLoginForm implements Task {
    @Override
    @Step("{0} submits login form")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SUBMIT_BUTTON, isClickable()).forNoMoreThan(100).seconds(),
                Click.on(SUBMIT_BUTTON),
                WaitUntil.the(MY_ACCOUNT_BUTTON, isPresent())
        );
    }

    public static SubmitLoginForm submitLoginForm() {
        return instrumented(SubmitLoginForm.class);
    }
}
