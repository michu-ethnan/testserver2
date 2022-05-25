package com.deosite.tests.questions.minicart;

import net.serenitybdd.screenplay.Question;

public class EmptyCartMessage {

    public static Question<String> value() {
        return new Value();
    }
}
