package com.deosite.tests.features.login;

import com.deosite.tests.actions.Open;
import com.deosite.tests.questions.account.MyAccountHeader;
import com.deosite.tests.tasks.basic.*;
import com.deosite.tests.tasks.login.FillInLoginForm;
import com.deosite.tests.tasks.login.SubmitLoginForm;

import static com.deosite.tests.abilities.Load.as;
import static com.deosite.tests.pages.AccountPage.EMAIL_ADDRESS;
import static com.deosite.tests.pages.AccountPage.MY_ACCOUNT_HEADER;
import static com.deosite.tests.pages.LoginPage.LOGIN_BUTTON;
import static com.deosite.tests.pages.LoginPage.MY_ACCOUNT_BUTTON;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import com.deosite.tests.steps.SetupSteps;
import com.deosite.tests.tasks.Setup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Steps;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static org.hamcrest.Matchers.equalTo;

public class LogIn {

    @Steps
    SetupSteps setupSteps;

    @Given("that {word} is on the login page")
    public void actor_is_on_login_page(String actor) {
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                WaitUntil.the(LOGIN_BUTTON, isPresent()).forNoMoreThan(50).seconds(),
                Open.loginPage()
        );
    }

    @When("(s)he fills in login form")
    public void actor_tries_to_fill_in_login_form() {
        theActorInTheSpotlight().attemptsTo(
                FillInLoginForm.type("login")
        );
    }

    @And("(s)he submits it")
    public void actor_submits_login_form() {
        theActorInTheSpotlight().attemptsTo(
                SubmitLoginForm.submitLoginForm()
        );
    }

    @And("s(he) goes to My Account")
    public void actor_goes_to_my_account() {
        theActorInTheSpotlight().attemptsTo(
                MoveMouseToTop.move(),
                Open.accountPage(),
                WaitUntil.the(EMAIL_ADDRESS, isPresent())
                //WaitUntil.the(MY_ACCOUNT_BUTTON, isPresent()),
               // Open.accountPage()
        );
    }

    @Then("s(he) should be able to see {string}")
    public void actor_should_see_account_header(String myAccountHeader) {
        WaitUntil.the(MY_ACCOUNT_HEADER, isPresent()).forNoMoreThan(50).seconds();
        theActorInTheSpotlight().should(seeThat(MyAccountHeader.value(), equalTo(
                as(theActorInTheSpotlight()).translate(myAccountHeader)
                )
        ));
    }
}
