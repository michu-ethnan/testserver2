package com.deosite.tests.features.creating_orders;

import com.deosite.tests.actions.*;
import com.deosite.tests.pages.*;
import com.deosite.tests.questions.order.Success;
import com.deosite.tests.steps.SetupSteps;
import com.deosite.tests.tasks.Setup;
import com.deosite.tests.tasks.basic.AcceptCookies;
import com.deosite.tests.tasks.login.FillInLoginForm;
import com.deosite.tests.tasks.login.SubmitLoginForm;
import com.deosite.tests.tasks.order.*;
import com.deosite.tests.tasks.product.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Steps;

import static com.deosite.tests.abilities.Load.as;
import static com.deosite.tests.pages.CheckoutPage.SHIPPING_ADDRESS_IS_THE_SAME_CHECKBOX;
import static com.deosite.tests.pages.CheckoutPage.SUBMIT_BUTTON;
import static com.deosite.tests.pages.LoginPage.LOGIN_BUTTON;
import static com.deosite.tests.pages.LoginPage.EMAIL_INPUT;
import static com.deosite.tests.pages.MainMenu.MINI_CART_BUTTON_AFTER_LOGIN;
import static com.deosite.tests.pages.MainMenu.SEARCH_BAR;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static org.hamcrest.CoreMatchers.equalTo;

public class OrderProductsLoggedIn {

    @Steps
    SetupSteps setupSteps;

    @Given("that {word} is logged in on account1")
    public void that_actor_is_logged_in1(String actor) {
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                WaitUntil.the(LOGIN_BUTTON, isPresent()),
                Open.loginPage(),
                WaitUntil.the(EMAIL_INPUT, isPresent()).forNoMoreThan(50).seconds(),
                FillInLoginForm.type("login to order_1"),
                SubmitLoginForm.submitLoginForm(),
                WaitUntil.the(SEARCH_BAR, isPresent())
        );
    }
    @Given("that {word} is logged in on account2")
    public void that_actor_is_logged_in2(String actor) {
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                WaitUntil.the(LOGIN_BUTTON, isPresent()),
                Open.loginPage(),
                WaitUntil.the(EMAIL_INPUT, isPresent()).forNoMoreThan(50).seconds(),
                FillInLoginForm.type("login to order_2"),
                SubmitLoginForm.submitLoginForm(),
                WaitUntil.the(SEARCH_BAR, isPresent())
        );
    }
    @Given("that {word} is logged in on account3")
    public void that_actor_is_logged_in3(String actor) {
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                WaitUntil.the(LOGIN_BUTTON, isPresent()),
                Open.loginPage(),
                WaitUntil.the(EMAIL_INPUT, isPresent()).forNoMoreThan(50).seconds(),
                FillInLoginForm.type("login to order_3"),
                SubmitLoginForm.submitLoginForm(),
                WaitUntil.the(SEARCH_BAR, isPresent())
        );
    }

    @When("he orders {string} using {word} delivery")
    public void actor_orders_product_using_chosen_delivery(String product, String deliveryType) {
        theActorInTheSpotlight().attemptsTo(
                Search.forProductByTranslatedKeyword(product),
                WaitUntil.the(CategoryPage.PAGINATION_ARROW, isPresent()),
                Open.productPageByPositionRandomly(),
                AddProduct.toCart(),
                MoveMouseDown.move(),
                Scroll.to(MiniCart.MINICART_BUTTON),
                Click.on(MINI_CART_BUTTON_AFTER_LOGIN),
                Open.checkoutPage(),
                WaitUntil.the(CheckoutPage.EMAIL_INPUT, isPresent()).forNoMoreThan(100).seconds(),
                ChooseDelivery.byType(deliveryType)
        );
    }

    @And("he changes billing address")
    public void actor_changes_billing_address() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(CheckoutPage.BILLING_ADDRESS_SELECT),
                SelectBillingAddress.byBillingAddress(1)
        );
    }

    @And("he clicks the same shipping address checkbox")
    public void actor_clicks_the_same_shipping_address_checkbox() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(SHIPPING_ADDRESS_IS_THE_SAME_CHECKBOX, isPresent()),
                Click.on(SHIPPING_ADDRESS_IS_THE_SAME_CHECKBOX)
        );
    }

    @And("he changes shipping address")
    public void actor_changes_shipping_address() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(CheckoutPage.SHIPPING_ADDRESS_CHECKBOX),
                Click.on(CheckoutPage.SHIPPING_ADDRESS_SELECT),
                SelectShippingAddress.byShippingAddress(1)
        );
    }

    @And("he pays using {word}")
    public void actor_pays_using_selected_payment(String paymentType) {
        theActorInTheSpotlight().attemptsTo(
                PayAfterLogin.by(paymentType),
                PlaceAfterLogin.order()
        );
    }

    @And("he uses sandbox")
    public void heUsesSandbox() {
        theActorInTheSpotlight().attemptsTo(
                CardPayment.order()
        );
    }

    @Then("(s)he should place order")
    public void actor_should_place_order() {
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
