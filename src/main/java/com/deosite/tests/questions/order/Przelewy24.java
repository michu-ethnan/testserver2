package com.deosite.tests.questions.order;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class Przelewy24 {

    public static Question<Target> przelewy24() {
        return new Przelewy24BankLogo();
    }
}
