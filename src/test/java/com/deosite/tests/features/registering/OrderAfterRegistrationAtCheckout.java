package com.deosite.tests.features.registering;

import com.deosite.tests.pages.CheckoutPage;
import com.deosite.tests.questions.order.Success;
import com.deosite.tests.questions.register.RandomEmailAddress;
import com.deosite.tests.steps.SetupSteps;
import com.deosite.tests.tasks.Setup;
import com.deosite.tests.tasks.order.GoToCheckout;
import com.deosite.tests.tasks.order.FillInBillingDataWithoutEmailAddress;
import com.deosite.tests.tasks.order.Pay;
import com.deosite.tests.tasks.order.ChooseDelivery;
import com.deosite.tests.tasks.order.PayAfterLogin;
import com.deosite.tests.tasks.order.PlaceAfterLogin;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Steps;

import static com.deosite.tests.abilities.Load.as;
import static com.deosite.tests.pages.CheckoutPage.SHIPPING_ADDRESS_IS_THE_SAME_CHECKBOX;
import static com.deosite.tests.pages.MainMenu.SEARCH_BAR;
import static com.deosite.tests.pages.PaymentPage.CREATE_ACCOUNT_CHECKBOX;
import static com.deosite.tests.pages.PaymentPage.ACCOUNT_PASSWORD_INPUT;
import static com.deosite.tests.pages.PaymentPage.ACCOUNT_AGREEMENT_CHECKBOX;
import static com.deosite.tests.pages.PaymentPage.AGREEMENT_CHECKBOX;
import static com.deosite.tests.pages.PaymentPage.PLACE_ORDER_BUTTON;
import static com.deosite.tests.pages.SuccessPage.BACK_TO_HOME_PAGE_BUTTON;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static org.hamcrest.CoreMatchers.equalTo;

public class OrderAfterRegistrationAtCheckout {

    @Steps
    SetupSteps setupSteps;

    @Given("that {word} is a user who filled in checkout form {string}")
    public void that_actor_is_a_user_registered_at_checkout(String actor, String userType) {
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                GoToCheckout.withProduct("mug"),
                SendKeys.of(RandomEmailAddress.randomEmailAddress().answeredBy(theActorInTheSpotlight())).into(CheckoutPage.EMAIL_INPUT),
                FillInBillingDataWithoutEmailAddress.type(userType),
                Click.on(SHIPPING_ADDRESS_IS_THE_SAME_CHECKBOX)
        );
    }

    @And("who paid using {word}")
    public void who_paid_using_transfer(String paymentType) {
        theActorInTheSpotlight().attemptsTo(
                Pay.by(paymentType),
                WaitUntil.the(CREATE_ACCOUNT_CHECKBOX, isPresent()),
                Click.on(CREATE_ACCOUNT_CHECKBOX),
                WaitUntil.the(ACCOUNT_PASSWORD_INPUT, isEnabled()),
                SendKeys.of("Test12345!").into(ACCOUNT_PASSWORD_INPUT),
                Click.on(ACCOUNT_AGREEMENT_CHECKBOX),
                WaitUntil.the(AGREEMENT_CHECKBOX, isPresent()),
                Click.on(AGREEMENT_CHECKBOX),
                Click.on(PLACE_ORDER_BUTTON),
                WaitUntil.the(BACK_TO_HOME_PAGE_BUTTON, isPresent()).forNoMoreThan(100).seconds(),
                Click.on(BACK_TO_HOME_PAGE_BUTTON),
                WaitUntil.the(SEARCH_BAR, isPresent())
        );
    }

    @When("she submits an order after registration using {word} delivery")
    public void actor_submits_an_order_after_registration(String deliveryType) {
        theActorInTheSpotlight().attemptsTo(
                GoToCheckout.withProduct("mug"),
                ChooseDelivery.byType(deliveryType)
        );
    }

    @And("she makes a payment using {word}")
    public void actor_makes_a_payment_using_transfer(String paymentType) {
        theActorInTheSpotlight().attemptsTo(
                PayAfterLogin.by(paymentType),
                PlaceAfterLogin.order()
        );
    }

    @Then("she should notice that the order was submitted")
    public void actor_should_notice_that_the_order_was_submitted() {
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