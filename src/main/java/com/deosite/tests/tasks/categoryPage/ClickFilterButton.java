package com.deosite.tests.tasks.categoryPage;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static com.deosite.tests.pages.CategoryPage.FILTER_BUTTONS;

public class ClickFilterButton implements Interaction {

    private final int filterNumber;

    public ClickFilterButton(int filterNumber) {
        this.filterNumber = filterNumber;
    }

    @Override
    @Step("{0} clicks #filterNumber")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(FILTER_BUTTONS.resolveAllFor(actor).get(filterNumber))
        );
    }

    public static ClickFilterButton number(int filterNumber) {
        return Instrumented.instanceOf(ClickFilterButton.class).withProperties(filterNumber);
    }
}
