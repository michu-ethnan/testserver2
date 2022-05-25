package com.deosite.tests.questions.filters;

import com.deosite.tests.pages.CategoryPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class FilterBox implements Question<String> {

    public String answeredBy(Actor actor) {
        String filterBoxText = CategoryPage.APPLIED_FILTER_BOX.resolveFor(actor).getText();
        return filterBoxText;
    }

    public static Question<String> text() {
        return new FilterBox();
    }
}
