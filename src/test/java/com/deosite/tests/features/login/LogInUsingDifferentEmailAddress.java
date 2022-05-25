package com.deosite.tests.features.login;

import com.deosite.tests.actions.Open;
import com.deosite.tests.questions.account.EmailName;
import com.deosite.tests.steps.SetupSteps;
import com.deosite.tests.tasks.Setup;
import com.deosite.tests.tasks.basic.*;
import com.deosite.tests.tasks.login.FillInLoginForm;
import com.deosite.tests.tasks.login.SubmitLoginForm;
import com.deosite.tests.tasks.login.FillInLoginFormWithDifferentEmailAddress;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Steps;

import static com.deosite.tests.pages.AccountPage.EMAIL_ADDRESS;
import static com.deosite.tests.pages.AccountPage.LOGOUT_BUTTON;
import static com.deosite.tests.pages.LoginPage.LOGIN_BUTTON;
import static com.deosite.tests.pages.LoginPage.SUBMIT_BUTTON;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class LogInUsingDifferentEmailAddress {

    @Steps
    SetupSteps setupSteps;

    String firstEmail;
    String secondEmail;

    @Given("that {word} decided to log in")
    public void that_actor_decided_to_log_in(String actor) {
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                WaitUntil.the(LOGIN_BUTTON, isPresent()).forNoMoreThan(100).seconds(),
                Open.loginPage(),
                FillInLoginForm.type("login"),
                SubmitLoginForm.submitLoginForm(),
                WaitUntil.the(SUBMIT_BUTTON, isNotPresent()),
                Open.accountPage(),
                WaitUntil.the(EMAIL_ADDRESS, isPresent())
        );
    }

    @And("he logs out")
    public void actor_logs_out() {
        firstEmail = EmailName.getEmailName().answeredBy(theActorInTheSpotlight());
        theActorInTheSpotlight().attemptsTo(
                Click.on(LOGOUT_BUTTON),
                WaitUntil.the(LOGIN_BUTTON, isPresent()).forNoMoreThan(50).seconds(),
                WaitUntil.the(LOGIN_BUTTON, isClickable())
        );
    }

    @When("he logs in using {string}")
    public void actor_logs_in_using_different_email_address(String userType) {
        theActorInTheSpotlight().attemptsTo(
                FillInLoginFormWithDifferentEmailAddress.type("differentEmail")
        );

        secondEmail = EmailName.getEmailName().answeredBy(theActorInTheSpotlight());

    }

    @Then("he should see that his personal data are different")
    public void actor_should_see_that_his_personal_data_are_different() {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(firstEmail).isNotEqualTo(secondEmail)
        );
    }
}
