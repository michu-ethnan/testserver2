package com.deosite.tests.features.registering;

import com.deosite.tests.actions.Open;
import com.deosite.tests.pages.*;
import com.deosite.tests.questions.account.MyAccountHeader;
import com.deosite.tests.steps.SetupSteps;
import com.deosite.tests.tasks.Setup;
import com.deosite.tests.tasks.register.FillInRegisterForm;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Steps;

import static com.deosite.tests.abilities.Load.as;
import static com.deosite.tests.pages.AccountPage.MY_ACCOUNT_HEADER;
import static com.deosite.tests.pages.LoginPage.MY_ACCOUNT_BUTTON;
import static com.deosite.tests.pages.LoginPage.SUBMIT_BUTTON;
import static com.deosite.tests.pages.RegisterPage.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static org.hamcrest.Matchers.equalTo;

public class RegisterNewAddress {

    @Steps
    SetupSteps setupSteps;

    @Given("that {word} is on the register page")
    public void that_actor_is_on_the_register_page(String actor) {
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                Click.on(REGISTER_BUTTON),
                WaitUntil.the(REGISTER_SUBMIT_BUTTON, isPresent())
        );
    }

    @When("he submits the registration form")
    public void actor_submits_the_registration_form() {
        theActorInTheSpotlight().attemptsTo(
                FillInRegisterForm.type("register"),
                Click.on(AGREEMENT_CHECKBOX),
                Click.on(REGISTER_SUBMIT_BUTTON),
                WaitUntil.the(Alert.ALERT_BOX, isPresent())
                );
    }

    @And("he clicks My Account button")
    public void actor_clicks_my_account_button() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(MY_ACCOUNT_BUTTON, isClickable()),
                Open.accountPage()
        );
    }

    @Then("{string} should appear")
    public void account_header_should_appear(String myAccountHeader) {
        WaitUntil.the(MY_ACCOUNT_HEADER, isPresent());
        theActorInTheSpotlight().should(seeThat(MyAccountHeader.value(), equalTo(
                as(theActorInTheSpotlight()).translate(myAccountHeader)
                )
        ));
    }
}
