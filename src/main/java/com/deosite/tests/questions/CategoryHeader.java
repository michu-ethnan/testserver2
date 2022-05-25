package com.deosite.tests.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

import static com.deosite.tests.pages.CategoryPage.CATEGORY_HEADER;

@Subject("the displayed category header")
public class CategoryHeader implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return CATEGORY_HEADER.resolveFor(actor).getText();
    }

    public static Question<String> valueIs() {
        return new CategoryHeader();
    }

}
