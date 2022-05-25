package com.deosite.tests.features.coupon_codes_and_epoints;

import com.deosite.tests.actions.Open;
import com.deosite.tests.pages.CheckoutPage;
import com.deosite.tests.pages.MainMenu;
import com.deosite.tests.pages.MiniCart;
import com.deosite.tests.questions.checkout.DiscountPrice;
import com.deosite.tests.steps.SetupSteps;
import com.deosite.tests.tasks.Setup;
import com.deosite.tests.tasks.mainMenu.ClickCategory;
import com.deosite.tests.tasks.minicart.IncreaseNumberOfProducts;
import com.deosite.tests.tasks.order.FillInBillingData;
import com.deosite.tests.tasks.product.AddProduct;
import com.deosite.tests.tasks.product.MoveMouseDown;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Steps;

import java.math.BigDecimal;


import static com.deosite.tests.pages.CheckoutPage.*;
import static com.deosite.tests.pages.MiniCart.GO_TO_CHECKOUT_BUTTON;
import static com.deosite.tests.pages.MiniCart.QUANTITY_PICKER;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ChangeAmountOfProductAfterApplyingCouponCodeAndCheckPrice {
    @Steps
    SetupSteps setupSteps;

    BigDecimal discountPriceBeforeChangingProductAmount;
    BigDecimal discountPriceAfterChangingProductAmount;

    @Given("that {word} applied a coupon code on checkout page")
    public void hanna_applies_coupon_code_on_checkout_page(String actor){
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                ClickCategory.byCategoryNumber(6),
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
                Click.on(APPLY_COUPON_CODE_BUTTON),
                WaitUntil.the(DELETE_COUPON_CODE_BUTTON, isPresent()).forNoMoreThan(50).seconds()

        );
    }
    @Given("that {word} applied a coupon code on checkout page after adding two products")
    public void hanna_applies_coupon_code_on_checkout_page_after_adding_two_products(String actor){
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                ClickCategory.byCategoryNumber(6),
                Open.productPageByPositionRandomly(),
                AddProduct.toCart(),
                WaitUntil.the(MainMenu.SEARCH_BAR, isPresent()),
                MoveMouseDown.move(),
                Scroll.to(MiniCart.MINICART_BUTTON),
                Open.miniCart(),
                WaitUntil.the(GO_TO_CHECKOUT_BUTTON, isClickable()),
                Click.on(QUANTITY_PICKER),
                IncreaseNumberOfProducts.byAmountNumber(1),
                WaitUntil.the(MiniCart.DELETE_PRODUCT_BUTTON, isClickable()),
                Click.on(GO_TO_CHECKOUT_BUTTON),
                WaitUntil.the(COUPON_CODE_BUTTON, isPresent()),
                Click.on(COUPON_CODE_BUTTON),
                WaitUntil.the(COUPON_CODE_INPUT, isPresent()),
                SendKeys.of("ABC123").into(COUPON_CODE_INPUT),
                Click.on(APPLY_COUPON_CODE_BUTTON),
                WaitUntil.the(DELETE_COUPON_CODE_BUTTON, isPresent()).forNoMoreThan(50).seconds()

        );
    }

    @Given("that {word} applied a coupon code on payment page as a {word}")
    public void hanna_applies_coupon_code_on_payment_page(String actor, String userType){
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                ClickCategory.byCategoryNumber(6),
                Open.productPageByPositionRandomly(),
                AddProduct.toCart(),
                WaitUntil.the(MainMenu.SEARCH_BAR, isPresent()),
                MoveMouseDown.move(),
                Scroll.to(MiniCart.MINICART_BUTTON),
                Open.miniCart(),
                Open.checkoutPage(),
                WaitUntil.the(EMAIL_INPUT, isPresent()).forNoMoreThan(50).seconds(),
                FillInBillingData.type(userType),
                Click.on(SUBMIT_BUTTON),
                WaitUntil.the(CheckoutPage.DELIVERY_TYPE_COURIER, isNotPresent()),
                Click.on(COUPON_CODE_BUTTON),
                WaitUntil.the(COUPON_CODE_INPUT, isPresent()),
                SendKeys.of("ABC123").into(COUPON_CODE_INPUT),
                Click.on(APPLY_COUPON_CODE_BUTTON),
                WaitUntil.the(DELETE_COUPON_CODE_BUTTON, isPresent()).forNoMoreThan(50).seconds()

        );
    }


    @Given("that {word} applied a coupon code on payment page as a {word} after adding two products")
    public void hanna_applies_coupon_code_on_payment_page_after_adding_two_products(String actor, String userType){
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                ClickCategory.byCategoryNumber(6),
                Open.productPageByPositionRandomly(),
                AddProduct.toCart(),
                WaitUntil.the(MainMenu.SEARCH_BAR, isPresent()),
                MoveMouseDown.move(),
                Scroll.to(MiniCart.MINICART_BUTTON),
                Open.miniCart(),
                WaitUntil.the(GO_TO_CHECKOUT_BUTTON, isClickable()),
                Click.on(QUANTITY_PICKER),
                IncreaseNumberOfProducts.byAmountNumber(1),
                WaitUntil.the(MiniCart.DELETE_PRODUCT_BUTTON, isClickable()),
                Click.on(GO_TO_CHECKOUT_BUTTON),
                WaitUntil.the(EMAIL_INPUT, isPresent()).forNoMoreThan(50).seconds(),
                FillInBillingData.type(userType),
                Click.on(SUBMIT_BUTTON),
                WaitUntil.the(CheckoutPage.DELIVERY_TYPE_COURIER, isNotPresent()),
                WaitUntil.the(COUPON_CODE_BUTTON, isPresent()),
                Click.on(COUPON_CODE_BUTTON),
                WaitUntil.the(COUPON_CODE_INPUT, isPresent()),
                SendKeys.of("ABC123").into(COUPON_CODE_INPUT),
                Click.on(APPLY_COUPON_CODE_BUTTON),
                WaitUntil.the(DELETE_COUPON_CODE_BUTTON, isPresent()).forNoMoreThan(50).seconds()

        );
    }

    @And("she sees the discount price")
    public void hanna_sees_the_discount_price(){
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(DISCOUNT_PRICE_HEADER, isPresent()),
                WaitUntil.the(DISCOUNT_PRICE, isPresent()).forNoMoreThan(50).seconds()
        );
        discountPriceBeforeChangingProductAmount = DiscountPrice.discount().answeredBy(theActorInTheSpotlight());
    }
    @When("she increases the amount of product")
    public void actor_increases_the_amount_of_product(){
        theActorInTheSpotlight().attemptsTo(
                MoveMouse.to(QUANTITY_PICKER_CHECKOUT),
                Click.on(QUANTITY_PICKER_CHECKOUT),
                IncreaseNumberOfProducts.byAmountNumber(1),
                WaitUntil.the(DELETE_PRODUCT_BUTTON_AFTER_COUPON_CODE, isPresent()).forNoMoreThan(50).seconds(),
                WaitUntil.the(DISCOUNT_PRICE_HEADER, isPresent()),
                WaitUntil.the(DISCOUNT_PRICE, isPresent()).forNoMoreThan(50).seconds()
        );
        discountPriceAfterChangingProductAmount = DiscountPrice.discount().answeredBy(theActorInTheSpotlight());

    }
    @When("she decreases the amount of product")
    public void actor_decreases_the_amount_of_product(){
        theActorInTheSpotlight().attemptsTo(
                MoveMouse.to(QUANTITY_PICKER_CHECKOUT),
                Click.on(QUANTITY_PICKER_CHECKOUT),
                IncreaseNumberOfProducts.byAmountNumber(0),
                WaitUntil.the(DELETE_PRODUCT_BUTTON_AFTER_COUPON_CODE, isPresent()).forNoMoreThan(50).seconds(),
                WaitUntil.the(DISCOUNT_PRICE_HEADER, isPresent()),
                WaitUntil.the(DISCOUNT_PRICE, isPresent()).forNoMoreThan(50).seconds()
        );
        discountPriceAfterChangingProductAmount = DiscountPrice.discount().answeredBy(theActorInTheSpotlight());

    }
    @Then("she should see that the discount is higher")
    public void hanna_should_see_that_the_discount_is_higher(){
        theActorInTheSpotlight().attemptsTo();
        Ensure.that(discountPriceBeforeChangingProductAmount).isGreaterThan(discountPriceAfterChangingProductAmount);
    }
    @Then("she should see that the discount is smaller")
    public void hanna_should_see_that_the_discount_is_smaller(){
        theActorInTheSpotlight().attemptsTo();
        Ensure.that(discountPriceAfterChangingProductAmount).isLessThan(discountPriceBeforeChangingProductAmount);
    }
}
