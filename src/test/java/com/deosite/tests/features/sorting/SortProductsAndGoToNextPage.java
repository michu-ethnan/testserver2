package com.deosite.tests.features.sorting;

import com.deosite.tests.actions.Search;
import com.deosite.tests.pages.CategoryPage;
import com.deosite.tests.questions.category.CurrentUrl;
import com.deosite.tests.steps.SetupSteps;
import com.deosite.tests.tasks.Setup;
import com.deosite.tests.tasks.basic.MoveMouseToTop;
import com.deosite.tests.tasks.categoryPage.SelectSortingOption;
import com.deosite.tests.tasks.mainMenu.ClickCategory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Steps;

import static com.deosite.tests.pages.CategoryPage.CATEGORY_HEADER;
import static com.deosite.tests.pages.CategoryPage.PAGINATION_ARROW;
import static com.deosite.tests.pages.LoginPage.SUBMIT_BUTTON;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static org.hamcrest.CoreMatchers.containsString;

public class SortProductsAndGoToNextPage {

    @Steps
    SetupSteps setupSteps;

    @Given("that {word} begins shopping on a category page")
    public void that_actor_found_herself_on_a_category_page(String actor) {
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                ClickCategory.byCategoryNumber(0),
                MoveMouseToTop.move(),
                WaitUntil.the(CategoryPage.CATEGORY_HEADER, isPresent())
        );
    }

    @Given("that {word} tries to find a {word}")
    public void actor_tries_to_find_a_product(String actor, String keyword) {
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                Search.forProductByTranslatedKeyword(keyword)
        );
    }

    @And("she finds herself on the search results page")
    public void she_finds_herself_on_the_search_results_page() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(CATEGORY_HEADER, isPresent())
        );
    }

    @When("she sorts products")
    public void actor_sorts_products() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(CategoryPage.SORTING_BUTTON),
                SelectSortingOption.number(2)
        );
    }

    @And("she proceeds to next page")
    public void actor_proceeds_to_next_page() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(PAGINATION_ARROW, isClickable()).forNoMoreThan(50).seconds(),
                Click.on(PAGINATION_ARROW),
                WaitUntil.the(PAGINATION_ARROW, isClickable()).forNoMoreThan(50).seconds(),
                WaitUntil.the(SUBMIT_BUTTON, isNotPresent())
        );
    }

    @Then("she should end up on the next page")
    public void actor_should_end_up_on_the_next_page() {
        theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), containsString("p=2")));
    }
}
