package com.deosite.tests.features.using_my_account;

import com.deosite.tests.actions.Open;
import com.deosite.tests.pages.AccountPage;
import com.deosite.tests.steps.SetupSteps;
import com.deosite.tests.tasks.Setup;
import com.deosite.tests.tasks.account.FillInAddressForm;
import com.deosite.tests.tasks.basic.*;
import com.deosite.tests.tasks.homePage.*;
import com.deosite.tests.tasks.login.FillInLoginForm;
import com.deosite.tests.tasks.login.SubmitLoginForm;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Steps;

import static com.deosite.tests.pages.AccountPage.MY_ACCOUNT_HEADER;
import static com.deosite.tests.pages.AccountPage.ADDRESS_BOOK_BUTTON;
import static com.deosite.tests.pages.AccountPage.ADD_NEW_ADDRESS_BUTTON;
import static com.deosite.tests.pages.AccountPage.SUBMIT_NEW_ADDRESS_BUTTON;
import static com.deosite.tests.pages.Alert.ALERT_BOX;
import static com.deosite.tests.pages.LoginPage.LOGIN_BUTTON;
import static com.deosite.tests.abilities.Load.as;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsText;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class AddAddress {

    @Steps
    SetupSteps setupSteps;

    @Given("that {word} is logged into her account")
    public void that_actor_is_logged_into_her_account(String actor) {
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                WaitUntil.the(LOGIN_BUTTON, isPresent()).forNoMoreThan(100).seconds(),
                Open.loginPage(),
                FillInLoginForm.type("login"),
                SubmitLoginForm.submitLoginForm(),
                MoveMouseToTop.move(),
                Open.accountPage(),
                WaitUntil.the(MY_ACCOUNT_HEADER, isPresent()).forNoMoreThan(50).seconds()
        );
    }

    @When("she adds {word} to the address book")
    public void actor_adds_a_new_address_to_the_address_book(String userType) {
        theActorInTheSpotlight().attemptsTo(
                Click.on(ADDRESS_BOOK_BUTTON),
                WaitUntil.the(ADD_NEW_ADDRESS_BUTTON, isPresent()),
                Click.on(ADD_NEW_ADDRESS_BUTTON),
                WaitUntil.the(AccountPage.MY_ACCOUNT_SUBHEADER, containsText("Nowy adres")),
                FillInAddressForm.type(userType),
                WaitUntil.the(SUBMIT_NEW_ADDRESS_BUTTON, isPresent()),
                Click.on(SUBMIT_NEW_ADDRESS_BUTTON),
                WaitUntil.the(ALERT_BOX, isPresent()).forNoMoreThan(100).seconds()
        );
    }

    @Then("she should see a popup saying {string}")
    public void actor_should_find_this_address_in_the_address_book(String message) {
        theActorInTheSpotlight().should(seeThat(com.deosite.tests.questions.alert.Alert.value(), equalTo(
                as(theActorInTheSpotlight()).translate(message))));
    }
}
