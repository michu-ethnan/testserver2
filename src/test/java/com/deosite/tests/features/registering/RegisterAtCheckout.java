package com.deosite.tests.features.registering;

import com.deosite.tests.pages.CheckoutPage;
import com.deosite.tests.questions.account.MyAccountHeader;
import com.deosite.tests.questions.register.RandomEmailAddress;
import com.deosite.tests.steps.SetupSteps;
import com.deosite.tests.tasks.Setup;
import com.deosite.tests.tasks.order.GoToCheckout;
import com.deosite.tests.tasks.order.FillInBillingDataWithoutEmailAddress;
import com.deosite.tests.tasks.order.Pay;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Steps;

import static com.deosite.tests.abilities.Load.as;
import static com.deosite.tests.pages.AccountPage.MY_ACCOUNT_HEADER;
import static com.deosite.tests.pages.CheckoutPage.SHIPPING_ADDRESS_IS_THE_SAME_CHECKBOX;
import static com.deosite.tests.pages.LoginPage.MY_ACCOUNT_BUTTON;
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
import static org.hamcrest.Matchers.equalTo;

public class RegisterAtCheckout {

    @Steps
    SetupSteps setupSteps;

    @Given("that {word} is at checkout")
    public void that_actor_is_at_checkout(String actor) {
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                GoToCheckout.withProduct("mug")
        );
    }

    @And("she attempts to fill in the checkout form {string}")
    public void actor_attempts_to_fill_in_the_checkout_form_without_email_address(String userType) {
        theActorInTheSpotlight().attemptsTo(
                SendKeys.of(RandomEmailAddress.randomEmailAddress().answeredBy(theActorInTheSpotlight())).into(CheckoutPage.EMAIL_INPUT),
                FillInBillingDataWithoutEmailAddress.type(userType),
                Click.on(SHIPPING_ADDRESS_IS_THE_SAME_CHECKBOX)
        );
    }

    @And("she pays by {word}")
    public void she_pays_by_transfer(String paymentType) {
        theActorInTheSpotlight().attemptsTo(
                Pay.by(paymentType)
        );
    }

    @When("she submits an order")
    public void she_submits_an_order() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(CREATE_ACCOUNT_CHECKBOX, isPresent()),
                Click.on(CREATE_ACCOUNT_CHECKBOX),
                WaitUntil.the(ACCOUNT_PASSWORD_INPUT, isEnabled()),
                SendKeys.of("Test12345!").into(ACCOUNT_PASSWORD_INPUT),
                Click.on(ACCOUNT_AGREEMENT_CHECKBOX),
                Click.on(AGREEMENT_CHECKBOX),
                Click.on(PLACE_ORDER_BUTTON),
                WaitUntil.the(BACK_TO_HOME_PAGE_BUTTON, isPresent()).forNoMoreThan(100).seconds(),
                Click.on(BACK_TO_HOME_PAGE_BUTTON),
                WaitUntil.the(MY_ACCOUNT_BUTTON, isPresent()),
                Click.on(MY_ACCOUNT_BUTTON)
        );
    }

    @Then("she should notice that {string} is visible")
    public void actor_should_notice_that_the_order_was_placed(String myAccountHeader) {
        WaitUntil.the(MY_ACCOUNT_HEADER, isPresent());
        theActorInTheSpotlight().should(seeThat(MyAccountHeader.value(), equalTo(
                as(theActorInTheSpotlight()).translate(myAccountHeader)
                )
        ));
    }
}
