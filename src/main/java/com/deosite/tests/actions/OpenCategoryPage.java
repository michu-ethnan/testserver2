package com.deosite.tests.actions;

import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static com.deosite.tests.pages.MainMenu.FIRST_MAIN_CATEGORY;

public class OpenCategoryPage implements Interaction {

    @Override
    @Step("{0} opens Category Page")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(FIRST_MAIN_CATEGORY)
        );
    }
}
