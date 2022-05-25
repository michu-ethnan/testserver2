package com.deosite.tests.features.navigating_website;

import com.deosite.tests.steps.SetupSteps;
import com.deosite.tests.tasks.Setup;
import com.deosite.tests.tasks.mainMenu.ClickCategory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Steps;

import static com.deosite.tests.pages.CategoryPage.CATEGORY_HEADER;
import static com.deosite.tests.pages.MainMenu.FIRST_MAIN_CATEGORY;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class NavigateMenu {

    @Steps
    SetupSteps setupSteps;

    @Given("that {word} wants to go to a certain category")
    public void that_actor_wants_to_go_to_a_certain_category(String actor) {
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                WaitUntil.the(FIRST_MAIN_CATEGORY, isPresent()).forNoMoreThan(50).seconds()
                );
    }

    @When("she clicks a category")
    public void actor_clicks_a_category() {
        theActorInTheSpotlight().attemptsTo(
                ClickCategory.byCategoryNumber(4),
                WaitUntil.the(CATEGORY_HEADER, isPresent()).forNoMoreThan(50).seconds()

        );
    }
    @Then("she should see category header")
    public void actor_should_see_a_category(){
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(CATEGORY_HEADER).isDisplayed()
        );
    }

}
