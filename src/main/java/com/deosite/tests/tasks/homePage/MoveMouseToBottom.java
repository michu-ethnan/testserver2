package com.deosite.tests.tasks.homePage;

import com.deosite.tests.pages.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class MoveMouseToBottom implements Task {

    @Override
    @Step("{0} moves the mouse down")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(HomePage.SECOND_BANNER, isPresent()).forNoMoreThan(100).seconds(),
                MoveMouse.to(HomePage.SECOND_BANNER),
                Scroll.to(HomePage.MAIN_BANNER)
        );
    }

    public static MoveMouseToBottom move() {
        return instrumented(MoveMouseToBottom.class);
    }

}
