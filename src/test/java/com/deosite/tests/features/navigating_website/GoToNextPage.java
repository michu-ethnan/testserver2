package com.deosite.tests.features.navigating_website;

import com.deosite.tests.actions.Search;
import com.deosite.tests.pages.HomePage;
import com.deosite.tests.questions.category.CurrentUrl;
import com.deosite.tests.steps.SetupSteps;
import com.deosite.tests.tasks.Setup;
import com.deosite.tests.tasks.basic.MoveMouseToTop;
import com.deosite.tests.tasks.brandPage.ClickBrand;
import com.deosite.tests.tasks.categoryPage.ClickCollectionBanner;
import com.deosite.tests.tasks.mainMenu.ClickCategory;
import com.deosite.tests.actions.Open;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Steps;

import static com.deosite.tests.pages.CategoryPage.CATEGORY_HEADER;
import static com.deosite.tests.pages.MainMenu.FIRST_MAIN_CATEGORY;
import static com.deosite.tests.pages.CategoryPage.PAGINATION_ARROW;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static org.hamcrest.CoreMatchers.containsString;

public class GoToNextPage {

    @Steps
    SetupSteps setupSteps;

    @Given("that {word} opens a category page")
    public void that_actor_opens_a_category_page(String actor) {
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                WaitUntil.the(FIRST_MAIN_CATEGORY, isPresent()).forNoMoreThan(50).seconds(),
                Open.categoryPage(),
                MoveMouseToTop.move()
        );
    }

    @Given("that {word} is on a collection page")
    public void that_actor_is_on_a_collection_page(String actor) {
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                WaitUntil.the(FIRST_MAIN_CATEGORY, isPresent()).forNoMoreThan(50).seconds(),
                ClickCategory.byCategoryNumber(9),
                MoveMouseToTop.move(),
                ClickBrand.byBrand(0),
                ClickCollectionBanner.collectionNumber(1)
        );
    }

    @Given("that {word} searches for a {word}")
    public void that_actor_searches_for_a_mug_and_sees_the_search_results_page(String actor, String keyword) {
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                Search.forProductByTranslatedKeyword(keyword)
                );
    }

    @And("he sees the search results page")
    public void actor_sees_the_search_results_page() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(CATEGORY_HEADER, isPresent()).forNoMoreThan(50).seconds()
        );
    }

    @When("he clicks a pagination arrow")
    public void actor_clicks_a_pagination_arrow() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(PAGINATION_ARROW, isPresent()).forNoMoreThan(50).seconds(),
                Click.on(PAGINATION_ARROW),
                WaitUntil.the(PAGINATION_ARROW, isClickable())
        );
    }

    @Then("he should go to that page")
    public void actor_should_go_to_that_page() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(HomePage.DAJAR_LOGO, isPresent()).forNoMoreThan(50).seconds()
        );
        theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), containsString("p=2")));
    }
}
