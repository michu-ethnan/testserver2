package com.deosite.tests.questions.order;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.Text;

import static com.deosite.tests.pages.SuccessPage.SUCCESS_ORDER_MESSAGE;

@Subject("successfully placed order message")
public class SuccessMessage implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(SUCCESS_ORDER_MESSAGE).viewedBy(actor).asString();
    }
}
