package com.deosite.tests.questions.account;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

import static com.deosite.tests.pages.AccountPage.ORDER_IMAGE;

@Subject("Is order image displayed")
public class OrderImage implements Question<Boolean> {

    @Override
    public Boolean answeredBy (Actor actor) {
        return ORDER_IMAGE.resolveFor(actor).isDisplayed();
    }

    public static Question<Boolean> isDisplayed() {
        return new OrderImage();
    }
}
