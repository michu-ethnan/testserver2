
package com.deosite.tests.features.using_minicart;

import com.deosite.tests.actions.Open;
import com.deosite.tests.pages.*;
import com.deosite.tests.questions.product.ProductPrice;
import com.deosite.tests.steps.SetupSteps;
import com.deosite.tests.tasks.Setup;
import com.deosite.tests.tasks.mainMenu.ClickCategory;
import com.deosite.tests.tasks.minicart.IncreaseNumberOfProducts;
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
import static com.deosite.tests.pages.MiniCart.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class CalculateTotalSumInMinicart {

    @Steps
    SetupSteps setupSteps;
    BigDecimal productPrice;

    @Given("that {word} is on the product page")
    public void actor_is_in_minicart(String actor) {
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                ClickCategory.byCategoryNumber(5),
                Open.productPageByPositionRandomly()
                );
    }

    @And("she sees a product price")
    public void actor_sees_a_product_price() {
        productPrice = ProductPrice.price().answeredBy(theActorInTheSpotlight());
    }

    @When("the total sum in minicart is calculated")
    public void actor_calculates_the_total_sum_in_minicart() {
        theActorInTheSpotlight().attemptsTo(
                AddProduct.toCart(),
                WaitUntil.the(ALERT_BOX, isNotVisible()),
              /*  MoveMouseDown.move(),
                Scroll.to(MiniCart.MINICART_BUTTON),*/
                Open.miniCart(),
                Click.on(QUANTITY_PICKER),
                IncreaseNumberOfProducts.byAmountNumber(3),
                WaitUntil.the(GO_TO_CHECKOUT_BUTTON, isClickable()),
                WaitUntil.the(MINICART_LOADER, isNotPresent())
        );
    }

    @Then("she should see that it is correct")
    public void actor_should_see_that_it_is_correct() {
        BigDecimal totalSum =
                com.deosite.tests.questions.minicart.TotalSumInMinicart.sum().answeredBy(theActorInTheSpotlight());
        BigDecimal numberOfProducts = new BigDecimal(4);
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(totalSum).isEqualTo(productPrice.multiply(numberOfProducts))
        );
    }
}

