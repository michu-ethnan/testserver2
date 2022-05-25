package com.deosite.tests.questions.checkout;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

import java.math.BigDecimal;

import static com.deosite.tests.pages.CheckoutPage.DISCOUNT_PRICE;


@Subject("Discount price")

public class DiscountPrice implements Question<BigDecimal> {

    @Override
    public BigDecimal answeredBy(Actor actor){
        String discountPrice = DISCOUNT_PRICE.resolveFor(actor).getText();
        String discountPriceAfterRemovingNegativeSign = discountPrice.replace("-","").trim();
        String discountPriceAfterTrim = discountPriceAfterRemovingNegativeSign.replace(",",".").trim();
        BigDecimal discount = new BigDecimal(discountPriceAfterTrim);
        return discount;

    }
    public static Question<BigDecimal> discount()
    {
        return new DiscountPrice();
    }}
