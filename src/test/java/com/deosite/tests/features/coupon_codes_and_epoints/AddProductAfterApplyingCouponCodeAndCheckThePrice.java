package com.deosite.tests.features.coupon_codes_and_epoints;

import com.deosite.tests.actions.Open;
import com.deosite.tests.pages.CheckoutPage;
import com.deosite.tests.pages.HomePage;
import com.deosite.tests.pages.MainMenu;
import com.deosite.tests.pages.MiniCart;
import com.deosite.tests.questions.checkout.DiscountPrice;
import com.deosite.tests.steps.SetupSteps;
import com.deosite.tests.tasks.Setup;
import com.deosite.tests.tasks.basic.ReturnToPreviousPage;
import com.deosite.tests.tasks.mainMenu.ClickCategory;
import com.deosite.tests.tasks.order.FillInBillingData;
import com.deosite.tests.tasks.product.AddProduct;
import com.deosite.tests.tasks.product.MoveMouseDown;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Steps;

import java.math.BigDecimal;

import static com.deosite.tests.pages.CheckoutPage.*;
import static com.deosite.tests.pages.HomePage.DAJAR_LOGO;
import static com.deosite.tests.pages.MainMenu.SEARCH_BAR;
import static com.deosite.tests.pages.PaymentPage.COUPON_CODE_BUTTON;
import static com.deosite.tests.pages.PaymentPage.COUPON_CODE_INPUT;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class AddProductAfterApplyingCouponCodeAndCheckThePrice {
    @Steps
    SetupSteps setupSteps;

    BigDecimal firstDiscountPrice;
    BigDecimal secondDiscountPrice;

    @Given("that {word} is on the checkout page")
    public void actor_is_on_the_checkout_page(String actor){
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                ClickCategory.byCategoryNumber(5),
                Open.productPageByPosition(7),
                AddProduct.toCart(),
                WaitUntil.the(SEARCH_BAR, isPresent()),
                MoveMouseDown.move(),
                Scroll.to(MiniCart.MINICART_BUTTON),
                Open.miniCart(),
                Open.checkoutPage(),
                WaitUntil.the(EMAIL_INPUT, isPresent()).forNoMoreThan(50).seconds()

        );

    }
    @Given("that {word} is on the payment page as a {word}")
    public void actor_is_on_the_payment_page(String actor, String userType){
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                ClickCategory.byCategoryNumber(5),
                Open.productPageByPositionRandomly(),
                AddProduct.toCart(),
                WaitUntil.the(SEARCH_BAR, isPresent()),
                MoveMouseDown.move(),
                Scroll.to(MiniCart.MINICART_BUTTON),
                Open.miniCart(),
                Open.checkoutPage(),
                WaitUntil.the(EMAIL_INPUT, isPresent()).forNoMoreThan(50).seconds(),
                FillInBillingData.type(userType),
                Click.on(SUBMIT_BUTTON),
                WaitUntil.the(CheckoutPage.DELIVERY_TYPE_COURIER, isNotPresent())


        );

    }

    @When("he applies a coupon code on checkout page")
    public void actor_applies_coupon_code_on_payment_page(){
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(CheckoutPage.COUPON_CODE_BUTTON, isPresent()),
                Click.on(COUPON_CODE_BUTTON),
                SendKeys.of("ABC123").into(COUPON_CODE_INPUT),
                Click.on(APPLY_COUPON_CODE_BUTTON),
                WaitUntil.the(DELETE_COUPON_CODE_BUTTON, isPresent()).forNoMoreThan(50).seconds()

        );
    }
    @When("he applies a coupon code on payment page")
    public void actor_applies_coupon_code_on_checkout_page(){
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(COUPON_CODE_BUTTON, isPresent()),
                Click.on(COUPON_CODE_BUTTON),
                SendKeys.of("ABC123").into(COUPON_CODE_INPUT),
                Click.on(APPLY_COUPON_CODE_BUTTON)
        );
    }
    @And("he sees the discount price on checkout page")
    public void actor_sees_the_discounted_price(){
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(DISCOUNT_PRICE_HEADER, isPresent()),
                WaitUntil.the(DISCOUNT_PRICE, isPresent()).forNoMoreThan(50).seconds()
        );
        firstDiscountPrice = DiscountPrice.discount().answeredBy(theActorInTheSpotlight());

    }
    @And("he sees the discount price on payment page")
    public void actor_sees_the_discount_price_on_payment_page(){
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(DISCOUNT_PRICE_HEADER, isPresent()),
                WaitUntil.the(DISCOUNT_PRICE, isPresent()).forNoMoreThan(50).seconds()
        );
        firstDiscountPrice = DiscountPrice.discount().answeredBy(theActorInTheSpotlight());

    }
    @And("he returns to the previous page and adds another product to cart")
    public void actor_returns_to_homepage_and_adds_another_product(){
        theActorInTheSpotlight().attemptsTo(
                ReturnToPreviousPage.goToPreviousPage(),
                ReturnToPreviousPage.goToPreviousPage(),
                Scroll.to(SEARCH_BAR),
                ClickCategory.byCategoryNumber(5),
                Open.productPageByPositionRandomly(),
                AddProduct.toCart(),
                WaitUntil.the(SEARCH_BAR, isPresent()),
                MoveMouseDown.move(),
                Scroll.to(MiniCart.MINICART_BUTTON)


        );
    }
    @When("he goes to checkout page")
    public void actor_goes_to_checkout_page(){
        theActorInTheSpotlight().attemptsTo(
                Open.miniCart(),
                Open.checkoutPage(),
                WaitUntil.the(EMAIL_INPUT, isPresent()).forNoMoreThan(50).seconds()
        );
        secondDiscountPrice = DiscountPrice.discount().answeredBy(theActorInTheSpotlight());
    }
    @When("he goes to the payment page")
    public void actor_goes_to_the_payment_page(){
        theActorInTheSpotlight().attemptsTo(
                Open.miniCart(),
                Open.checkoutPage(),
                WaitUntil.the(SUBMIT_BUTTON, isPresent()).forNoMoreThan(50).seconds(),
                Click.on(SUBMIT_BUTTON),
                WaitUntil.the(CheckoutPage.DELIVERY_TYPE_COURIER, isNotPresent())
        );
        secondDiscountPrice = DiscountPrice.discount().answeredBy(theActorInTheSpotlight());
    }

    @Then("he should see that the discount price is higher")
    public void actor_should_see_that_the_discount_price_is_higher(){
        theActorInTheSpotlight().attemptsTo();
        Ensure.that(secondDiscountPrice).isGreaterThan(firstDiscountPrice);

    }


}
