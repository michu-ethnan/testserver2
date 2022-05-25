package com.deosite.tests.questions.minicart;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

import java.math.BigDecimal;

import static com.deosite.tests.pages.MiniCart.TOTAL_SUM;

@Subject("Total sum in minicart")

public class TotalSumInMinicart implements Question<BigDecimal> {

    @Override
    public BigDecimal answeredBy(Actor actor) {
        String sum = TOTAL_SUM.resolveFor(actor).getText();
        String sumAfterTrim = sum.replace(",",".").trim();
        BigDecimal totalSum = new BigDecimal(sumAfterTrim);
        return totalSum;
    }

    public static Question<BigDecimal> sum() {
        return new TotalSumInMinicart();
    }
}
