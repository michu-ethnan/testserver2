package com.deosite.tests.questions.account;

import net.serenitybdd.screenplay.Question;

public class MyAccountHeader {

    public static Question<String> value() {
        return new Value();
    }
}
