package com.deosite.tests.questions.register;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.UUID;

public class RandomEmailAddress implements Question<String> {
    public String answeredBy(Actor actor) {
        return "random-" + UUID.randomUUID().toString() + "@example.com";
    }

    public static RandomEmailAddress randomEmailAddress() {
        return new RandomEmailAddress();
    }
}
