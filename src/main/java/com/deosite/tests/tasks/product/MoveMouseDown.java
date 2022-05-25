package com.deosite.tests.tasks.product;

import com.deosite.tests.pages.ProductPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class MoveMouseDown implements Task {
    @Override
    @Step("{0} moves the mouse down")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(ProductPage.ADD_TO_CART_BUTTON, isPresent()),
                MoveMouse.to(ProductPage.PRODUCT_THUMBNAIL)
        );
    }

    public static MoveMouseDown move() {
        return instrumented(MoveMouseDown.class);
    }

}
