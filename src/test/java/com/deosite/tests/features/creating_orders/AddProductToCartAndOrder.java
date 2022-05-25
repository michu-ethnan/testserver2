package com.deosite.tests.features.creating_orders;

import com.deosite.tests.actions.Open;
import com.deosite.tests.pages.*;
import com.deosite.tests.questions.order.Success;
import com.deosite.tests.steps.SetupSteps;
import com.deosite.tests.tasks.Setup;
import com.deosite.tests.tasks.basic.*;
import com.deosite.tests.tasks.mainMenu.ClickCategory;
import com.deosite.tests.tasks.order.ChooseDelivery;
import com.deosite.tests.tasks.order.FillInBillingData;
import com.deosite.tests.tasks.order.FillInShippingData;
import com.deosite.tests.tasks.order.Pay;
import com.deosite.tests.tasks.order.Place;
import com.deosite.tests.tasks.order.CardPayment;
import com.deosite.tests.tasks.product.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Steps;

import static com.deosite.tests.abilities.Load.as;
import static com.deosite.tests.pages.CheckoutPage.EMAIL_INPUT;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static org.hamcrest.CoreMatchers.equalTo;

public class AddProductToCartAndOrder {

    @Steps
    SetupSteps setupSteps;

    @Given("that {word} adds product to cart on account1")
    public void that_actor_adds_product_to_cart1(String actor) {
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                ClickCategory.byCategoryNumber(5),
                Open.productPageByPositionRandomly(),
                //WaitUntil.the(CategoryPage.CATEGORY_HEADER, isNotPresent()),
                AddProduct.toCart(),
                MoveMouseDown.move(),
                Scroll.to(MiniCart.MINICART_BUTTON)
                //WaitUntil.the(MainMenu.SEARCH_BAR, isPresent())
        );
    }
    @Given("that {word} adds product to cart on account2")
    public void that_actor_adds_product_to_cart2(String actor) {
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                ClickCategory.byCategoryNumber(5),
                Open.productPageByPosition(9),
                //WaitUntil.the(CategoryPage.CATEGORY_HEADER, isNotPresent()),
                AddProduct.toCart(),
                MoveMouseDown.move(),
                Scroll.to(MiniCart.MINICART_BUTTON)
                //WaitUntil.the(MainMenu.SEARCH_BAR, isPresent())
        );
    }
    @Given("that {word} adds product to cart on account3")
    public void that_actor_adds_product_to_cart3(String actor) {
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                ClickCategory.byCategoryNumber(5),
                Open.productPageByPosition(10),
                //WaitUntil.the(CategoryPage.CATEGORY_HEADER, isNotPresent()),
                AddProduct.toCart(),
                MoveMouseDown.move(),
                Scroll.to(MiniCart.MINICART_BUTTON)
                //WaitUntil.the(MainMenu.SEARCH_BAR, isPresent())
        );
    }

    @When("he attempts to order it as {word} using {word} delivery")
    public void actor_attempts_to_order_it_as_selected_user_type_using_selected_delivery_type(String userType,
                                                                                              String deliveryType) {
        theActorInTheSpotlight().attemptsTo(
                Open.miniCart(),
                Open.checkoutPage(),
                WaitUntil.the(EMAIL_INPUT, isPresent()).forNoMoreThan(50).seconds(),
                ChooseDelivery.byType(deliveryType),
                FillInBillingData.type(userType)
        );
    }

    @And("he enters shipping address as {word}")
    public void actor_enters_shipping_address_as_selected_user_type(String userType) {
        theActorInTheSpotlight().attemptsTo(
                FillInShippingData.type(userType)
        );
    }

    @And("he attempts to pay using {word}")
    public void actor_attempts_to_pay_using_selected_payment_method(String paymentType) {
        theActorInTheSpotlight().attemptsTo(
                Pay.by(paymentType),
                Place.order()
        );
    }

    @And("he attempts to use sandbox")
    public void actor_attempts_to_use_sandbox() {
        theActorInTheSpotlight().attemptsTo(
                CardPayment.order()
        );
    }

    @Then("the order should be placed")
    public void actor_should_see_that_the_order_was_placed() {
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
