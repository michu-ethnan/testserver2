package com.deosite.tests.features.login;

import com.deosite.tests.actions.Open;
import com.deosite.tests.pages.*;
import com.deosite.tests.questions.minicart.ProductNameInMinicart;
import com.deosite.tests.questions.product.*;
import com.deosite.tests.steps.SetupSteps;
import com.deosite.tests.tasks.Setup;
import com.deosite.tests.tasks.basic.*;
import com.deosite.tests.tasks.homePage.MoveMouseToBottom;
import com.deosite.tests.tasks.login.FillInLoginForm;
import com.deosite.tests.tasks.login.SubmitLoginForm;
import com.deosite.tests.tasks.mainMenu.ClickCategory;
import com.deosite.tests.tasks.product.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Steps;

import static com.deosite.tests.pages.LoginPage.LOGIN_BUTTON;
import static com.deosite.tests.pages.LoginPage.SUBMIT_BUTTON;
import static com.deosite.tests.pages.MainMenu.SEARCH_BAR;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class LogInWithProductsInCart {

    @Steps
    SetupSteps setupSteps;

    String productInCartBeforeLogin;
    String productInCartAfterLogin;

    @Given("that {word} added a product to the cart")
    public void that_actor_added_a_product_to_the_cart(String actor) {
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                ClickCategory.byCategoryNumber(5),
                Open.productPageByPositionRandomly(),
                //WaitUntil.the(CategoryPage.CATEGORY_HEADER, isNotPresent()),
                AddProduct.toCart()
               // Scroll.to(ProductPage.OTHER_PRODUCTS_HEADING),
               // ReturnToPreviousPage.goToPreviousPage()
        );
        productInCartBeforeLogin = ProductName.productName().answeredBy(theActorInTheSpotlight());

        theActorCalled(actor).attemptsTo(Scroll.to(ProductPage.OTHER_PRODUCTS_HEADING));
        theActorCalled(actor).attemptsTo(ReturnToPreviousPage.goToPreviousPage());
    }

    @When("she attempts to log in")
    public void actor_attempts_to_log_in() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(LOGIN_BUTTON, isPresent()).forNoMoreThan(100).seconds(),
                Open.loginPage(),
                FillInLoginForm.type("login and submit order"),
                SubmitLoginForm.submitLoginForm(),

                WaitUntil.the(SUBMIT_BUTTON, isNotPresent())
        );
    }

    @And("opens the minicart")
    public void actor_opens_the_minicart() {
        theActorInTheSpotlight().attemptsTo(
                Open.miniCart(),
                WaitUntil.the(MiniCart.GO_TO_CHECKOUT_BUTTON, isPresent()).forNoMoreThan(100).seconds()
        );
    }

    @Then("she should see that the same product is in the cart")
    public void actor_should_see_that_the_same_product_is_in_the_cart() {
        productInCartAfterLogin = ProductNameInMinicart.productNameInMinicart().answeredBy(theActorInTheSpotlight());
        theActorInTheSpotlight().attemptsTo();
        Ensure.that(productInCartBeforeLogin).isEqualTo(productInCartAfterLogin);
        theActorInTheSpotlight().attemptsTo(
                Click.on(MiniCart.DELETE_PRODUCT_BUTTON)
        );
    }
}
