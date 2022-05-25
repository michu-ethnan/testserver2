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
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Steps;

import static com.deosite.tests.pages.CheckoutPage.*;
import static com.deosite.tests.pages.PaymentPage.COUPON_CODE_BUTTON;
import static com.deosite.tests.pages.PaymentPage.COUPON_CODE_INPUT;
import static com.deosite.tests.pages.ProductPage.ADD_TO_CART_BUTTON;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class DeleteCouponCodeOnPaymentPage {

    @Steps
    SetupSteps setupSteps;

    @Given("that {word} attempts to apply a coupon code as {word}")
    public void actor_attempts_to_apply_a_coupon_code(String actor, String userType) {
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                ClickCategory.byCategoryNumber(6),
                Open.productPageByPositionRandomly(),
                WaitUntil.the(ADD_TO_CART_BUTTON, isPresent()),
                AddProduct.toCart(),
                WaitUntil.the(MainMenu.SEARCH_BAR, isPresent()),
                MoveMouseDown.move(),
                Scroll.to(MiniCart.MINICART_BUTTON),
                Open.miniCart(),
                Open.checkoutPage(),
                FillInBillingData.type(userType),
                Click.on(SUBMIT_BUTTON),
                WaitUntil.the(COUPON_CODE_BUTTON, isPresent()),
                WaitUntil.the(DELIVERY_TYPE_PICKUP_POINT, isNotPresent()),
                Click.on(COUPON_CODE_BUTTON),
                SendKeys.of("ABC123").into(COUPON_CODE_INPUT),
                Click.on(APPLY_COUPON_CODE_BUTTON)
        );
    }

    @When("he attempts to delete it")
    public void actor_attempts_to_delete_it() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(PaymentPage.DELETE_COUPON_CODE_BUTTON, isPresent()),
                Click.on(PaymentPage.DELETE_COUPON_CODE_BUTTON)
        );
    }

    @Then("he should see that the code was deleted")
    public void actor_should_see_that_the_code_was_deleted() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(PaymentPage.COUPON_CODE_INPUT, isPresent()),
                Ensure.that(DELETE_COUPON_CODE_BUTTON).isNotDisplayed()
        );
    }
}
