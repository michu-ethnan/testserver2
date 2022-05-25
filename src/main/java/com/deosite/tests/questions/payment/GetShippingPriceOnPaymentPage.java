package com.deosite.tests.questions.payment;

import com.deosite.tests.pages.PaymentPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

import java.math.BigDecimal;

@Subject("Get shipping price on payment page")

public class GetShippingPriceOnPaymentPage implements Question<BigDecimal> {

    @Override
    public BigDecimal answeredBy(Actor actor) {
        String price = PaymentPage.SHIPPING_PRICE.resolveFor(actor).getText();
        String priceAfterTrim = price.replace(",", ".").trim();
        BigDecimal shippingPrice = new BigDecimal(priceAfterTrim);
        return shippingPrice;
    }

    public static Question<BigDecimal> shippingPrice() {
        return new GetShippingPriceOnPaymentPage();
    }
}