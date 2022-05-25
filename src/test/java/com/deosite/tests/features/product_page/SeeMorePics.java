package com.deosite.tests.features.product_page;

import com.deosite.tests.actions.Open;
import com.deosite.tests.pages.CategoryPage;
import com.deosite.tests.steps.SetupSteps;
import com.deosite.tests.tasks.Setup;
import com.deosite.tests.tasks.mainMenu.ClickCategory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Steps;

import static com.deosite.tests.pages.LoginPage.SUBMIT_BUTTON;
import static com.deosite.tests.pages.ProductPage.LEFT_ARROW;
import static com.deosite.tests.pages.ProductPage.RIGHT_ARROW;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;

public class SeeMorePics {

    @Steps
    SetupSteps setupSteps;

    @Given("that {word} sees that there are more than 10 pictures on the PDP")
    public void that_there_are_more_than_10_pictures_on_the_pdp(String actor) {
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                ClickCategory.byCategoryNumber(0),
                Open.productPageByPosition(9),
                WaitUntil.the(SUBMIT_BUTTON, isNotPresent())
        );
    }

    @When("she clicks the right arrow")
    public void actor_clicks_the_right_arrow() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(RIGHT_ARROW, isPresent()),
                MoveMouse.to(RIGHT_ARROW),
                Click.on(RIGHT_ARROW)
        );
    }

    @And("she clicks the left arrow")
    public void actor_clicks_the_left_arrow() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(LEFT_ARROW, isPresent()),
                Click.on(LEFT_ARROW)
        );
    }

    @Then("she should notice that the right arrow disappears if there are no more pictures")
    public void actor_should_notice_that_the_arrow_disappears_if_there_are_no_more_pictures() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(RIGHT_ARROW, isNotVisible()),
                Ensure.that(RIGHT_ARROW).isNotDisplayed()
        );
    }

    @Then("she should see that the left arrow disappears after returning to the first page")
    public void actor_should_see_that_the_left_arrow_disappears_after_returning_to_the_first_page() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(LEFT_ARROW, isNotVisible()),
                Ensure.that(LEFT_ARROW).isNotDisplayed()
        );
    }
}
