package com.deosite.tests.tasks.categoryPage;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static com.deosite.tests.pages.CategoryPage.PAGINATION_NUMBER_LIST;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class SelectPageNumber implements Task {
    private final int number;
    public SelectPageNumber(int number){
        this.number = number;
    }

    @Override
    @Step("{0} selects #pageNumber")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(

                        WaitUntil.the(PAGINATION_NUMBER_LIST, isPresent()).forNoMoreThan(100).seconds(),
                        Click.on(PAGINATION_NUMBER_LIST.resolveAllFor(actor).get(number))
                );
    }
    public static SelectPageNumber byNumber(int number) {
        return Instrumented.instanceOf(SelectPageNumber.class).withProperties(number);
    }
}
