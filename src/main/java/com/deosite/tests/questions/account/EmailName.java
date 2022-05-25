package com.deosite.tests.questions.account;

import com.deosite.tests.pages.AccountPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.Text;

@Subject("Email name")

public class EmailName implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(AccountPage.EMAIL_NAME).viewedBy(actor).asString();
    }

    public static Question<String> getEmailName() {
        return new EmailName();
    }
}

