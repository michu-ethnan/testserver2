package com.deosite.tests.tasks.categoryPage;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static com.deosite.tests.pages.CategoryPage.COLLECTION_BANNERS;

public class ClickCollectionBanner implements Interaction {

    private final int collectionNumber;

    public ClickCollectionBanner(int collectionNumber) {
        this.collectionNumber = collectionNumber;
    }

    @Override
    @Step("{0} clicks #collectionNumber")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(COLLECTION_BANNERS.resolveAllFor(actor).get(collectionNumber)));
    }

    public static ClickCollectionBanner collectionNumber(int collectionNumber) {
        return Instrumented.instanceOf(ClickCollectionBanner.class).withProperties(collectionNumber);
    }
}
