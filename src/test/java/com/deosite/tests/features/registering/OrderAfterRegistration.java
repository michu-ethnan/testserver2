package com.deosite.tests.features.registering;

import com.deosite.tests.pages.*;
import com.deosite.tests.questions.order.Success;
import com.deosite.tests.steps.SetupSteps;
import com.deosite.tests.tasks.Setup;
import com.deosite.tests.tasks.order.GoToCheckout;
import com.deosite.tests.tasks.order.FillInBillingDataWithoutEmailAddress;
import com.deosite.tests.tasks.order.PayAfterLogin;
import com.deosite.tests.tasks.order.PlaceAfterLogin;
import com.deosite.tests.tasks.register.FillInRegisterForm;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Steps;

import static com.deosite.tests.abilities.Load.as;
import static com.deosite.tests.pages.Alert.ALERT_BOX;
import static com.deosite.tests.pages.LoginPage.SUBMIT_BUTTON;
import static com.deosite.tests.pages.RegisterPage.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static org.hamcrest.CoreMatchers.equalTo;

public class OrderAfterRegistration {

    @Steps
    SetupSteps setupSteps;

    @Given("that {word} is a registered user")
    public void that_actor_is_a_registered_user(String actor) {
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                Click.on(REGISTER_BUTTON),
                WaitUntil.the(REGISTER_SUBMIT_BUTTON, isPresent()),
                FillInRegisterForm.type("register"),
                Click.on(AGREEMENT_CHECKBOX),
                Click.on(REGISTER_SUBMIT_BUTTON),
                WaitUntil.the(ALERT_BOX, isPresent()).forNoMoreThan(100).seconds()
        );
    }

    @When("she places an order {string}")
    public void actor_places_an_order_after_registration(String userType) {
        theActorInTheSpotlight().attemptsTo(
                GoToCheckout.withProduct("mug"),
                FillInBillingDataWithoutEmailAddress.type(userType)
        );
    }

    @And("she pays using {word}")
    public void actor_pays_using_selected_payment_method(String paymentType) {
        theActorInTheSpotlight().attemptsTo(
                PayAfterLogin.by(paymentType),
                PlaceAfterLogin.order(),
                WaitUntil.the(SuccessPage.SUCCESS_ORDER_MESSAGE, isPresent()).forNoMoreThan(100).seconds()
        );
    }

    @Then("she should see that the order was submitted")
    public void actor_should_see_that_the_order_was_submitted() {
        theActorInTheSpotlight().should(
                seeThat(
                        Success.message(), equalTo(
                                as(theActorInTheSpotlight()).translate("success order message")
                        )),
                seeThat(Success.info(), equalTo(
                        as(theActorInTheSpotlight()).translate("additional success info")
                ))
        );
    }
}
