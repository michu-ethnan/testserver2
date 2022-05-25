package com.deosite.tests.actions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import static com.deosite.tests.abilities.Load.as;

public class SearchForTranslatedProducts implements Interaction {

    private final String keyword;

    public SearchForTranslatedProducts(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Search.forProductByKeyword(as(actor).translate(keyword))
        );
    }
}
