package com.deosite.tests.actions;

import com.deosite.tests.tasks.product.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static com.deosite.tests.pages.MainMenu.MINI_CART_BUTTON;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class OpenMiniCart implements Interaction {

    @Override
    @Step("{0} opens mini cart")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(MINI_CART_BUTTON, isClickable()).forNoMoreThan(100).seconds(),
                Click.on(MINI_CART_BUTTON)
        );
    }
}
