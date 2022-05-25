package com.deosite.tests.features.using_minicart;

import com.deosite.tests.actions.Open;
import com.deosite.tests.pages.*;
import com.deosite.tests.questions.minicart.GetProductPrice;
import com.deosite.tests.steps.SetupSteps;
import com.deosite.tests.tasks.Setup;
import com.deosite.tests.tasks.basic.ReturnToPreviousPage;
import com.deosite.tests.tasks.mainMenu.ClickCategory;
import com.deosite.tests.tasks.product.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Steps;

import java.math.BigDecimal;

import static com.deosite.tests.pages.Alert.ALERT_BOX;
import static com.deosite.tests.pages.MiniCart.GO_TO_CHECKOUT_BUTTON;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class AddTwoDifferentProductsAndCalculateTotalSum {

    @Steps
    SetupSteps setupSteps;

    BigDecimal firstProductPrice;
    BigDecimal secondProductPrice;

    @Given("that {word} has two products in cart")
    public void that_actor_has_two_products_in_cart(String actor) {
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                ClickCategory.byCategoryNumber(5),
                Open.productPageByPositionRandomly(),
                AddProduct.toCart(),
                ReturnToPreviousPage.goToPreviousPage(),
                Open.productPageByPositionRandomly(),
                AddProduct.toCart(),
                WaitUntil.the(ALERT_BOX, isNotPresent()),
                /* MoveMouseDown.move(),
               Scroll.to(MiniCart.MINICART_BUTTON),
                WaitUntil.the(ALERT_BOX, isNotVisible()).forNoMoreThan(100).seconds(),*/
                Open.miniCart(),
                WaitUntil.the(MiniCart.PRODUCT_PRICE_LIST, isPresent()).forNoMoreThan(100).seconds(),
                WaitUntil.the(GO_TO_CHECKOUT_BUTTON, isClickable())
        );
    }

    @When("she checks their price")
    public void actor_checks_their_price() {
        firstProductPrice = GetProductPrice.productPrice(0).answeredBy(theActorInTheSpotlight());
        secondProductPrice = GetProductPrice.productPrice(1).answeredBy(theActorInTheSpotlight());
    }

    @Then("she should see that the total sum is correct")
    public void actor_should_see_that_the_total_sum_is_correct() {
        BigDecimal totalSum =
                com.deosite.tests.questions.minicart.TotalSumInMinicart.sum().answeredBy(theActorInTheSpotlight());

        theActorInTheSpotlight().attemptsTo(
                Ensure.that(totalSum).isEqualTo(firstProductPrice.add(secondProductPrice))
        );
    }
}
