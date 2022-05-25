package com.deosite.tests.tasks.basic;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RefreshPage implements Task {

    @Override
    @Step("{0} refreshes the page")

    public <T extends Actor> void performAs(T actor) {
        BrowseTheWeb.as(actor).getDriver().navigate().refresh();
    }

    public static RefreshPage refresh() {
        return instrumented(RefreshPage.class);
    }
}
