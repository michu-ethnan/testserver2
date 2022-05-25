package com.deosite.tests.features.coupon_codes_and_epoints;

import com.deosite.tests.actions.Open;
import com.deosite.tests.pages.*;
import com.deosite.tests.steps.SetupSteps;
import com.deosite.tests.tasks.Setup;
import com.deosite.tests.tasks.basic.RefreshPage;
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

import static com.deosite.tests.pages.CheckoutPage.EMAIL_INPUT;
import static com.deosite.tests.pages.CheckoutPage.SUBMIT_BUTTON;
import static com.deosite.tests.pages.CheckoutPage.APPLY_COUPON_CODE_BUTTON;
import static com.deosite.tests.pages.MainMenu.NEWSLETTER_POPUP;
import static com.deosite.tests.pages.MainMenu.NEWSLETTER_POPUP_CLOSE_BUTTON;
import static com.deosite.tests.pages.PaymentPage.COUPON_CODE_BUTTON;
import static com.deosite.tests.pages.PaymentPage.COUPON_CODE_INPUT;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class EnterCouponCodeOnPaymentPage {

    @Steps
    SetupSteps setupSteps;

    @Given("that {word} happens to be on the payment page")
    public void that_actor_happens_to_be_on_the_payment_page(String actor) {
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
                WaitUntil.the(EMAIL_INPUT, isPresent()).forNoMoreThan(50).seconds()
        );
    }

    @And("he fills in billing data as {word}")
    public void actor_fills_in_billing_data_as_person(String userType) {
        theActorInTheSpotlight().attemptsTo(
                FillInBillingData.type(userType),
                Click.on(SUBMIT_BUTTON),
                WaitUntil.the(COUPON_CODE_BUTTON, isPresent())
        );
    }

    @When("he enters a coupon code")
    public void actor_enters_a_coupon_code() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(COUPON_CODE_BUTTON),
                SendKeys.of("ABC123").into(COUPON_CODE_INPUT),
                Click.on(APPLY_COUPON_CODE_BUTTON),
                WaitUntil.the(PaymentPage.DELETE_COUPON_CODE_BUTTON, isPresent())
        );
    }

    @And("he refreshes the payment page")
    public void actor_refreshes_the_payment_page() {
        theActorInTheSpotlight().attemptsTo(
                RefreshPage.refresh(),
                WaitUntil.the(NEWSLETTER_POPUP_CLOSE_BUTTON, isPresent()),
                Click.on(NEWSLETTER_POPUP_CLOSE_BUTTON),
                WaitUntil.the(PaymentPage.DELETE_COUPON_CODE_BUTTON, isPresent())
        );
    }

    @Then("he should see that the code is added")
    public void actor_should_see_that_the_code_is_added() {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(PaymentPage.DELETE_COUPON_CODE_BUTTON).isEnabled()
        );
    }
}
