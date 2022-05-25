package com.deosite.tests.tasks.brandPage;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static com.deosite.tests.pages.BrandPage.BRAND_LIST;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ClickBrand implements Interaction {

    private final int number;

    public ClickBrand(int number) {
        this.number = number;
    }

    @Override
    @Step("{0} clicks #brand")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(BRAND_LIST, isVisible()),
                Click.on(BRAND_LIST.resolveAllFor(actor).get(number)));
    }

    public static ClickBrand byBrand(int number) {
        return Instrumented.instanceOf(ClickBrand.class).withProperties(number);
    }
}
