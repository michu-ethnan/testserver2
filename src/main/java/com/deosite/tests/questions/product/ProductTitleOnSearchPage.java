package com.deosite.tests.questions.product;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

import static com.deosite.tests.pages.SearchPage.PRODUCTS_TITLE;

@Subject("the title of a product on search page")
public class ProductTitleOnSearchPage implements Question<String> {

    private final int position;

    public ProductTitleOnSearchPage(int position) {
        this.position = position;
    }

    @Override
    public String answeredBy(Actor actor) {
        return PRODUCTS_TITLE.resolveAllFor(actor).get(position).getText();
    }
}
