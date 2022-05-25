package com.deosite.tests.tasks;

import com.deosite.tests.tasks.basic.OpenTheApplication;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SetupWithoutAcceptingCookies implements Task {

    @Override
    @Step("{0} prepares site without accepting cookies")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                OpenTheApplication.onTheHomePage()

        );
    }

    public static SetupWithoutAcceptingCookies setup() {
        return instrumented(SetupWithoutAcceptingCookies.class);
    }

}
