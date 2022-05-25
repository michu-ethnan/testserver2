package com.deosite.tests.questions.order;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.targets.Target;

import static com.deosite.tests.pages.CardPaymentPage.FIRST_BANK_LOGO;

@Subject("Przelewy24 page is visible")
public class Przelewy24BankLogo implements Question<Target> {

    @Override
    public Target answeredBy (Actor actor){
        return FIRST_BANK_LOGO;
    }

}
