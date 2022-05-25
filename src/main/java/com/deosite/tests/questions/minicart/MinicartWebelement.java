package com.deosite.tests.questions.minicart;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.targets.Target;

import static com.deosite.tests.pages.MiniCart.MINICART_BUTTON;

@Subject("Webelement")
public class MinicartWebelement implements Question<Target> {

    @Override

    public Target answeredBy(Actor actor) {
        return MINICART_BUTTON;
    }
}
