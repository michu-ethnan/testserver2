package com.deosite.tests.tasks.categoryPage;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static com.deosite.tests.pages.CategoryPage.PROMOTION_LIST;

public class SelectPromotion implements Interaction {
    private final int number;
    public SelectPromotion(int number){
        this.number = number;
    }
    @Override
    @Step("{0} selectsInspirationOption")
    public <T extends Actor> void performAs(T actor){
        actor.attemptsTo(
                Click.on(PROMOTION_LIST.resolveAllFor(actor).get(number))
        );
    }
    public static SelectPromotion by(int number){
        return Instrumented.instanceOf(SelectPromotion.class).withProperties(number);
    }
}
