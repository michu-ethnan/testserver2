package com.deosite.tests.tasks.account;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static com.deosite.tests.pages.AccountPage.ORDER_LIST;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class SelectOrder implements Task {
    private final int number;

    public SelectOrder(int number){
        this.number = number;
    }
    @Override
    @Step("{0} selects order from the order list")

    public <T extends Actor> void performAs(T actor){
        actor.attemptsTo(
                WaitUntil.the(ORDER_LIST, isPresent()).forNoMoreThan(100).seconds(),
                Click.on(ORDER_LIST.resolveAllFor(actor).get(number))
        );

    }
    public static SelectOrder byNumber(int number){
        return Instrumented.instanceOf(SelectOrder.class).withProperties(number);
    }
}
