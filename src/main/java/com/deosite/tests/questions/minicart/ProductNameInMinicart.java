package com.deosite.tests.questions.minicart;

import com.deosite.tests.pages.MiniCart;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

@Subject("product name in minicart")

public class ProductNameInMinicart implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return MiniCart.PRODUCT_NAME_IN_MINICART.resolveFor(actor).getText();
    }

    public static Question<String> productNameInMinicart() {
        return new ProductNameInMinicart();
    }
}
