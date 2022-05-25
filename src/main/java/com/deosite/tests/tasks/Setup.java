package com.deosite.tests.tasks;

import com.deosite.tests.tasks.basic.AcceptCookies;
import com.deosite.tests.tasks.basic.OpenTheApplication;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Setup implements Task {

    @Override
    @Step("{0} prepares site")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                OpenTheApplication.onTheHomePage(),
                AcceptCookies.clickingAcceptButton()
        );
    }

    public static Setup site() {
        return instrumented(Setup.class);
    }
}
