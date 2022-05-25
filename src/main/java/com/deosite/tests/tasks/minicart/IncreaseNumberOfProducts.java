package com.deosite.tests.tasks.minicart;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static com.deosite.tests.pages.MiniCart.QUANTITY_AMOUNT;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class IncreaseNumberOfProducts implements Task {
private final int number;
public IncreaseNumberOfProducts(int number){
    this.number = number;
}
    @Override
    @Step("{0} chooses #numberOfProducts")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(QUANTITY_AMOUNT, isPresent()).forNoMoreThan(50).seconds(),
                Click.on(QUANTITY_AMOUNT.resolveAllFor(actor).get(number))
        );

    }

    public static IncreaseNumberOfProducts byAmountNumber(int number) {
      return Instrumented.instanceOf(IncreaseNumberOfProducts.class).withProperties(number);
    }
}
