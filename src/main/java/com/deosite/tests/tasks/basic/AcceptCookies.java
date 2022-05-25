package com.deosite.tests.tasks.basic;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static com.deosite.tests.pages.CookiesNotification.ACCEPT_COOKIES_BUTTON;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AcceptCookies implements Task {

    @Override
    @Step("{0} accepts cookies")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(ACCEPT_COOKIES_BUTTON));
    }

    public static AcceptCookies clickingAcceptButton() {
        return instrumented(AcceptCookies.class);
    }
}
