package com.deosite.tests.features.cookies_panel;

import com.deosite.tests.pages.CookiesNotification;
import com.deosite.tests.questions.category.CurrentUrl;
import com.deosite.tests.steps.SetupSteps;
import com.deosite.tests.tasks.SetupWithoutAcceptingCookies;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Steps;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.containsString;

public class SeeCookiesPolicy {

    @Steps
    SetupSteps setupSteps;

    @Given("that {word} is about to accept the cookies")
    public void that_actor_is_about_to_accept_the_cookies(String actor) {
        theActorCalled(actor).wasAbleTo(
                SetupWithoutAcceptingCookies.setup()
        );
    }

    @When("he clicks see more button")
    public void actor_clicks_see_more_button() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(CookiesNotification.SEE_MORE_BUTTON, isPresent()),
                Click.on(CookiesNotification.SEE_MORE_BUTTON)
                );
    }

    @And("he clicks cookies policy")
    public void actor_clicks_cookies_policy() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(CookiesNotification.COOKIES_POLICY, isPresent()),
                Click.on(CookiesNotification.COOKIES_POLICY));
    }

    @Then("he should see the cookies policy")
    public void actor_should_see_the_cookies_policy() {
        theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), containsString("info/cookies"))
        );
    }
}
