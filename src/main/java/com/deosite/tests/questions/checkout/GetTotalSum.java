package com.deosite.tests.questions.checkout;

import com.deosite.tests.pages.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

import java.math.BigDecimal;

@Subject("Get total price at checkout")

public class GetTotalSum implements Question<BigDecimal> {

    @Override
    public BigDecimal answeredBy (Actor actor) {
        String sum = CheckoutPage.TOTAL_SUM_AT_CHECKOUT.resolveFor(actor).getText().trim();
        String sumAfterTrim = sum.replace(",", ".").trim();
        BigDecimal totalSum = new BigDecimal(sumAfterTrim);
        return totalSum;
    }

    public static Question<BigDecimal> totalSum() {
        return new GetTotalSum();
    }
}