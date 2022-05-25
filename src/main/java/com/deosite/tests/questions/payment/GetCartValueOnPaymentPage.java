package com.deosite.tests.questions.payment;

import com.deosite.tests.pages.PaymentPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

import java.math.BigDecimal;

@Subject("Get cart value on payment page")

public class GetCartValueOnPaymentPage implements Question<BigDecimal> {

    @Override
    public BigDecimal answeredBy(Actor actor) {
        String value = PaymentPage.CART_VALUE.resolveFor(actor).getText();
        String valueAfterTrim = value.replace(",", ".").trim();
        BigDecimal cartValue = new BigDecimal(valueAfterTrim);
        return cartValue;
    }

    public static Question<BigDecimal> cartValueOnPaymentPage() {
        return new GetCartValueOnPaymentPage();
    }
}
