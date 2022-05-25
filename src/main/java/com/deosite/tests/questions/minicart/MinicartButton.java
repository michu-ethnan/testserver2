package com.deosite.tests.questions.minicart;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class MinicartButton {

    public static Question<Target> minicartButton() {
        return new MinicartWebelement();
    }
}
