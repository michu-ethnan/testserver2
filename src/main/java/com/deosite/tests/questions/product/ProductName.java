package com.deosite.tests.questions.product;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

import static com.deosite.tests.pages.ProductPage.PRODUCT_NAME;

@Subject("product name")
public class ProductName implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return PRODUCT_NAME.resolveFor(actor).getText();
    }

    public static Question<String> productName() {
        return new ProductName();
    }
}
