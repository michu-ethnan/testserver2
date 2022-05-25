package com.deosite.tests.tasks.basic;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenTheApplication implements Performable {

    @Step("{0} opens the application")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn().thePageNamed("home.page"));
    }

    public static OpenTheApplication onTheHomePage() {
        return instrumented(OpenTheApplication.class);
    }
}
