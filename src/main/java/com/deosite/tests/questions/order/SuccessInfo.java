package com.deosite.tests.questions.order;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.Text;

import static com.deosite.tests.pages.SuccessPage.ADDITIONAL_SUCCESS_INFO;

@Subject("successfully placed order info")
public class SuccessInfo implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(ADDITIONAL_SUCCESS_INFO).viewedBy(actor).asString();
    }
}
