package com.deosite.tests.questions.login;

import net.serenitybdd.screenplay.Question;

public class LoginButton {

    public static Question<String> text() {
        return new Value();
    }
}
