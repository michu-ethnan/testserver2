package com.deosite.tests.features.using_minicart;

import com.deosite.tests.actions.Search;
import com.deosite.tests.actions.Open;
import com.deosite.tests.pages.*;
import com.deosite.tests.questions.minicart.MinicartHeader;
import com.deosite.tests.steps.SetupSteps;
import com.deosite.tests.tasks.Setup;
import com.deosite.tests.tasks.basic.MoveMouseToTop;
import com.deosite.tests.tasks.minicart.IncreaseNumberOfProducts;
import com.deosite.tests.tasks.product.*;
import com.deosite.tests.tasks.minicart.DecreaseNumberOfProducts;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Steps;

import static com.deosite.tests.abilities.Load.as;
import static com.deosite.tests.pages.Alert.ALERT_BOX;
import static com.deosite.tests.pages.LoginPage.SUBMIT_BUTTON;
import static com.deosite.tests.pages.MiniCart.*;
import static com.deosite.tests.pages.SearchPage.PRODUCTS_TITLE;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static org.hamcrest.Matchers.equalTo;

public class ChangeNumberOfProductsInMinicart {

    @Steps
    SetupSteps setupSteps;

    @Given("that {word} has a {word} in the cart")
    public void that_actor_has_a_product_in_the_cart(String actor, String product) {
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                Search.forProductByTranslatedKeyword(product),
                MoveMouseToTop.move(),
                WaitUntil.the(PRODUCTS_TITLE, isPresent()).forNoMoreThan(50).seconds(),
                Open.productPageByPositionRandomly(),
                AddProduct.toCart(),
                WaitUntil.the(ALERT_BOX, isNotPresent()),
                Open.miniCart()
        );
    }

    @When("she tries to increase the number of products")
    public void actor_tries_to_increase_the_number_of_products() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(GO_TO_CHECKOUT_BUTTON, isClickable()),
                Click.on(QUANTITY_PICKER),
                IncreaseNumberOfProducts.byAmountNumber(1),
                WaitUntil.the(SUBMIT_BUTTON, isNotPresent()),
                WaitUntil.the(GO_TO_CHECKOUT_BUTTON, isEnabled()),
                WaitUntil.the(GO_TO_CHECKOUT_BUTTON, isClickable())
        );
    }

    @And("then she tries to decrease the number of products")
    public void then_actor_tries_to_decrease_the_number_of_products() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(GO_TO_CHECKOUT_BUTTON, isClickable()),
                Click.on(QUANTITY_PICKER),
                DecreaseNumberOfProducts.byAmountNumber(0),
                WaitUntil.the(SUBMIT_BUTTON, isNotPresent()),
                WaitUntil.the(GO_TO_CHECKOUT_BUTTON, isEnabled()).forNoMoreThan(100).seconds(),
                WaitUntil.the(GO_TO_CHECKOUT_BUTTON, isClickable()).forNoMoreThan(100).seconds()
        );
    }

    @Then("she should see that the number is {word}")
    public void actor_should_see_that_the_number_is_greater_or_smaller(String numberOfProducts) {
        theActorInTheSpotlight().should(seeThat(MinicartHeader.numberOfProducts(), equalTo(
                as(theActorInTheSpotlight()).translate(numberOfProducts)
        )));
    }
}
