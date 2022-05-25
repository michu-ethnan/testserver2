package com.deosite.tests.questions.product;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

import java.math.BigDecimal;

import static com.deosite.tests.pages.ProductPage.PRODUCT_PRICE;

@Subject("Product price")

public class ProductPrice implements Question<BigDecimal> {

    @Override
    public BigDecimal answeredBy(Actor actor) {
       String productPrice = PRODUCT_PRICE.resolveFor(actor).getText();
       String priceAfterTrim = productPrice.replace(",", ".").trim();
       BigDecimal price = new BigDecimal(priceAfterTrim);
       return price;
    }

    public static Question<BigDecimal> price() {
        return new ProductPrice();
    }
}
