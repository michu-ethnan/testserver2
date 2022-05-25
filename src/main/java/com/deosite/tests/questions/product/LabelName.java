package com.deosite.tests.questions.product;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.Text;

import static com.deosite.tests.pages.ProductPage.CONFIGURABLE_SELECT_LABEL;

@Subject("label name")
public class LabelName implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(CONFIGURABLE_SELECT_LABEL).viewedBy(actor).asString();
    }

    public static Question<String> labelName() {
        return new LabelName();
    }
}
