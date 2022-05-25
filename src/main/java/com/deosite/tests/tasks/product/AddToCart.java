package com.deosite.tests.tasks.product;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.conditions.Check;
import net.thucydides.core.annotations.Step;

import static com.deosite.tests.pages.ProductPage.ADD_TO_CART_BUTTON;

public class AddToCart implements Task {

    @Override
    @Step("{0} adds product to cart")
    public <T extends Actor> void performAs(T actor) {

                actor.attemptsTo(
                        Check.whether(ADD_TO_CART_BUTTON.resolveFor(actor).isClickable()).andIfSo(AddProductToCart.toCart()).otherwise(ReturnAndAddAnotherProduct.toCart())
                );

    }
}
