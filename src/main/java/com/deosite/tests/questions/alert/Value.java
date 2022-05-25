package com.deosite.tests.questions.alert;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.Text;

import static com.deosite.tests.pages.Alert.ALERT_BOX;

@Subject("value of alert")
public class Value implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(ALERT_BOX).viewedBy(actor).asString();
    }
}
