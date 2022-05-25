package com.deosite.tests.features.navigating_website;

import com.deosite.tests.actions.Search;
import com.deosite.tests.actions.Open;
import com.deosite.tests.pages.HomePage;
import com.deosite.tests.questions.category.CurrentUrl;
import com.deosite.tests.steps.SetupSteps;
import com.deosite.tests.tasks.Setup;
import com.deosite.tests.tasks.basic.MoveMouseToTop;
import com.deosite.tests.tasks.brandPage.ClickBrand;
import com.deosite.tests.tasks.categoryPage.ClickCollectionBanner;
import com.deosite.tests.tasks.categoryPage.SelectPageNumber;
import com.deosite.tests.tasks.mainMenu.ClickCategory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Steps;

import static com.deosite.tests.pages.CategoryPage.CATEGORY_HEADER;
import static com.deosite.tests.pages.CategoryPage.PAGINATION_SELECT;
import static com.deosite.tests.pages.MainMenu.FIRST_MAIN_CATEGORY;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.hasValue;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static org.hamcrest.CoreMatchers.containsString;

public class SelectPage {

    @Steps
    SetupSteps setupSteps;

    @Given("that {word} is on a category page")
    public void that_actor_is_on_a_category_page(String actor) {
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                WaitUntil.the(FIRST_MAIN_CATEGORY, isPresent()),
                Open.categoryPage(),
                MoveMouseToTop.move()
        );
    }

    @Given("that {word} visits collection page")
    public void that_actor_visits_collection_page(String actor) {
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                ClickCategory.byCategoryNumber(9),
                MoveMouseToTop.move(),
                ClickBrand.byBrand(0),
                ClickCollectionBanner.collectionNumber(1)
        );
    }

    @Given("that {word} looks for a {word}")
    public void actor_looks_for_a_product(String actor, String keyword) {
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                Search.forProductByTranslatedKeyword(keyword)
        );
    }

    @And("she is on the search results page")
    public void actor_is_on_the_search_results_page() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(CATEGORY_HEADER, isPresent())
        );
    }

    @When("she selects a page")
    public void actor_selects_a_page() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(PAGINATION_SELECT, isPresent()).forNoMoreThan(100).seconds(),
                Click.on(PAGINATION_SELECT),
                SelectPageNumber.byNumber(1),
                WaitUntil.the(PAGINATION_SELECT, isClickable()).forNoMoreThan(50).seconds()
        );

    }

    @Then("she should be on that page")
    public void actor_should_be_on_that_page() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(HomePage.DAJAR_LOGO, isPresent()).forNoMoreThan(50).seconds()
        );
        theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), containsString("p=2")));
    }
}
