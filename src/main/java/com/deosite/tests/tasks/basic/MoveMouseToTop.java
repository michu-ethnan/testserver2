package com.deosite.tests.tasks.basic;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.thucydides.core.annotations.Step;

import static com.deosite.tests.pages.MainMenu.SEARCH_BAR;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class MoveMouseToTop implements Task {

    @Override
    @Step("{0} moves mouse to top")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                MoveMouse.to(SEARCH_BAR)
        );
    }

    public static MoveMouseToTop move() {
        return instrumented(MoveMouseToTop.class);
    }
}
