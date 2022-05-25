package com.deosite.tests.tasks.product;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static com.deosite.tests.pages.Alert.ALERT_BOX;
import static com.deosite.tests.pages.ProductPage.ADD_TO_CART_BUTTON;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class AddProductToCart implements Task {
    //String collectionHeader;
    @Override
    @Step("{0} adds product to cart")
    public <T extends Actor> void performAs(T actor) {

actor.attemptsTo(
        WaitUntil.the(ADD_TO_CART_BUTTON, isPresent()).forNoMoreThan(100).seconds(),
        WaitUntil.the(ADD_TO_CART_BUTTON, isClickable()).forNoMoreThan(100).seconds(),
        Click.on(ADD_TO_CART_BUTTON)
);
if (ALERT_BOX.resolveFor(actor).isPresent()){

    actor.attemptsTo(
            Check.whether(ALERT_BOX.resolveFor(actor).containsText("Produkt został dodany do koszyka")).andIfSo(MoveMouse.to(ALERT_BOX)).otherwise(ReturnAndAddAnotherProduct.toCart())
    );
}
else {
    actor.attemptsTo(
            ReturnAndAddAnotherProduct.toCart()
    );
}
}


    public static Task toCart() {
        return instrumented(AddProductToCart.class);
    }
}
