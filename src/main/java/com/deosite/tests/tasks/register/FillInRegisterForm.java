package com.deosite.tests.tasks.register;

import com.deosite.tests.abilities.Load;
import com.deosite.tests.model.register.Register;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.thucydides.core.annotations.Step;

import java.util.UUID;

import static com.deosite.tests.pages.LoginPage.EMAIL_INPUT;
import static com.deosite.tests.pages.LoginPage.PASSWORD_INPUT;
import static com.deosite.tests.pages.RegisterPage.LAST_NAME_INPUT;
import static com.deosite.tests.pages.RegisterPage.NAME_INPUT;

public class FillInRegisterForm implements Task {

    private final String userType;

    public FillInRegisterForm(String userType) {
        this.userType = userType;
    }

    @Override
    @Step("{0} fills in register form")

    public <T extends Actor> void performAs(T actor) {

        Register register = Load.as(actor).register(userType);

        actor.attemptsTo(
                SendKeys.of(randomEmailAddress()).into(EMAIL_INPUT),
                SendKeys.of(register.getPassword()).into(PASSWORD_INPUT),
                SendKeys.of(register.getName()).into(NAME_INPUT),
                SendKeys.of(register.getLastName()).into(LAST_NAME_INPUT)
        );
    }

    private static String randomEmailAddress() {
        return "random-" + UUID.randomUUID().toString() + "@example.com";
    }

    public static Task type(String userType) {
        return Instrumented.instanceOf(FillInRegisterForm.class).withProperties(userType);
    }
}
