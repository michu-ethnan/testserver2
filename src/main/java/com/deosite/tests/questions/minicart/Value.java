package com.deosite.tests.questions.minicart;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.Text;

import static com.deosite.tests.pages.MiniCart.EMPTY_CART_MESSAGE;

@Subject("The value of the empty cart message")
public class Value implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(EMPTY_CART_MESSAGE).viewedBy(actor).asString();
    }
}
