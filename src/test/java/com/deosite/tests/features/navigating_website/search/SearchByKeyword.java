package com.deosite.tests.features.navigating_website.search;

import com.deosite.tests.actions.Search;
import com.deosite.tests.pages.SearchPage;
import com.deosite.tests.questions.product.Product;
import com.deosite.tests.steps.SetupSteps;
import com.deosite.tests.tasks.Setup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Steps;

import static com.deosite.tests.abilities.Load.as;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.containsString;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class SearchByKeyword {

    @Steps
    SetupSteps setupSteps;

    @Given("that {word} wants to search for a(n) product")
    public void that_actor_wants_to_buy_a_product(String actor) {
        theActorCalled(actor).wasAbleTo(Setup.site());
    }

    @When("(s)he searches for a(n) {word} by keyword")
    public void actor_searches_for_product_by_keyword(String keyword) {
        theActorInTheSpotlight().attemptsTo(Search.forProductByTranslatedKeyword(keyword));
        WaitUntil.the(SearchPage.PRODUCTS_TITLE, isPresent()).forNoMoreThan(100).seconds();
    }

    @Then("(s)he should see that the first product contains keyword {word}")
    public void actor_should_see_that_the_first_product_contains_keyword(String keyword) {
        theActorInTheSpotlight().should(seeThat(Product.titleOfAProductOnSearchPageByPosition(0), containsString(
                as(theActorInTheSpotlight()).translate(keyword)
        )));
    }
}
