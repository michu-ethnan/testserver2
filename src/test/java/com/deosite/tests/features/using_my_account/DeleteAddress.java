package com.deosite.tests.features.using_my_account;

import com.deosite.tests.actions.Open;
import com.deosite.tests.pages.*;
import com.deosite.tests.steps.SetupSteps;
import com.deosite.tests.tasks.Setup;
import com.deosite.tests.tasks.basic.*;
import com.deosite.tests.tasks.login.FillInLoginForm;
import com.deosite.tests.tasks.login.SubmitLoginForm;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Steps;

import static com.deosite.tests.abilities.Load.as;
import static com.deosite.tests.pages.AccountPage.MY_ACCOUNT_HEADER;
import static com.deosite.tests.pages.AccountPage.ADDRESS_BOOK_BUTTON;
import static com.deosite.tests.pages.AccountPage.FIRST_TRASH_ICON;
import static com.deosite.tests.pages.AccountPage.DIALOG_BOX_YES_BUTTON;
import static com.deosite.tests.pages.LoginPage.LOGIN_BUTTON;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static org.hamcrest.Matchers.equalTo;

public class DeleteAddress {

    @Steps
    SetupSteps setupSteps;

    @Given("that {word} is in the address book")
    public void that_actor_is_in_the_address_book(String actor) {
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                WaitUntil.the(LOGIN_BUTTON, isPresent()),
                Open.loginPage(),
                FillInLoginForm.type("login"),
                SubmitLoginForm.submitLoginForm(),
                MoveMouseToTop.move(),
                Open.accountPage(),
                WaitUntil.the(MY_ACCOUNT_HEADER, isPresent()).forNoMoreThan(100).seconds(),
                Click.on(ADDRESS_BOOK_BUTTON),
                WaitUntil.the(FIRST_TRASH_ICON, isPresent()).forNoMoreThan(100).seconds(),
                WaitUntil.the(FIRST_TRASH_ICON, isClickable()).forNoMoreThan(100).seconds()
        );
    }

    @When("he clicks on a trash icon")
    public void actor_clicks_on_a_trash_icon() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(FIRST_TRASH_ICON)
        );
    }

    @And("he confirms that he wants to remove the address")
    public void actor_confirms_that_he_wants_to_remove_the_address() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(DIALOG_BOX_YES_BUTTON, isClickable()),
                Click.on(DIALOG_BOX_YES_BUTTON),
                WaitUntil.the(Alert.ALERT_BOX, isPresent())
        );
    }

    @Then("he should see a popup with {string} inscription")
    public void actor_should_see_a_popup_with_address_deleted_inscription(String message) {
        theActorInTheSpotlight().should(seeThat(com.deosite.tests.questions.alert.Alert.value(), equalTo(
                as(theActorInTheSpotlight()).translate(message))));
    }
}
