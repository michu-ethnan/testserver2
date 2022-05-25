package com.deosite.tests.features.filtering;

import com.deosite.tests.pages.*;
import com.deosite.tests.steps.*;
import com.deosite.tests.tasks.*;
import com.deosite.tests.tasks.basic.*;
import com.deosite.tests.tasks.categoryPage.*;
import com.deosite.tests.tasks.mainMenu.*;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.ensure.*;
import net.serenitybdd.screenplay.waits.*;
import net.thucydides.core.annotations.*;

import static com.deosite.tests.pages.CategoryPage.*;
import static com.deosite.tests.pages.MainMenu.SEARCH_BAR;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class ClearFilter {

    @Steps
    SetupSteps setupSteps;

    @Given("that {word} happens to be on a category page")
    public void that_actor_happens_to_be_on_a_category_page(String actor) {
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                ClickCategory.byCategoryNumber(0),
                MoveMouseToTop.move(),
                WaitUntil.the(CategoryPage.CATEGORY_HEADER, isPresent())
        );
    }

    @When("he applies a filter")
    public void actor_applies_a_filter() {
        theActorInTheSpotlight().attemptsTo(
                ClickFilterButton.number(0),
                ClickSelectedFilter.number(0),
                Click.on(SUBMIT_FILTER_BUTTON),
                Scroll.to(SEARCH_BAR),
                WaitUntil.the(APPLIED_FILTER_BOX, isPresent())
        );
    }

    @And("then he clears filters")
    public void then_actor_clears_filters() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(APPLIED_FILTER_BOX),
                WaitUntil.the(CLEAR_FILTERS_BUTTON, isPresent()),
                Click.on(CLEAR_FILTERS_BUTTON),
                WaitUntil.the(FILTERS_LIST, isClickable())
        );
    }

    @Then("he should see that the filter is not applied")
    public void actor_should_see_that_the_filter_is_not_applied() {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(CLEAR_FILTERS_BUTTON).isNotDisplayed()
        );
    }
}
