package com.deosite.tests.tasks.categoryPage;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static com.deosite.tests.pages.CategoryPage.FILTER_CHECKBOXES;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class ClickSelectedFilter implements Interaction {

    private final int filterOption;

    public ClickSelectedFilter(int filterOption) {
        this.filterOption = filterOption;
    }

    @Override
    @Step("{0} clicks #filterOption")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(FILTER_CHECKBOXES, isPresent()).forNoMoreThan(100).seconds(),
                Click.on(FILTER_CHECKBOXES.resolveAllFor(actor).get(filterOption))
        );
    }

    public static ClickSelectedFilter number(int filterOption) {
        return Instrumented.instanceOf(ClickSelectedFilter.class).withProperties(filterOption);
    }
}
