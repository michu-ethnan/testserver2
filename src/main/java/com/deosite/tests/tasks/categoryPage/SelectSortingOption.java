package com.deosite.tests.tasks.categoryPage;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static com.deosite.tests.pages.CategoryPage.SORTING_OPTIONS;

public class SelectSortingOption implements Interaction {

    private final int sortingOptionNumber;

    public SelectSortingOption(int sortingOptionNumber) {
        this.sortingOptionNumber = sortingOptionNumber;
    }

    @Override
    @Step("{0} selects #sortingOptionNumber")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(SORTING_OPTIONS.resolveAllFor(actor).get(sortingOptionNumber))
        );
    }

    public static SelectSortingOption number(int sortingOptionNumber) {
        return Instrumented.instanceOf(SelectSortingOption.class).withProperties(sortingOptionNumber);
    }
}
