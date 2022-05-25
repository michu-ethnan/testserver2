package com.deosite.tests.features.filtering;

import com.deosite.tests.pages.CategoryPage;
import com.deosite.tests.questions.filters.FilterBox;
import com.deosite.tests.steps.SetupSteps;
import com.deosite.tests.tasks.Setup;
import com.deosite.tests.tasks.basic.MoveMouseToTop;
import com.deosite.tests.tasks.basic.RefreshPage;
import com.deosite.tests.tasks.categoryPage.*;
import com.deosite.tests.tasks.filtering.SelectFilter;
import com.deosite.tests.tasks.mainMenu.ClickCategory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Steps;

import static com.deosite.tests.pages.CategoryPage.APPLIED_FILTER_BOX;
import static com.deosite.tests.pages.CategoryPage.PAGINATION_ARROW;
import static com.deosite.tests.pages.LoginPage.SUBMIT_BUTTON;
import static com.deosite.tests.pages.MainMenu.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static org.hamcrest.CoreMatchers.containsString;

public class ApplyRangeFilterRefreshAndGoToNextPage {

    @Steps
    SetupSteps setupSteps;

    @Given("that {word} is on a given category page")
    public void that_actor_is_on_a_given_category_page(String actor) {
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                ClickCategory.byCategoryNumber(0),
                MoveMouseToTop.move(),
                WaitUntil.the(CategoryPage.CATEGORY_HEADER, isPresent())
        );
    }

    @When("she selects a range filter")
    public void actor_selects_a_range_filter() {
        theActorInTheSpotlight().attemptsTo(
                ClickFilterButton.number(3),
                WaitUntil.the(CategoryPage.PRICE_FILTER_INPUT, isPresent()),
                Clear.field(CategoryPage.PRICE_FILTER_INPUT),
                SendKeys.of("10,50").into(CategoryPage.PRICE_FILTER_INPUT),
                Click.on(CategoryPage.FILTER_BUTTON),
                Scroll.to(SEARCH_BAR),
                WaitUntil.the(CategoryPage.APPLIED_FILTER_BOX, isVisible()).forNoMoreThan(50).seconds()
        );
    }

    @And("she hits the refresh button")
    public void actor_hits_the_refresh_button() {
        theActorInTheSpotlight().attemptsTo(
                RefreshPage.refresh(),
                WaitUntil.the(NEWSLETTER_POPUP, isPresent()),
                Click.on(NEWSLETTER_POPUP_CLOSE_BUTTON)
        );
    }

    @And("she goes to the next page")
    public void actor_goes_to_the_next_page() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(APPLIED_FILTER_BOX, isPresent()).forNoMoreThan(50).seconds(),
                WaitUntil.the(PAGINATION_ARROW, isClickable()),
                Click.on(PAGINATION_ARROW),
                WaitUntil.the(SUBMIT_BUTTON, isNotPresent()),
                WaitUntil.the(PAGINATION_ARROW, isClickable()),
                WaitUntil.the(APPLIED_FILTER_BOX, isPresent())
        );
    }

    @Then("she should see that the filter is still applied")
    public void actor_should_see_that_the_filters_are_still_applied() {
        theActorInTheSpotlight().should(seeThat(FilterBox.text(), containsString(".")));
    }
}
