package com.deosite.tests.features.checkout;

import com.deosite.tests.actions.Open;
import com.deosite.tests.pages.*;
import com.deosite.tests.steps.SetupSteps;
import com.deosite.tests.tasks.Setup;
import com.deosite.tests.tasks.basic.*;
import com.deosite.tests.tasks.mainMenu.ClickCategory;
import com.deosite.tests.tasks.order.ChooseDelivery;
import com.deosite.tests.tasks.order.FillInBillingData;
import com.deosite.tests.tasks.product.*;
import com.deosite.tests.tasks.order.Pay;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Steps;

import static com.deosite.tests.pages.CheckoutPage.EMAIL_INPUT;
import static com.deosite.tests.pages.PaymentPage.TRANSFER_PAYMENT_CHECKBOX;
import static com.deosite.tests.pages.PaymentPage.PICKUP_PAYMENT_CHECKBOX;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class RefreshPaymentPage {

    @Steps
    SetupSteps setupSteps;

    @Given("that {word} selects {word} delivery as {word}")
    public void that_actor_selects_pickup_point_delivery_type(String actor, String deliveryType, String userType) {
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                ClickCategory.byCategoryNumber(2),
                Open.productPageByPositionRandomly(),
                AddProduct.toCart(),
                MoveMouseDown.move(),
                Scroll.to(MiniCart.MINICART_BUTTON),
                Open.miniCart(),
                Open.checkoutPage(),
                WaitUntil.the(EMAIL_INPUT, isPresent()).forNoMoreThan(50).seconds(),
                ChooseDelivery.byType(deliveryType),
                FillInBillingData.type(userType)
        );
    }

    @And("she proceeds to the payment page to pay using {word}")
    public void actor_proceeds_to_the_payment_page(String paymentType) {
        theActorInTheSpotlight().attemptsTo(
                Pay.by(paymentType)
        );
    }

    @When("she refreshes the page")
    public void actor_refreshes_the_page() {
        theActorInTheSpotlight().attemptsTo(
                RefreshPage.refresh(),
                WaitUntil.the(TRANSFER_PAYMENT_CHECKBOX, isPresent()).forNoMoreThan(100).seconds(),
                WaitUntil.the(TRANSFER_PAYMENT_CHECKBOX, isVisible())
        );
    }

    @Then("she should not see the cash on delivery option")
    public void actor_should_not_see_the_cash_on_delivery_option() {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(PICKUP_PAYMENT_CHECKBOX).isNotDisplayed()
        );
    }
}
