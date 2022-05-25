package com.deosite.tests.questions.checkout;

import com.deosite.tests.pages.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

import java.math.BigDecimal;

@Subject("Get shipping price")

public class GetShippingPrice implements Question<BigDecimal> {

    @Override
    public BigDecimal answeredBy(Actor actor) {
        String price = CheckoutPage.SHIPPING_VALUE.resolveFor(actor).getText().trim();
        String priceAfterTrim = price.replace(",", ".").trim();
        BigDecimal shippingPrice = new BigDecimal(priceAfterTrim);
        return shippingPrice;
    }

    public static Question<BigDecimal> shipping() {
        return new GetShippingPrice();
    }
}
