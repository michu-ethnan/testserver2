package com.deosite.tests.questions.account;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.Text;

import static com.deosite.tests.pages.AccountPage.MY_ACCOUNT_HEADER;

@Subject("Value of my account header")
public class Value implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return Text.of(MY_ACCOUNT_HEADER).viewedBy(actor).asString();
    }
}
