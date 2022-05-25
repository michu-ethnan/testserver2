package com.deosite.tests.tasks.filtering;

import com.deosite.tests.pages.CategoryPage;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class SelectFilter implements Interaction {

    private final int number;

    public SelectFilter(int number) {
        this.number = number;
    }

    @Override
    @Step("{0} selects #filter")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CategoryPage.FILTERS_LIST, isClickable()),
                Click.on(CategoryPage.FILTERS_LIST.resolveAllFor(actor).get(number)),
                WaitUntil.the(CategoryPage.PRICE_FILTER_INPUT, isPresent())
        );
    }

    public static SelectFilter byNumber(int number) {
        return Instrumented.instanceOf(SelectFilter.class).withProperties(number);
    }
}
