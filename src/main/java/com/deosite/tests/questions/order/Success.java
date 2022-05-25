package com.deosite.tests.questions.order;

import net.serenitybdd.screenplay.Question;

public class Success {

    public static Question<String> message() {
        return new SuccessMessage();
    }

    public static Question<String> info() {
        return new SuccessInfo();
    }
}
