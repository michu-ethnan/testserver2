package com.deosite.tests.tasks.login;

import com.deosite.tests.abilities.Load;
import com.deosite.tests.model.login.LogIn;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static com.deosite.tests.pages.LoginPage.EMAIL_INPUT;
import static com.deosite.tests.pages.LoginPage.PASSWORD_INPUT;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class FillInLoginForm implements Task {

    private final String userType;

    public FillInLoginForm(String userType) {
        this.userType = userType;
    }

    @Override
    @Step("{0} fills in login form")
    public <T extends Actor> void performAs(T actor) {
        LogIn logIn = Load.as(actor).logIn(userType);

        actor.attemptsTo(
                WaitUntil.the(EMAIL_INPUT, isPresent()).forNoMoreThan(50).seconds(),
                SendKeys.of(logIn.getEmail()).into(EMAIL_INPUT));
        actor.attemptsTo(
                WaitUntil.the(PASSWORD_INPUT, isPresent()),
                SendKeys.of(logIn.getPassword()).into(PASSWORD_INPUT));
    }

    public static Task type(String userType) {
        return Instrumented.instanceOf(FillInLoginForm.class).withProperties(userType);
    }
}
