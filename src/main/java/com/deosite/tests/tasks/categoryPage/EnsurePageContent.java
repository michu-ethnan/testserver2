package com.deosite.tests.tasks.categoryPage;

import com.deosite.tests.pages.CategoryPage;
import com.deosite.tests.questions.CategoryHeader;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static com.deosite.tests.pages.BrandPage.BRAND_LIST;
import static com.deosite.tests.pages.CategoryPage.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static org.hamcrest.Matchers.containsString;

public class EnsurePageContent implements Task {
    private final String categoryName;
    public EnsurePageContent(String categoryName){
        this.categoryName = categoryName;
    }

    @Override
    @Step("{0} ensures #categorContent")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CategoryPage.CATEGORY_HEADER, isPresent())
        );
        switch (categoryName) {

            case "Ogród":
                theActorInTheSpotlight().should(seeThat(CategoryHeader.valueIs(), containsString("Ogród")));
                actor.attemptsTo(
                        Ensure.that(GO_TO_MAIN_PAGE_BUTTON).isEnabled(),
                        Ensure.that(FILTERS_LIST).isDisplayed(),
                        Ensure.that(FILTERS_LIST).isEnabled(),
                        Ensure.that(SORTING_BUTTON).isDisplayed(),
                        Ensure.that(SORTING_BUTTON).isEnabled(),
                        Ensure.that(PAGINATION_ARROW).isEnabled(),
                        Ensure.that(PAGINATION_SELECT).isEnabled(),
                        Scroll.to(PAGINATION_ARROW_BOTTOM),
                        Ensure.that(PAGINATION_ARROW_BOTTOM).isEnabled(),
                        Ensure.that(PAGINATION_SELECT_BOTTOM).isEnabled()
                );
                break;

            case "Kuchnia":
                theActorInTheSpotlight().should(seeThat(CategoryHeader.valueIs(), containsString("Kuchnia")));
                actor.attemptsTo(
                        Ensure.that(GO_TO_MAIN_PAGE_BUTTON).isEnabled(),
                        Ensure.that(FILTERS_LIST).isDisplayed(),
                        Ensure.that(FILTERS_LIST).isEnabled(),
                        Ensure.that(SORTING_BUTTON).isDisplayed(),
                        Ensure.that(SORTING_BUTTON).isEnabled(),
                        Ensure.that(PAGINATION_ARROW).isEnabled(),
                        Ensure.that(PAGINATION_SELECT).isEnabled(),
                        Scroll.to(PAGINATION_ARROW_BOTTOM),
                        Ensure.that(PAGINATION_ARROW_BOTTOM).isEnabled(),
                        Ensure.that(PAGINATION_SELECT_BOTTOM).isEnabled()
                );
                break;
            case "ŚwiatDziecka":
                theActorInTheSpotlight().should(seeThat(CategoryHeader.valueIs(), containsString("Świat dziecka")));
                actor.attemptsTo(
                        Ensure.that(GO_TO_MAIN_PAGE_BUTTON).isEnabled(),
                        Ensure.that(FILTERS_LIST).isDisplayed(),
                        Ensure.that(FILTERS_LIST).isEnabled(),
                        Ensure.that(SORTING_BUTTON).isDisplayed(),
                        Ensure.that(SORTING_BUTTON).isEnabled(),
                        Ensure.that(PAGINATION_ARROW).isEnabled(),
                        Ensure.that(PAGINATION_SELECT).isEnabled(),
                        Scroll.to(PAGINATION_ARROW_BOTTOM),
                        Ensure.that(PAGINATION_ARROW_BOTTOM).isEnabled(),
                        Ensure.that(PAGINATION_SELECT_BOTTOM).isEnabled()
                );
                break;
            case "Wyprzedaż":
                theActorInTheSpotlight().should(seeThat(CategoryHeader.valueIs(), containsString("Wyprzedaż")));
                actor.attemptsTo(
                        Ensure.that(GO_TO_MAIN_PAGE_BUTTON).isEnabled(),
                        Ensure.that(FILTERS_LIST).isDisplayed(),
                        Ensure.that(FILTERS_LIST).isEnabled(),
                        Ensure.that(SORTING_BUTTON).isDisplayed(),
                        Ensure.that(SORTING_BUTTON).isEnabled(),
                        Ensure.that(PAGINATION_ARROW).isEnabled(),
                        Ensure.that(PAGINATION_SELECT).isEnabled(),
                        Scroll.to(PAGINATION_ARROW_BOTTOM),
                        Ensure.that(PAGINATION_ARROW_BOTTOM).isEnabled(),
                        Ensure.that(PAGINATION_SELECT_BOTTOM).isEnabled()
                );
                break;
            case "ŁazienkaIgarderoba":
                theActorInTheSpotlight().should(seeThat(CategoryHeader.valueIs(), containsString("Łazienka i garderoba")));
                actor.attemptsTo(
                        Ensure.that(GO_TO_MAIN_PAGE_BUTTON).isEnabled(),
                        Ensure.that(FILTERS_LIST).isDisplayed(),
                        Ensure.that(SORTING_BUTTON).isDisplayed(),
                        Ensure.that(PAGINATION_ARROW).isDisplayed(),
                        Ensure.that(PAGINATION_SELECT).isDisplayed(),
                        Scroll.to(PAGINATION_ARROW_BOTTOM),
                        Ensure.that(PAGINATION_ARROW_BOTTOM).isEnabled(),
                        Ensure.that(PAGINATION_SELECT_BOTTOM).isEnabled()
                );
                break;
            case "Dekoracje":
                theActorInTheSpotlight().should(seeThat(CategoryHeader.valueIs(), containsString("Dekoracje")));
                actor.attemptsTo(
                        Ensure.that(GO_TO_MAIN_PAGE_BUTTON).isEnabled(),
                        Ensure.that(FILTERS_LIST).isDisplayed(),
                        Ensure.that(SORTING_BUTTON).isDisplayed(),
                        Ensure.that(PAGINATION_ARROW).isDisplayed(),
                        Ensure.that(PAGINATION_SELECT).isDisplayed(),
                        Scroll.to(PAGINATION_ARROW_BOTTOM),
                        Ensure.that(PAGINATION_ARROW_BOTTOM).isEnabled(),
                        Ensure.that(PAGINATION_SELECT_BOTTOM).isEnabled()
                );
                break;
            case "Nowości":
                theActorInTheSpotlight().should(seeThat(CategoryHeader.valueIs(), containsString("Nowości")));
                actor.attemptsTo(
                        Ensure.that(GO_TO_MAIN_PAGE_BUTTON).isEnabled(),
                        Ensure.that(FILTERS_LIST).isDisplayed(),
                        Ensure.that(SORTING_BUTTON).isDisplayed(),
                        Ensure.that(PAGINATION_ARROW).isDisplayed(),
                        Ensure.that(PAGINATION_SELECT).isDisplayed(),
                        Scroll.to(PAGINATION_ARROW_BOTTOM),
                        Ensure.that(PAGINATION_ARROW_BOTTOM).isEnabled(),
                        Ensure.that(PAGINATION_SELECT_BOTTOM).isEnabled()
                );
                break;
            case "Marki":
                theActorInTheSpotlight().should(seeThat(CategoryHeader.valueIs(), containsString("Marki")));
                actor.attemptsTo(
                        Ensure.that(BRAND_LIST).isDisplayed()
                );
                break;
            case "Inspiracje":
                theActorInTheSpotlight().should(seeThat(CategoryHeader.valueIs(), containsString("#dajarpl")));
                actor.attemptsTo(

                        Ensure.that(INSPIRATIONS_BANNER_1).isEnabled(),
                        Scroll.to(INSPIRATIONS_BANNER_2),
                        Ensure.that(INSPIRATIONS_BANNER_2).isEnabled(),
                        Scroll.to(INSPIRATIONS_BANNER_3),
                        Ensure.that(INSPIRATIONS_BANNER_3).isEnabled(),
                        Scroll.to(INSPIRATIONS_BANNER_4),
                        Ensure.that(INSPIRATIONS_BANNER_4).isEnabled(),
                        Scroll.to(INSPIRATIONS_BANNER_5),
                        Ensure.that(INSPIRATIONS_BANNER_5).isEnabled(),
                        Scroll.to(INSPIRATIONS_BANNER_6),
                        Ensure.that(INSPIRATIONS_BANNER_6).isEnabled(),
                        Scroll.to(INSPIRATIONS_BANNER_7),
                        Ensure.that(INSPIRATIONS_BANNER_7).isEnabled(),
                        Scroll.to(INSPIRATIONS_BANNER_8),
                        Ensure.that(INSPIRATIONS_BANNER_8).isEnabled(),
                        Scroll.to(INSPIRATIONS_BANNER_9),
                        Ensure.that(INSPIRATIONS_BANNER_9).isEnabled()

                );
                break;
            case "Promocje":
                theActorInTheSpotlight().should(seeThat(CategoryHeader.valueIs(), containsString("Promocje - Kupuj Taniej!")));
                actor.attemptsTo(
                         Ensure.that(FIRST_PROMOTION_BANNER).isDisplayed(),
                        Ensure.that(FIRST_PROMOTION_BANNER).isEnabled(),
                        Scroll.to(SECOND_PROMOTION_BANNER),
                        WaitUntil.the(SECOND_PROMOTION_BANNER, isClickable()),
                        Ensure.that(SECOND_PROMOTION_BANNER).isDisplayed(),
                        Ensure.that(SECOND_PROMOTION_BANNER).isEnabled(),
                        Scroll.to(THIRD_PROMOTION_BANNER),
                        WaitUntil.the(THIRD_PROMOTION_BANNER, isClickable()),
                        Ensure.that(THIRD_PROMOTION_BANNER).isDisplayed(),
                        Ensure.that(THIRD_PROMOTION_BANNER).isEnabled(),
                        Scroll.to(FOURTH_PROMOTION_BANNER),
                        WaitUntil.the(FOURTH_PROMOTION_BANNER, isClickable()),
                        Ensure.that(FOURTH_PROMOTION_BANNER).isDisplayed(),
                        Ensure.that(FOURTH_PROMOTION_BANNER).isEnabled()

                );
                break;
        }


        }

    public static EnsurePageContent by(String categoryName) {
        return Instrumented.instanceOf(EnsurePageContent.class).withProperties(categoryName);
    }
}
