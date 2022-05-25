package com.deosite.tests.features.filtering;

import com.deosite.tests.pages.CategoryPage;
import com.deosite.tests.questions.filters.FilterBox;
import com.deosite.tests.steps.SetupSteps;
import com.deosite.tests.tasks.Setup;
import com.deosite.tests.tasks.basic.MoveMouseToTop;
import com.deosite.tests.tasks.categoryPage.*;
import com.deosite.tests.tasks.filtering.SelectFilter;
import com.deosite.tests.tasks.mainMenu.ClickCategory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Steps;

import static com.deosite.tests.pages.LoginPage.SUBMIT_BUTTON;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static org.hamcrest.CoreMatchers.containsString;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class ApplyRangeFilter {

    @Steps
    SetupSteps setupSteps;

    @Given("that {word} opens a given category page")
    public void that_actor_opens_a_given_category_page(String actor) {
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                ClickCategory.byCategoryNumber(5),
                MoveMouseToTop.move(),
                WaitUntil.the(CategoryPage.CATEGORY_HEADER, isPresent()).forNoMoreThan(100).seconds()
        );
    }

    @When("he enters a value with a comma")
    public void actor_enters_a_value_with_a_comma() {
        theActorInTheSpotlight().attemptsTo(
                ClickFilterButton.number(3),
                WaitUntil.the(CategoryPage.PRICE_FILTER_INPUT, isPresent()).forNoMoreThan(50).seconds(),
                Clear.field(CategoryPage.PRICE_FILTER_INPUT),
                WaitUntil.the(CategoryPage.PRICE_FILTER_INPUT, isClickable()),
                SendKeys.of("10,50").into(CategoryPage.PRICE_FILTER_INPUT),
                WaitUntil.the(CategoryPage.FILTER_BUTTON, isPresent()).forNoMoreThan(50).seconds(),
                Click.on(CategoryPage.FILTER_BUTTON),
                WaitUntil.the(SUBMIT_BUTTON, isNotPresent()),
                WaitUntil.the(CategoryPage.APPLIED_FILTER_BOX, isVisible())
        );
    }

    @When("he enters a value with a period")
    public void actor_enters_a_value_with_a_period() {
        theActorInTheSpotlight().attemptsTo(
                ClickFilterButton.number(3),
                WaitUntil.the(CategoryPage.PRICE_FILTER_INPUT, isPresent()),
                Clear.field(CategoryPage.PRICE_FILTER_INPUT),
                SendKeys.of("10.50").into(CategoryPage.PRICE_FILTER_INPUT),
                Click.on(CategoryPage.FILTER_BUTTON),
                WaitUntil.the(SUBMIT_BUTTON, isNotPresent()),
                WaitUntil.the(CategoryPage.APPLIED_FILTER_BOX, isVisible())
        );
    }

    @Then("he should see that the filter has been applied")
    public void actor_should_see_that_the_filter_has_been_applied() {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(CategoryPage.APPLIED_FILTER_BOX).isDisplayed()
        );
    }

    @And("the digits are separated with a period")
    public void the_digits_are_separated_with_a_period() {
        theActorInTheSpotlight().should(seeThat(FilterBox.text(), containsString(".")));
    }
}
