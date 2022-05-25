package com.deosite.tests.features.sorting;

import com.deosite.tests.actions.Open;
import com.deosite.tests.actions.Search;
import com.deosite.tests.pages.CategoryPage;
import com.deosite.tests.pages.ProductPage;
import com.deosite.tests.questions.product.ProductPrice;
import com.deosite.tests.steps.SetupSteps;
import com.deosite.tests.tasks.Setup;
import com.deosite.tests.tasks.basic.MoveMouseToTop;
import com.deosite.tests.tasks.basic.ReturnToPreviousPage;
import com.deosite.tests.tasks.categoryPage.SelectSortingOption;
import com.deosite.tests.tasks.mainMenu.ClickCategory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Steps;

import java.math.BigDecimal;

import static com.deosite.tests.pages.CategoryPage.CATEGORY_HEADER;
import static com.deosite.tests.pages.MainMenu.FIRST_MAIN_CATEGORY;
import static com.deosite.tests.pages.MainMenu.SEARCH_BAR;
import static com.deosite.tests.pages.SearchPage.PRODUCTS_TITLE;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class SortingByPriceHighestFirst {
    @Steps
    SetupSteps setupSteps;
    BigDecimal firstProductPrice;
    BigDecimal secondProductPrice;

@Given("that {word} opens the first category page")
    public void maja_opens_the_first_category_page(String actor){
    theActorCalled(actor).wasAbleTo(
            Setup.site(),
            WaitUntil.the(FIRST_MAIN_CATEGORY, isPresent()),
            ClickCategory.byCategoryNumber(0),
            MoveMouseToTop.move(),
            WaitUntil.the(CategoryPage.PAGINATION_ARROW, isPresent())

    );
}
    @Given("that {word} attempts to look fo a {string}")
    public void maja_attempts_to_look_for_a_mug(String actor, String keyword){
        theActorCalled(actor).wasAbleTo(
                Setup.site(),
                WaitUntil.the(SEARCH_BAR, isPresent()),
                Search.forProductByTranslatedKeyword(keyword),
                WaitUntil.the(CATEGORY_HEADER, isPresent())

        );
    }
@When("she applies a price filter with a descending order")
      public void actor_applies_sorts(){
    theActorInTheSpotlight().attemptsTo(
            Click.on(CategoryPage.SORTING_BUTTON),
            SelectSortingOption.number(1),
            WaitUntil.the(CategoryPage.FILTERS_LIST, isClickable()),
            WaitUntil.the(PRODUCTS_TITLE, isPresent()).forNoMoreThan(50).seconds()

    );

    }
    @When("she applies a price filter with a descending order after search")
    public void actor_applies_sorts_after_search(){
        theActorInTheSpotlight().attemptsTo(
                Click.on(CategoryPage.SORTING_BUTTON),
                SelectSortingOption.number(0),
                WaitUntil.the(CategoryPage.FILTERS_LIST, isClickable()),
                WaitUntil.the(PRODUCTS_TITLE, isPresent()).forNoMoreThan(50).seconds()
        );
    }
@And("she sees the first price")
    public void actor_sees_first_price(){
    theActorInTheSpotlight().attemptsTo(
            Open.productPageByPosition(1),
            WaitUntil.the(ProductPage.PRODUCT_PRICE, isPresent()).forNoMoreThan(50).seconds()

    );
    firstProductPrice= ProductPrice.price().answeredBy(theActorInTheSpotlight());

    }
@And("she sees the second price")
public void actor_sees_second_price(){
    theActorInTheSpotlight().attemptsTo(
            Scroll.to(SEARCH_BAR),
            ReturnToPreviousPage.goToPreviousPage(),
            Open.productPageByPosition(10)
    );
    secondProductPrice= ProductPrice.price().answeredBy(theActorInTheSpotlight());
}
@Then("she should ensure that the sort is correct")
    public void actor_ensures_the_sort_is_correct(){
    theActorInTheSpotlight().attemptsTo();
    Ensure.that(firstProductPrice).isGreaterThan(secondProductPrice);
}
}
