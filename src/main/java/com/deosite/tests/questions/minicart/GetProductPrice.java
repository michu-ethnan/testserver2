package com.deosite.tests.questions.minicart;

import com.deosite.tests.pages.MiniCart;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

import java.math.BigDecimal;

@Subject("Get product price")

public class GetProductPrice implements Question<BigDecimal> {

    private final int number;

    public GetProductPrice(int number) {
        this.number = number;
    }

    @Override
    public BigDecimal answeredBy(Actor actor) {
        String priceList = MiniCart.PRODUCT_PRICE_LIST.resolveAllFor(actor).get(number).getText();
        String priceAfterTrim = priceList.replace(",", ".").trim();
        String priceAfterRemovingCharacters = priceAfterTrim.replaceAll("[^\\d(,.)]", "");
        BigDecimal firstProductPrice = new BigDecimal(priceAfterRemovingCharacters);
        return firstProductPrice;
    }

    public static Question<BigDecimal> productPrice(int number) {
        return Instrumented.instanceOf(GetProductPrice.class).withProperties(number);
    }
}
