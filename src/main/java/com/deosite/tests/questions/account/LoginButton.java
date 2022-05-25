package com.deosite.tests.questions.account;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

import static com.deosite.tests.pages.LoginPage.LOGIN_BUTTON;

@Subject("Is login button displayed")
public class LoginButton implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return LOGIN_BUTTON.resolveFor(actor).isDisplayed();
    }

    public static Question<Boolean> isDisplayed() {
        return new LoginButton();
    }
}
