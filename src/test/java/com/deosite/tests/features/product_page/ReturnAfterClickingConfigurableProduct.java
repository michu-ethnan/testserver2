package com.deosite.tests.features.product_page;

import com.deosite.tests.actions.Search;
import com.deosite.tests.actions.Open;
import com.deosite.tests.pages.ProductPage;
import com.deosite.tests.steps.SetupSteps;
import com.deosite.tests.tasks.Setup;
import com.deosite.tests.tasks.basic.MoveMouseToTop;
import com.deosite.tests.tasks.basic.ReturnToPreviousPage;
import com.deosite.tests.tasks.mainMenu.ClickCategory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Steps;

import static com.deosite.tests.pages.CategoryPage.PAGINATION_SELECT;
import static com.deosite.tests.pages.CategoryPage.PAGINATION_ARROW;
import static com.deosite.tests.pages.CategoryPage.CATEGORY_HEADER;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class ReturnAfterClickingConfigurableProduct {

    @Steps
    SetupSteps setupSteps;

    @Given("that {word} is on the search results page looking for {string}")
    public void that_actor_is_on_the_search_results_page(String actor, String keyword) {
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                Search.forProductByTranslatedKeyword(keyword),
                WaitUntil.the(CATEGORY_HEADER, isPresent())
        );
    }

    @Given("that {word} opened some category page")
    public void that_actor_opened_some_category_page(String actor) {
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                ClickCategory.byCategoryNumber(4),
                MoveMouseToTop.move(),
                WaitUntil.the(PAGINATION_SELECT, isClickable()),
                Click.on(PAGINATION_ARROW),
                WaitUntil.the(PAGINATION_ARROW, isClickable())
        );
    }

    @When("she goes to the product page")
    public void actor_goes_to_the_product_page() {
        theActorInTheSpotlight().attemptsTo(
                Open.productPageByPosition(0)
        );
    }

    @When("she goes to the product page from category page")
    public void actor_goes_to_the_product_page_from_category_page() {
        theActorInTheSpotlight().attemptsTo(
                Open.productPageByPosition(13)
        );
    }

    @And("she clicks the back button in a browser")
    public void actor_clicks_the_back_button_in_a_browser() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(ProductPage.ADD_TO_CART_BUTTON, isPresent()),
                ReturnToPreviousPage.goToPreviousPage()
        );
    }

    @Then("she should see that she is on the previous search results page")
    public void actor_should_see_that_she_is_on_the_same_page_as_previously() {
        theActorInTheSpotlight().should(seeThat(the(CATEGORY_HEADER), containsText("kubek palette")));
    }

    @Then("she should see that she is on the previous category page")
    public void actor_should_see_that_she_is_on_the_previous_category_page() {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(CATEGORY_HEADER).isDisplayed()
        );
    }
}
