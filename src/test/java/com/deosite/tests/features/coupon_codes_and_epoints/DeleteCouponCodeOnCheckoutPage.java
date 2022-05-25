package com.deosite.tests.features.coupon_codes_and_epoints;

import com.deosite.tests.actions.Open;
import com.deosite.tests.pages.*;
import com.deosite.tests.steps.SetupSteps;
import com.deosite.tests.tasks.Setup;
import com.deosite.tests.tasks.mainMenu.ClickCategory;
import com.deosite.tests.tasks.order.FillInBillingData;
import com.deosite.tests.tasks.product.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Steps;

import static com.deosite.tests.pages.CheckoutPage.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class DeleteCouponCodeOnCheckoutPage {

    @Steps
    SetupSteps setupSteps;

    @Given("that {word} applied a coupon code")
    public void that_actor_applied_a_coupon_code(String actor) {
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                ClickCategory.byCategoryNumber(7),
                Open.productPageByPositionRandomly(),
                AddProduct.toCart(),
                WaitUntil.the(MainMenu.SEARCH_BAR, isPresent()),
                MoveMouseDown.move(),
                Scroll.to(MiniCart.MINICART_BUTTON),
                Open.miniCart(),
                Open.checkoutPage(),
                Click.on(COUPON_CODE_BUTTON),
                WaitUntil.the(COUPON_CODE_INPUT, isPresent()),
                SendKeys.of("ABC123").into(COUPON_CODE_INPUT),
                Click.on(APPLY_COUPON_CODE_BUTTON)
                );
    }

    @And("she attempts to proceed to the payment page as {word}")
    public void actor_attempts_to_proceed_to_the_payment_page(String userType) {
        theActorInTheSpotlight().attemptsTo(
                FillInBillingData.type(userType),
                Click.on(SUBMIT_BUTTON),
                WaitUntil.the(PICKUP_POINT_SELECT, isNotPresent()),
                WaitUntil.the(PaymentPage.DELETE_COUPON_CODE_BUTTON, isPresent())
        );
    }

    @And("she attempts to return to the previous page")
    public void actor_attempts_to_return_to_the_previous_page() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(PaymentPage.BACK_TO_CHECKOUT_BUTTON),
                WaitUntil.the(SUBMIT_BUTTON, isPresent())
        );
    }

    @When("she removes it")
    public void actor_deletes_it() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(DELETE_COUPON_CODE_BUTTON, isClickable()),
                Click.on(DELETE_COUPON_CODE_BUTTON)
        );
    }

    @Then("she should see that the code is not displayed")
    public void actor_should_see_that_the_code_is_not_displayed() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(COUPON_CODE_INPUT, isPresent()),
                Ensure.that(DELETE_COUPON_CODE_BUTTON).isNotDisplayed()
        );
    }
}
