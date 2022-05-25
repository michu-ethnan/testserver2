package com.deosite.tests.features.filtering;

import com.deosite.tests.steps.SetupSteps;
import com.deosite.tests.tasks.Setup;
import com.deosite.tests.tasks.categoryPage.ApplyFilters;
import com.deosite.tests.tasks.mainMenu.ClickCategory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Steps;

import static com.deosite.tests.pages.CategoryPage.APPLIED_FILTER_BOX;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ApplyAllFilters {

    @Steps
    SetupSteps setupSteps;
    String filter;
    @Given("that {word} is on a certain category page")
    public void gemma_is_on_a_category_page(String actor){
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                ClickCategory.byCategoryNumber(0)
        );
    }
    @When("she applies {word} filter, refreshes the page, goes to next page and hit refresh")
    public void gemma_applies_filters(String filterName){
        theActorInTheSpotlight().attemptsTo(
                ApplyFilters.byFilterName(filterName)
        );

    }

    @Then("she should see that she's on the next page and the filter is still applied")
    public void gemma_should_see_that_the_filter_is_still_applied(){
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(APPLIED_FILTER_BOX).isDisplayed()
        );


    }
    @Then("she should see that the filter is applied")
    public void gemma_should_see_that_the_filter_is_still_present(){

        theActorInTheSpotlight().attemptsTo(
                Ensure.that(APPLIED_FILTER_BOX).isDisplayed()
        );

    }
}
