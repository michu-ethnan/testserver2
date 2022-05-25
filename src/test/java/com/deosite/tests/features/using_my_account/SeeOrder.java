package com.deosite.tests.features.using_my_account;

import com.deosite.tests.actions.Open;
import com.deosite.tests.pages.CategoryPage;
import com.deosite.tests.questions.account.OrderImage;
import com.deosite.tests.steps.SetupSteps;
import com.deosite.tests.tasks.Setup;
import com.deosite.tests.tasks.account.SelectOrder;
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

import static com.deosite.tests.pages.AccountPage.*;
import static com.deosite.tests.pages.LoginPage.LOGIN_BUTTON;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class SeeOrder {

    @Steps
    SetupSteps setupSteps;

    @Given("that {word} is in My Account")
    public void that_actor_is_in_my_account(String actor) {
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                WaitUntil.the(LOGIN_BUTTON, isPresent()),
                Open.loginPage(),
                FillInLoginForm.type("login"),
                SubmitLoginForm.submitLoginForm(),
                MoveMouseToTop.move(),
                Open.accountPage(),
                WaitUntil.the(MY_ACCOUNT_HEADER, isPresent()).forNoMoreThan(50).seconds()
        );
    }

    @When("he goes to My Orders tab")
    public void actor_goes_to_my_orders_tab() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(MY_ORDERS_BUTTON),
                WaitUntil.the(CategoryPage.PAGINATION_SELECT, isPresent()).forNoMoreThan(100).seconds()
        );
    }

    @And("he clicks on a selected order")
    public void actor_clicks_on_a_selected_order() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(ORDER_LIST, isPresent()),
                SelectOrder.byNumber(2),
                WaitUntil.the(ORDER_IMAGE, isPresent())
        );
    }

    @Then("he should see the details of this order")
    public void he_should_see_the_details_of_this_order() {
        theActorInTheSpotlight().should(seeThat(OrderImage.isDisplayed()));
    }
}
