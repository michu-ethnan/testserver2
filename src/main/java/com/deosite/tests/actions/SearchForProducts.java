package com.deosite.tests.actions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;

import static com.deosite.tests.pages.MainMenu.SEARCH_BAR;

public class SearchForProducts implements Interaction {

    private final String keyword;

    public SearchForProducts(String keyword) {
        this.keyword = keyword;
    }

    @Override
    @Step("{0} searches for #keyword")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(keyword).into(SEARCH_BAR).thenHit(Keys.ENTER));
    }
}
