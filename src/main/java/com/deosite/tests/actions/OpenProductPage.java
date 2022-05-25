package com.deosite.tests.actions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static com.deosite.tests.pages.ProductPage.ADD_TO_CART_BUTTON;
import static com.deosite.tests.pages.SearchPage.PRODUCTS_TITLE;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class OpenProductPage implements Interaction {

    private final int position;

    public OpenProductPage(int position) {
        this.position = position;
    }

    @Override
    @Step("{0} opens page of a product")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(PRODUCTS_TITLE, isPresent()).forNoMoreThan(100).seconds(),
                WaitUntil.the(PRODUCTS_TITLE, isClickable()).forNoMoreThan(100).seconds(),
                Click.on(PRODUCTS_TITLE.resolveAllFor(actor).get(position)),
                WaitUntil.the(ADD_TO_CART_BUTTON, isPresent()).forNoMoreThan(100).seconds()
        );
    }
}
