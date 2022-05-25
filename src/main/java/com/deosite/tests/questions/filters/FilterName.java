package com.deosite.tests.questions.filters;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;
import java.util.Random;

import static com.deosite.tests.pages.CategoryPage.FILTER_CHECKBOXES;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class FilterName implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(FILTER_CHECKBOXES, isPresent()).forNoMoreThan(100).seconds()
        );
        int size = FILTER_CHECKBOXES.resolveAllFor(actor).size();
        List<WebElementFacade> filters = FILTER_CHECKBOXES.resolveAllFor(actor);

        Random r = new Random();
        int filtersList = r.nextInt(filters.size());
        String filterNameAfterTrim = filters.get(filtersList).getAttribute("textContent");
        filters.get(filtersList).click();

        return filterNameAfterTrim;
    }
    public static Question<String> filterName() {
        return new FilterName();
    }
}
