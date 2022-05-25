package com.deosite.tests.features.using_minicart;

import com.deosite.tests.actions.Open;
import com.deosite.tests.actions.Search;
import com.deosite.tests.pages.*;
import com.deosite.tests.questions.login.LoginButton;
import com.deosite.tests.steps.SetupSteps;
import com.deosite.tests.tasks.Setup;
import com.deosite.tests.tasks.basic.*;
import com.deosite.tests.tasks.mainMenu.*;
import com.deosite.tests.tasks.product.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.ensure.*;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Steps;

import static com.deosite.tests.abilities.Load.as;
import static com.deosite.tests.pages.Alert.ALERT_BOX;
import static com.deosite.tests.pages.MiniCart.MINICART_BUTTON;
import static com.deosite.tests.pages.MiniCart.CLOSE_CART_BUTTON;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static org.hamcrest.Matchers.equalTo;

public class CloseCart {

    @Steps
    SetupSteps setupSteps;

    @Given("that {word} opens minicart with a {word}")
    public void that_actor_opens_minicart_with_a_product(String actor, String product) {
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                ClickCategory.byCategoryNumber(5),
                Open.productPageByPositionRandomly(),
                //WaitUntil.the(CategoryPage.CATEGORY_HEADER, isNotPresent()),
                AddProduct.toCart(),
                MoveMouseDown.move(),
                Scroll.to(MiniCart.MINICART_BUTTON),
                Open.miniCart()
        );
    }

    @When("he closes the cart")
    public void actor_closes_the_cart() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(CLOSE_CART_BUTTON, isPresent()),
                Click.on(CLOSE_CART_BUTTON)
        );
    }

    @Then("he should see {string}")
    public void actor_should_see_login_button_text(String message) {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(CLOSE_CART_BUTTON).isNotDisplayed()
        );
    }
}
