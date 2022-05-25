package com.deosite.tests.features.using_minicart;

import com.deosite.tests.actions.Open;
import com.deosite.tests.pages.*;
import com.deosite.tests.questions.checkout.GetCartValue;
import com.deosite.tests.questions.checkout.GetShippingPrice;
import com.deosite.tests.questions.checkout.GetTotalSum;
import com.deosite.tests.questions.minicart.GetProductPrice;
import com.deosite.tests.questions.minicart.TotalSumInMinicart;
import com.deosite.tests.questions.payment.GetCartValueOnPaymentPage;
import com.deosite.tests.questions.payment.GetTotalSumOnPaymentPage;
import com.deosite.tests.questions.payment.GetShippingPriceOnPaymentPage;
import com.deosite.tests.steps.SetupSteps;
import com.deosite.tests.tasks.Setup;
import com.deosite.tests.tasks.basic.ReturnToPreviousPage;
import com.deosite.tests.tasks.mainMenu.ClickCategory;
import com.deosite.tests.tasks.order.FillInBillingData;
import com.deosite.tests.tasks.product.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Steps;

import java.math.BigDecimal;

import static com.deosite.tests.pages.Alert.ALERT_BOX;
import static com.deosite.tests.pages.CheckoutPage.EMAIL_INPUT;
import static com.deosite.tests.pages.CheckoutPage.SUBMIT_BUTTON;
import static com.deosite.tests.pages.CheckoutPage.DELETE_PRODUCT_BUTTON_AT_CHECKOUT;
import static com.deosite.tests.pages.MiniCart.*;
import static com.deosite.tests.pages.PaymentPage.DELETE_PRODUCT_BUTTON_ON_PAYMENT_PAGE;
import static com.deosite.tests.pages.PaymentPage.PLACE_ORDER_BUTTON;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class DeleteFromCartAndCheckTotalSum {

    @Steps
    SetupSteps setupSteps;

    @Given("that {word} has three products in cart")
    public void that_actor_has_three_products_in_cart(String actor) {
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                ClickCategory.byCategoryNumber(5),
                Open.productPageByPosition(7),
                AddProduct.toCart(),
                WaitUntil.the(MainMenu.SEARCH_BAR, isPresent()),
                MoveMouseDown.move(),
                /*WaitUntil.the(ALERT_BOX, isNotVisible()),*/
                ReturnToPreviousPage.goToPreviousPage(),
                Open.productPageByPosition(10),
                AddProduct.toCart(),
                WaitUntil.the(MainMenu.SEARCH_BAR, isPresent()),
                MoveMouseDown.move(),
              /*  WaitUntil.the(ALERT_BOX, isNotVisible()),*/
                ReturnToPreviousPage.goToPreviousPage(),
                Open.productPageByPosition(9),
                AddProduct.toCart(),
                WaitUntil.the(ALERT_BOX, isNotVisible()),
                MoveMouseDown.move(),
                Scroll.to(MINICART_BUTTON),
                Open.miniCart()
                //WaitUntil.the(DELETE_PRODUCT_BUTTON, isPresent())
        );
    }

    @And("she has three products at checkout")
    public void that_actor_has_three_products_at_checkout() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(GO_TO_CHECKOUT_BUTTON, isPresent()),
                Open.checkoutPage(),
                WaitUntil.the(EMAIL_INPUT, isPresent()).forNoMoreThan(50).seconds()
        );
    }

    @And("she has three products on payment page as {word}")
    public void actor_has_three_products_on_payment_page(String userType) {
        theActorInTheSpotlight().attemptsTo(
                FillInBillingData.type(userType),
                Click.on(SUBMIT_BUTTON)
        );
    }

    @When("she deletes one of the products in minicart")
    public void actor_deletes_one_of_the_products() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(DELETE_PRODUCT_BUTTON),
                WaitUntil.the(MINICART_LOADER, isNotVisible())
        );
    }

    @When("she deletes one of the products at checkout")
    public void actor_deletes_one_of_the_products_at_checkout() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(DELETE_PRODUCT_BUTTON_AT_CHECKOUT),
                WaitUntil.the(DELETE_PRODUCT_BUTTON_AT_CHECKOUT, isNotPresent()).forNoMoreThan(50).seconds(),
                WaitUntil.the(SUBMIT_BUTTON, isClickable()).forNoMoreThan(50).seconds()
        );
    }

    @When("she deletes one of the products on the payment page")
    public void actor_deletes_one_of_the_products_on_the_payment_page() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(PLACE_ORDER_BUTTON, isPresent()),
                Click.on(PaymentPage.DELETE_PRODUCT_BUTTON_ON_PAYMENT_PAGE),
                WaitUntil.the(DELETE_PRODUCT_BUTTON_ON_PAYMENT_PAGE, isNotPresent()).forNoMoreThan(50).seconds()
        );
    }

    @Then("she should see correct total sum")
    public void actor_should_see_correct_total_sum() {
        BigDecimal firstProductPrice = GetProductPrice.productPrice(0).answeredBy(theActorInTheSpotlight());
        BigDecimal secondProductPrice = GetProductPrice.productPrice(1).answeredBy(theActorInTheSpotlight());
        BigDecimal totalSum = TotalSumInMinicart.sum().answeredBy(theActorInTheSpotlight());

        theActorInTheSpotlight().attemptsTo(
                Ensure.that(totalSum).isEqualTo(firstProductPrice.add(secondProductPrice))
        );
    }

    @Then("she should see correct total sum at checkout")
    public void actor_should_see_correct_total_sum_at_checkout() {
        BigDecimal cartValue = GetCartValue.cartValue().answeredBy(theActorInTheSpotlight());
        BigDecimal shippingPrice = GetShippingPrice.shipping().answeredBy(theActorInTheSpotlight());
        BigDecimal totalSumAtCheckout = GetTotalSum.totalSum().answeredBy(theActorInTheSpotlight());

        theActorInTheSpotlight().attemptsTo(
                Ensure.that(totalSumAtCheckout).isEqualTo(cartValue.add(shippingPrice))
        );
    }

    @Then("she should see correct total sum on payment page")
    public void actor_should_see_correct_total_sum_on_payment_page() {
        BigDecimal cartValueOnPaymentPage = GetCartValueOnPaymentPage.cartValueOnPaymentPage().answeredBy(theActorInTheSpotlight());
        BigDecimal shippingPriceOnPaymentPage = GetShippingPriceOnPaymentPage.shippingPrice().answeredBy(theActorInTheSpotlight());
        BigDecimal totalSumOnPaymentPage = GetTotalSumOnPaymentPage.totalSum().answeredBy(theActorInTheSpotlight());

        theActorInTheSpotlight().attemptsTo(
                Ensure.that(totalSumOnPaymentPage).isEqualTo(cartValueOnPaymentPage.add(shippingPriceOnPaymentPage))
        );
    }
}
