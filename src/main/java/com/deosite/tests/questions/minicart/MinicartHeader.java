package com.deosite.tests.questions.minicart;

import net.serenitybdd.screenplay.Question;

public class MinicartHeader {

    public static Question<String> numberOfProducts() {
        return new NumberOfProducts();
    }
}
