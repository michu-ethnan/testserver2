package com.deosite.tests.questions.alert;

import net.serenitybdd.screenplay.Question;

public class Alert {

    public static Question<String> value() {
        return new Value();
    }
}
