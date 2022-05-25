package com.deosite.tests.questions.product;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Question;

public class Product {

    public static Question<String> titleOfAProductOnSearchPageByPosition(int position) {
        return Instrumented.instanceOf(ProductTitleOnSearchPage.class).withProperties(position);
    }
}
