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

import static com.deosite.tests.pages.CheckoutPage.*;
import static com.deosite.tests.pages.LoginPage.EMAIL_INPUT;
import static com.deosite.tests.pages.LoginPage.LOGIN_BUTTON;
import static com.deosite.tests.pages.MainMenu.SEARCH_BAR;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class DeleteCouponCodeOnCheckoutPageLoggedIn {

    @Steps
    SetupSteps setupSteps;

    @Given("that {word} is a logged in user")
    public void that_actor_is_a_logged_in_user(String actor) {
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

    @When("she adds a coupon code")
    public void actor_adds_a_coupon_code() {
        theActorInTheSpotlight().attemptsTo(
                ClickCategory.byCategoryNumber(3),
                Open.productPageByPositionRandomly(),
                AddProduct.toCart(),
                WaitUntil.the(MainMenu.SEARCH_BAR, isPresent()),
                MoveMouseDown.move(),
                Scroll.to(MiniCart.MINICART_BUTTON),
                Open.miniCart(),
                Open.checkoutPage(),
                WaitUntil.the(COUPON_CODE_BUTTON, isPresent()),
                Click.on(COUPON_CODE_BUTTON),
                WaitUntil.the(COUPON_CODE_INPUT, isPresent()),
                SendKeys.of("ABC123").into(COUPON_CODE_INPUT),
                Click.on(APPLY_COUPON_CODE_BUTTON),
                WaitUntil.the(DELETE_COUPON_CODE_BUTTON, isPresent())

        );
    }

    @And("she attempts to go to the payment page")
    public void actor_attempts_to_go_to_the_payment_page_as_person() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(SUBMIT_BUTTON),
                WaitUntil.the(PICKUP_POINT_SELECT, isNotPresent()),
                WaitUntil.the(PaymentPage.DELETE_COUPON_CODE_BUTTON, isPresent())
        );
    }

    @And("she returns to the previous step")
    public void actor_returns_to_the_previous_step() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(PaymentPage.BACK_TO_CHECKOUT_BUTTON),
                WaitUntil.the(DELETE_COUPON_CODE_BUTTON, isPresent())
        );
    }

    @And("she deletes the coupon code")
    public void actor_deletes_the_coupon_code() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(LoginPage.SUBMIT_BUTTON, isNotPresent()),
                WaitUntil.the(DELETE_COUPON_CODE_BUTTON, isClickable()),
                Click.on(DELETE_COUPON_CODE_BUTTON)
        );
    }

    @Then("she should see that the code is not visible")
    public void actor_should_see_that_the_code_is_not_visible() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(COUPON_CODE_INPUT, isPresent()),
                Ensure.that(LoginPage.SUBMIT_BUTTON).isNotDisplayed(),
                Ensure.that(DELETE_COUPON_CODE_BUTTON).isNotDisplayed(),
                Click.on(DELETE_PRODUCT_BUTTON_AFTER_COUPON_CODE),
                Ensure.that(DELETE_COUPON_CODE_BUTTON_AFTER_LOGIN).isNotDisplayed()
        );
    }
}
