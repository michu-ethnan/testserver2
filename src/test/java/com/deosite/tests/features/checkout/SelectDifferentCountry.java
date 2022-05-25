package com.deosite.tests.features.checkout;

import com.deosite.tests.actions.Open;
import com.deosite.tests.pages.*;
import com.deosite.tests.steps.SetupSteps;
import com.deosite.tests.tasks.Setup;
import com.deosite.tests.tasks.mainMenu.ClickCategory;
import com.deosite.tests.tasks.order.FillInBillingData;
import com.deosite.tests.tasks.order.SelectBillingCountry;
import com.deosite.tests.tasks.product.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Steps;

import static com.deosite.tests.pages.Alert.ALERT_BOX;
import static com.deosite.tests.pages.CheckoutPage.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class SelectDifferentCountry {

    @Steps
    SetupSteps setupSteps;

    @Given("that {word} wants to select a billing country")
    public void that_actor_wants_to_select_a_billing_country(String actor) {
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                ClickCategory.byCategoryNumber(5),
                Open.productPageByPositionRandomly(),
                AddProduct.toCart(),
                MoveMouseDown.move(),
                Scroll.to(MiniCart.MINICART_BUTTON),
                Open.miniCart(),
                Open.checkoutPage(),
                WaitUntil.the(EMAIL_INPUT, isPresent()).forNoMoreThan(50).seconds()
        );
    }

    @When("she chooses Portugal as a {word}")
    public void actor_chooses_Portugal(String userType) {
        theActorInTheSpotlight().attemptsTo(
                FillInBillingData.type(userType),
                Click.on(COUNTRY_BILLING_INPUT),
                SelectBillingCountry.byCountry(16)
        );
    }
    @When("she chooses Ireland as a {word}")
    public void actor_chooses_Ireland(String userType) {
        theActorInTheSpotlight().attemptsTo(
                FillInBillingData.type(userType),
                Click.on(COUNTRY_BILLING_INPUT),
                SelectBillingCountry.byCountry(9)
        );
    }

    @And("clicks the payment page button")
    public void clicks_the_payment_page_button() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(SUBMIT_BUTTON, isClickable()),
                Click.on(SUBMIT_BUTTON)
        );
    }

    @Then("she should be on the payment page")
    public void actor_should_be_on_the_payment_page() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(PaymentPage.AGREEMENT_CHECKBOX, isPresent()),
                Ensure.that(PaymentPage.AGREEMENT_CHECKBOX).isDisplayed()
        );
    }
}
