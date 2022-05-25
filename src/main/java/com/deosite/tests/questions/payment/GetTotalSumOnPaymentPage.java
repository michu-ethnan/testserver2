package com.deosite.tests.questions.payment;

import com.deosite.tests.pages.PaymentPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

import java.math.BigDecimal;

@Subject("Get total sum on payment page")

public class GetTotalSumOnPaymentPage implements Question<BigDecimal> {

    @Override
    public BigDecimal answeredBy (Actor actor) {
        String sum = PaymentPage.TOTAL_SUM.resolveFor(actor).getText();
        String sumAfterTrim = sum.replace(",", ".").trim();
        BigDecimal totalSum = new BigDecimal(sumAfterTrim);
        return totalSum;
    }

    public static Question<BigDecimal> totalSum() {
        return new GetTotalSumOnPaymentPage();
    }
}