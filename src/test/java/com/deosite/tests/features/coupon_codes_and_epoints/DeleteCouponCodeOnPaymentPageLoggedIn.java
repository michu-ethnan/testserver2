package com.deosite.tests.features.coupon_codes_and_epoints;

import com.deosite.tests.actions.Open;
import com.deosite.tests.pages.*;
import com.deosite.tests.steps.SetupSteps;
import com.deosite.tests.tasks.Setup;
import com.deosite.tests.tasks.login.FillInLoginForm;
import com.deosite.tests.tasks.login.SubmitLoginForm;
import com.deosite.tests.tasks.mainMenu.ClickCategory;
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

import static com.deosite.tests.pages.CheckoutPage.SUBMIT_BUTTON;
import static com.deosite.tests.pages.CheckoutPage.APPLY_COUPON_CODE_BUTTON;
import static com.deosite.tests.pages.LoginPage.EMAIL_INPUT;
import static com.deosite.tests.pages.LoginPage.LOGIN_BUTTON;
import static com.deosite.tests.pages.MainMenu.SEARCH_BAR;
import static com.deosite.tests.pages.PaymentPage.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class DeleteCouponCodeOnPaymentPageLoggedIn {

    @Steps
    SetupSteps setupSteps;

    @Given("that {word} is a logged in person")
    public void actor_is_a_logged_in_person(String actor) {
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                WaitUntil.the(LOGIN_BUTTON, isPresent()),
                Open.loginPage(),
                WaitUntil.the(EMAIL_INPUT, isPresent()),
                FillInLoginForm.type("login"),
                SubmitLoginForm.submitLoginForm(),
                WaitUntil.the(SEARCH_BAR, isPresent())
        );
    }

    @When("he adds a coupon code on the payment page as {word}")
    public void actor_adds_a_coupon_on_the_payment_page(String userType) {
        theActorInTheSpotlight().attemptsTo(
                ClickCategory.byCategoryNumber(7),
                Open.productPageByPositionRandomly(),
                AddProduct.toCart(),
                WaitUntil.the(MainMenu.SEARCH_BAR, isPresent()),
                MoveMouseDown.move(),
                Scroll.to(MiniCart.MINICART_BUTTON),
                Open.miniCart(),
                Open.checkoutPage(),
                Click.on(SUBMIT_BUTTON),
                WaitUntil.the(CheckoutPage.DELIVERY_TYPE_COURIER, isNotPresent()),
                WaitUntil.the(PaymentPage.COUPON_CODE_BUTTON, isClickable()),
                Click.on(COUPON_CODE_BUTTON),
                SendKeys.of("ABC123").into(COUPON_CODE_INPUT),
                Click.on(APPLY_COUPON_CODE_BUTTON)
        );
    }

    @And("he removes it")
    public void actor_removes_it() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(DELETE_COUPON_CODE_BUTTON, isPresent()),
                Click.on(DELETE_COUPON_CODE_BUTTON)
        );
    }

    @Then("he should see that it was removed")
    public void actor_should_see_that_it_was_removed() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(COUPON_CODE_INPUT, isPresent()),
                Ensure.that(DELETE_COUPON_CODE_BUTTON).isNotDisplayed(),
                Ensure.that(LoginPage.SUBMIT_BUTTON).isNotDisplayed(),
                Click.on(CheckoutPage.DELETE_PRODUCT_BUTTON_AFTER_COUPON_CODE),
                Ensure.that(CheckoutPage.DELETE_PRODUCT_BUTTON_AFTER_COUPON_CODE).isNotDisplayed()

        );
    }
}
