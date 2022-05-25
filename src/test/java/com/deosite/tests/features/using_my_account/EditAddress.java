package com.deosite.tests.features.using_my_account;

import com.deosite.tests.actions.Open;
import com.deosite.tests.steps.SetupSteps;
import com.deosite.tests.tasks.Setup;
import com.deosite.tests.tasks.account.SelectAddress;
import com.deosite.tests.tasks.basic.*;
import com.deosite.tests.tasks.login.FillInLoginForm;
import com.deosite.tests.tasks.login.SubmitLoginForm;
import com.deosite.tests.tasks.account.ClearAddressForm;
import com.deosite.tests.tasks.account.FillInAddressForm;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Steps;

import static com.deosite.tests.abilities.Load.as;
import static com.deosite.tests.pages.AccountPage.MY_ACCOUNT_HEADER;
import static com.deosite.tests.pages.AccountPage.ADDRESS_BOOK_BUTTON;
import static com.deosite.tests.pages.AccountPage.SUBMIT_NEW_ADDRESS_BUTTON;
import static com.deosite.tests.pages.LoginPage.LOGIN_BUTTON;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static org.hamcrest.Matchers.equalTo;

public class EditAddress {

    @Steps
    SetupSteps setupSteps;

    @Given("that {word} happens to be in the address book")
    public void that_actor_happens_to_be_in_the_address_book(String actor) {
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                WaitUntil.the(LOGIN_BUTTON, isPresent()).forNoMoreThan(50).seconds(),
                Open.loginPage(),
                FillInLoginForm.type("login"),
                SubmitLoginForm.submitLoginForm(),
                MoveMouseToTop.move(),
                Open.accountPage(),
                WaitUntil.the(MY_ACCOUNT_HEADER, isPresent()).forNoMoreThan(100).seconds(),
                Click.on(ADDRESS_BOOK_BUTTON)
        );
    }

    @When("she clicks on some address in the address book")
    public void actor_clicks_on_some_address_in_the_address_book() {
        theActorInTheSpotlight().attemptsTo(
                SelectAddress.byNumber(0)
        );
    }

    @And("she edits input fields")
    public void actor_edits_input_fields() {
        theActorInTheSpotlight().attemptsTo(
                ClearAddressForm.clearForm()
        );
    }

    @And("she adds a {word}")
    public void actor_adds_a_new_address(String userType) {
        theActorInTheSpotlight().attemptsTo(
                FillInAddressForm.type(userType)
        );
    }

    @And("she saves it")
    public void actor_saves_it() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(SUBMIT_NEW_ADDRESS_BUTTON)
        );
    }

    @Then("she should see that it was saved with popup saying {string}")
    public void actor_should_see_that_it_was_saved(String message) {
        theActorInTheSpotlight().should(seeThat(com.deosite.tests.questions.alert.Alert.value(), equalTo(
                as(theActorInTheSpotlight()).translate(message))));
    }
}
