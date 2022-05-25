package com.deosite.tests.questions.minicart;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.Text;

import static com.deosite.tests.pages.MiniCart.MINICART_HEADER;

@Subject("The number of products")

public class NumberOfProducts implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(MINICART_HEADER).viewedBy(actor).asString().replace("[^\\\\d.]", "");
    }

}
