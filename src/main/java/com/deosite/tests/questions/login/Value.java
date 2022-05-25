package com.deosite.tests.questions.login;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.Text;

import static com.deosite.tests.pages.LoginPage.LOGIN_BUTTON;

@Subject("Button value")
public class Value implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(LOGIN_BUTTON).viewedBy(actor).asString();
    }
}
