package com.deosite.tests.tasks.basic;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ReturnToPreviousPage implements Task {

    @Override
    @Step("{0} returns to previous page")

    public <T extends Actor> void performAs(T actor) {
        BrowseTheWeb.as(actor).getDriver().navigate().back();
    }

    public static ReturnToPreviousPage goToPreviousPage() {
        return instrumented(ReturnToPreviousPage.class);
    }
}
