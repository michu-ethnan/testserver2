package com.deosite.tests.questions.checkout;

import com.deosite.tests.pages.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

import java.math.BigDecimal;

@Subject("Get cart value")

public class GetCartValue implements Question<BigDecimal> {

    @Override
    public BigDecimal answeredBy(Actor actor) {
        String value = CheckoutPage.CART_VALUE.resolveFor(actor).getText();
        String valueAfterTrim = value.replace(",", ".").trim();
        BigDecimal cartValue = new BigDecimal(valueAfterTrim);
        return cartValue;
    }

    public static Question<BigDecimal> cartValue() {
        return new GetCartValue();
    }
}
