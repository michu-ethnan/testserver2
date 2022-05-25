package com.deosite.tests.features.using_minicart;

import com.deosite.tests.actions.Open;
import com.deosite.tests.actions.Search;
import com.deosite.tests.questions.alert.Alert;
import com.deosite.tests.steps.SetupSteps;
import com.deosite.tests.tasks.Setup;
import com.deosite.tests.tasks.basic.MoveMouseToTop;
import com.deosite.tests.tasks.product.AddProduct;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Steps;

import static com.deosite.tests.abilities.Load.as;
import static com.deosite.tests.pages.MainMenu.SEARCH_BAR;
import static com.deosite.tests.pages.SearchPage.PRODUCTS_TITLE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class AddItemsToCart {

    @Steps
    SetupSteps setupSteps;

    @Given("that {word} has opened product page of a(n) {word}")
    public void that_actor_has_opened_product_page(String actor, String product) {
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                WaitUntil.the(SEARCH_BAR, isPresent()).forNoMoreThan(100).seconds(),
                Search.forProductByTranslatedKeyword(product),
                MoveMouseToTop.move(),
                WaitUntil.the(PRODUCTS_TITLE, isPresent()).forNoMoreThan(50).seconds(),
                Open.productPageByPositionRandomly()
        );
    }

    @When("(s)he tries to add it to cart")
    public void actor_tries_to_add_product_to_cart() {
        theActorInTheSpotlight().attemptsTo(
                AddProduct.toCart()
        );
    }

    @Then("(s)he should see popup with {string} message")
    public void actor_should_see_popup_with_message(String message) {
        theActorInTheSpotlight().should(seeThat(Alert.value(), equalTo(
                as(theActorInTheSpotlight()).translate(message)
        )));
    }
}
