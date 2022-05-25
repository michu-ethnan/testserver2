package com.deosite.tests.tasks.categoryPage;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static com.deosite.tests.pages.CategoryPage.INSPIRATION_LIST;


public class OpenInspirations implements Interaction {

    private final int number;

    public OpenInspirations(int number) {
        this.number = number;
    }

    @Override
    @Step("{0} selects #inspr")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(INSPIRATION_LIST.resolveAllFor(actor).get(number))
        );
    }

    public static OpenInspirations by(int number) {
        return Instrumented.instanceOf(OpenInspirations.class).withProperties(number);
    }}
