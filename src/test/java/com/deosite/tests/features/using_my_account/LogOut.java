package com.deosite.tests.features.using_my_account;

import com.deosite.tests.actions.Open;
import com.deosite.tests.questions.account.LoginButton;
import com.deosite.tests.steps.SetupSteps;
import com.deosite.tests.tasks.Setup;
import com.deosite.tests.tasks.basic.*;
import com.deosite.tests.tasks.login.SubmitLoginForm;
import com.deosite.tests.tasks.login.FillInLoginForm;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Steps;

import static com.deosite.tests.pages.AccountPage.LOGOUT_BUTTON;
import static com.deosite.tests.pages.AccountPage.MY_ACCOUNT_HEADER;
import static com.deosite.tests.pages.LoginPage.LOGIN_BUTTON;
import static com.deosite.tests.pages.LoginPage.MY_ACCOUNT_BUTTON;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class LogOut {

    @Steps
    SetupSteps setupSteps;

    @Given("that {word} is logged into My Account")
    public void that_actor_is_logged_into_my_account(String actor) {
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                WaitUntil.the(LOGIN_BUTTON, isPresent()),
                Open.loginPage(),
                FillInLoginForm.type("login"),
                SubmitLoginForm.submitLoginForm(),
                MoveMouseToTop.move(),
                WaitUntil.the(MY_ACCOUNT_BUTTON, isPresent()),
                Open.accountPage(),
                WaitUntil.the(MY_ACCOUNT_HEADER, isPresent())
        );
    }

    @When("she attempts to log out")
    public void she_attempts_to_log_out() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(LOGOUT_BUTTON, isClickable()),
                Click.on(LOGOUT_BUTTON),
                WaitUntil.the(LOGIN_BUTTON, isPresent()).forNoMoreThan(50).seconds(),
                WaitUntil.the(LOGIN_BUTTON, isClickable())
        );
    }

    @Then("she should see login button")
    public void she_should_see_login_button() {
        theActorInTheSpotlight().should(seeThat(LoginButton.isDisplayed()));
    }
}
