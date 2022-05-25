package com.deosite.tests.tasks.categoryPage;

import com.deosite.tests.actions.Open;
import com.deosite.tests.pages.CategoryPage;
import com.deosite.tests.questions.CategoryHeader;
import com.deosite.tests.questions.category.CurrentUrl;
import com.deosite.tests.questions.filters.FilterName;
import com.deosite.tests.tasks.basic.RefreshPage;
import com.deosite.tests.tasks.basic.ReturnToPreviousPage;
import com.deosite.tests.tasks.product.MoveMouseDown;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import org.apache.commons.lang3.StringUtils;
import org.hamcrest.Matchers;

import java.util.Locale;

import static com.deosite.tests.pages.CategoryPage.*;
import static com.deosite.tests.pages.MainMenu.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static org.hamcrest.CoreMatchers.containsString;

public class ApplyFilters implements Task {
    String filter;
    String numberOfProductsInFilter;
    String url_filter;
    String selectedFilter;
    private final String filterName;
    public ApplyFilters(String  filterName){
        this.filterName = filterName;
    }

    @Override
    @Step("{0} applies #Filters")
    public <T extends Actor> void performAs(T actor){

                                  /*MARKA*/

        if (filterName.contains("Marka")){
            actor.attemptsTo(
                    ClickFilterButton.number(0)
            );
            filter = FilterName.filterName().answeredBy(theActorInTheSpotlight());
            selectedFilter = filter.replace("(","").replaceAll("[0-9]", "").replace(")","").replaceAll("\\s+", "");
            url_filter = StringUtils.stripAccents(selectedFilter);
            numberOfProductsInFilter = filter.replace("(","").replaceAll("[^\\d.]", "").replace(")","").replaceAll("\\/","").replaceAll("\\s+", "");

            System.out.println("The selected filter name: " + selectedFilter);
            System.out.println("Filter name in url: " + url_filter.toLowerCase(Locale.ROOT));
            System.out.println("Number of products in the selected filter: " + numberOfProductsInFilter);

            actor.attemptsTo(
                    Click.on(SUBMIT_FILTER_BUTTON),
                    WaitUntil.the(SUBMIT_FILTER_BUTTON, isNotPresent()),
                    Ensure.that(CategoryPage.APPLIED_FILTER_BOX).isDisplayed(),
                    RefreshPage.refresh(),
                    WaitUntil.the(NEWSLETTER_POPUP, isPresent()).forNoMoreThan(10).seconds(),
                    Click.on(NEWSLETTER_POPUP_CLOSE_BUTTON),
                    WaitUntil.the(CategoryPage.CATEGORY_HEADER, isPresent()),
                    Ensure.that(CategoryPage.APPLIED_FILTER_BOX).isDisplayed()
            );
            if (PAGINATION_ARROW.resolveFor(actor).isPresent()){
                actor.attemptsTo(
                        WaitUntil.the(PAGINATION_ARROW, isClickable()),
                        Click.on(PAGINATION_ARROW),
                        WaitUntil.the(CATEGORY_HEADER, isPresent()),
                        Ensure.that(CategoryPage.APPLIED_FILTER_BOX).isDisplayed(),
                        RefreshPage.refresh(),
                        Ensure.that(CategoryPage.APPLIED_FILTER_BOX).isDisplayed()
                );

                theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), Matchers.containsString("p=2")));
            }
            actor.attemptsTo(
                    Open.productPageByPositionRandomly(),
                    MoveMouseDown.move(),
                    ReturnToPreviousPage.goToPreviousPage(),
                    WaitUntil.the(FILTER_BUTTONS, isPresent())
            );

            theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), containsString(url_filter.toLowerCase(Locale.ROOT))));
            theActorInTheSpotlight().should(seeThat(CategoryHeader.valueIs(), containsString(selectedFilter)));
            theActorInTheSpotlight().should(seeThat(CategoryHeader.valueIs(), containsString(numberOfProductsInFilter)));

        }



                                                          /*KOLEKCJA*/



        if (filterName.contains("Kolekcja")){
            int maxLength = 5;

            actor.attemptsTo(
                    ClickFilterButton.number(1)
            );

            filter = FilterName.filterName().answeredBy(theActorInTheSpotlight());
            if(filter.length()>maxLength){
                url_filter = filter.substring(0,5).replace("(","").replace(")","").replaceAll("\\s+", "").replaceAll("[0-9]", "");
            }
            selectedFilter = filter.replace("(","").replaceAll("[0-9]", "").replace(")","");
            url_filter = StringUtils.stripAccents(url_filter);
            numberOfProductsInFilter = filter.replace("(","").replaceAll("[^\\d.]", "").replace(")","").replaceAll("\\/","").replaceAll("\\s+", "");

            System.out.println("The selected filter name: " + selectedFilter);
            System.out.println("Filter name in url: " + url_filter.toLowerCase(Locale.ROOT));
            System.out.println("Number of products in the selected filter: " + numberOfProductsInFilter);

            actor.attemptsTo(
                    Click.on(SUBMIT_FILTER_BUTTON),
                    WaitUntil.the(SUBMIT_FILTER_BUTTON, isNotPresent()),
                    Ensure.that(CategoryPage.APPLIED_FILTER_BOX).isDisplayed(),
                    RefreshPage.refresh(),
                    WaitUntil.the(NEWSLETTER_POPUP, isPresent()).forNoMoreThan(10).seconds(),
                    Click.on(NEWSLETTER_POPUP_CLOSE_BUTTON),
                    WaitUntil.the(CategoryPage.CATEGORY_HEADER, isPresent()),
                    Ensure.that(CategoryPage.APPLIED_FILTER_BOX).isDisplayed()
            );

            if (PAGINATION_ARROW.resolveFor(actor).isPresent()){
                actor.attemptsTo(
                        WaitUntil.the(PAGINATION_ARROW, isClickable()),
                        Click.on(PAGINATION_ARROW),
                        WaitUntil.the(CATEGORY_HEADER, isPresent()),
                        Ensure.that(CategoryPage.APPLIED_FILTER_BOX).isDisplayed(),
                        RefreshPage.refresh(),
                        Ensure.that(CategoryPage.APPLIED_FILTER_BOX).isDisplayed()
                );

                theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), Matchers.containsString("p=2")));
            }
            actor.attemptsTo(
                    Open.productPageByPositionRandomly(),
                    MoveMouseDown.move(),
                    ReturnToPreviousPage.goToPreviousPage(),
                    WaitUntil.the(FILTER_BUTTONS, isPresent())
            );
            theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), containsString(url_filter.toLowerCase(Locale.ROOT))));
            theActorInTheSpotlight().should(seeThat(CategoryHeader.valueIs(), containsString(selectedFilter)));
            theActorInTheSpotlight().should(seeThat(CategoryHeader.valueIs(), containsString(numberOfProductsInFilter)));

        }


                                                    /*CENA*/


        if (filterName.contains("Cena")){
            actor.attemptsTo(
                    ClickFilterButton.number(3),
                    WaitUntil.the(CategoryPage.PRICE_FILTER_INPUT, isPresent()).forNoMoreThan(50).seconds(),
                    Clear.field(CategoryPage.PRICE_FILTER_INPUT),
                    WaitUntil.the(CategoryPage.PRICE_FILTER_INPUT, isClickable()),
                    SendKeys.of("50").into(CategoryPage.PRICE_FILTER_INPUT),
                    WaitUntil.the(CategoryPage.FILTER_BUTTON, isPresent()).forNoMoreThan(50).seconds(),
                    Click.on(SUBMIT_FILTER_BUTTON),
                    WaitUntil.the(SUBMIT_FILTER_BUTTON, isNotPresent()),
                    Ensure.that(CategoryPage.APPLIED_FILTER_BOX).isDisplayed(),
                    RefreshPage.refresh(),
                    WaitUntil.the(NEWSLETTER_POPUP, isPresent()).forNoMoreThan(10).seconds(),
                    Click.on(NEWSLETTER_POPUP_CLOSE_BUTTON),
                    WaitUntil.the(CategoryPage.CATEGORY_HEADER, isPresent()),
                    WaitUntil.the(PAGINATION_ARROW, isClickable()),
                    Click.on(PAGINATION_ARROW),
                    WaitUntil.the(CATEGORY_HEADER, isPresent()),
                    Ensure.that(CategoryPage.APPLIED_FILTER_BOX).isDisplayed(),
                    RefreshPage.refresh(),
                    Ensure.that(APPLIED_FILTER_BOX).isDisplayed(),
                    Open.productPageByPositionRandomly(),
                    MoveMouseDown.move(),
                    ReturnToPreviousPage.goToPreviousPage(),
                    WaitUntil.the(FILTER_BUTTONS, isPresent())

            );
            theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), Matchers.containsString("p=2")));
            theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), Matchers.containsString("final_price-50")));
        }



                                                      /*KOLOR*/


        if (filterName.contains("Kolor")){
            actor.attemptsTo(

                    Click.on(ALL_FILTERS_BUTTON),
                    ClickFilterButton.number(4)
            );
            filter = FilterName.filterName().answeredBy(theActorInTheSpotlight());
            selectedFilter = filter.replace("(","").replaceAll("[0-9]", "").replace(")","").replaceAll("\\s+", "");
            url_filter = StringUtils.stripAccents(selectedFilter);
            numberOfProductsInFilter = filter.replace("(","").replaceAll("[^\\d.]", "").replace(")","").replaceAll("\\/","").replaceAll("\\s+", "");

            System.out.println("The selected filter name: " + selectedFilter);
            System.out.println("Filter name in url: " + url_filter.toLowerCase(Locale.ROOT));
            System.out.println("Number of products in the selected filter: " + numberOfProductsInFilter);
            actor.attemptsTo(
                    Click.on(SUBMIT_FILTER_BUTTON),
                    WaitUntil.the(SUBMIT_FILTER_BUTTON, isNotPresent()),
                    Click.on(ALL_FILTERS_BUTTON_AFTER_APPLYING_FILTER),
                    Ensure.that(CategoryPage.APPLIED_FILTER_BOX).isDisplayed(),
                    RefreshPage.refresh(),
                    WaitUntil.the(NEWSLETTER_POPUP, isPresent()).forNoMoreThan(10).seconds(),
                    Click.on(NEWSLETTER_POPUP_CLOSE_BUTTON),
                    Click.on(ALL_FILTERS_BUTTON_AFTER_APPLYING_FILTER),
                    Ensure.that(CategoryPage.APPLIED_FILTER_BOX).isDisplayed()
            );
            if (PAGINATION_ARROW.resolveFor(actor).isPresent()){
                actor.attemptsTo(
                        WaitUntil.the(PAGINATION_ARROW, isClickable()),
                        Click.on(PAGINATION_ARROW),
                        WaitUntil.the(CATEGORY_HEADER, isPresent()),
                        WaitUntil.the(PAGINATION_ARROW, isClickable()),
                        WaitUntil.the(ALL_FILTERS_BUTTON_AFTER_APPLYING_FILTER, isClickable()),
                        Click.on(ALL_FILTERS_BUTTON_AFTER_APPLYING_FILTER),
                        Ensure.that(CategoryPage.APPLIED_FILTER_BOX).isDisplayed(),
                        RefreshPage.refresh(),
                        Click.on(ALL_FILTERS_BUTTON_AFTER_APPLYING_FILTER),
                        Ensure.that(CategoryPage.APPLIED_FILTER_BOX).isDisplayed()
                );
                theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), Matchers.containsString("p=2")));
            }
            actor.attemptsTo(
                    Open.productPageByPositionRandomly(),
                    MoveMouseDown.move(),
                    ReturnToPreviousPage.goToPreviousPage(),
                    WaitUntil.the(FILTER_BUTTONS, isPresent()),
                    Click.on(ALL_FILTERS_BUTTON_AFTER_APPLYING_FILTER)

            );
            theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), containsString(url_filter.toLowerCase(Locale.ROOT))));
            theActorInTheSpotlight().should(seeThat(CategoryHeader.valueIs(), containsString(selectedFilter)));
            theActorInTheSpotlight().should(seeThat(CategoryHeader.valueIs(), containsString(numberOfProductsInFilter)));

        }

                                                              /*MATERIAL*/


        if (filterName.contains("Material")){
            int maxLength = 9;

            actor.attemptsTo(
                    Click.on(ALL_FILTERS_BUTTON),
                    ClickFilterButton.number(5)
            );
            filter = FilterName.filterName().answeredBy(theActorInTheSpotlight());

            if(filter.length()>maxLength){
                url_filter = filter.substring(0,9).replace("(","").replace(")","").replaceAll("\\s+", "").replaceAll("[0-9]", "");
            }
            selectedFilter = filter.replace("(","").replaceAll("[0-9]", "").replace(")","").replaceAll("\\s+", "");
            url_filter = StringUtils.stripAccents(url_filter);
            numberOfProductsInFilter = filter.replace("(","").replaceAll("[^\\d.]", "").replace(")","").replaceAll("\\/","").replaceAll("\\s+", "");

            System.out.println("The selected filter name: " + selectedFilter);
            System.out.println("Filter name in url: " + url_filter.toLowerCase(Locale.ROOT));
            System.out.println("Number of products in the selected filter: " + numberOfProductsInFilter);
            actor.attemptsTo(
                    Click.on(SUBMIT_FILTER_BUTTON),
                    WaitUntil.the(SUBMIT_FILTER_BUTTON, isNotPresent()),
                    Ensure.that(CategoryPage.APPLIED_FILTER_BOX).isDisplayed(),
                    RefreshPage.refresh(),
                    WaitUntil.the(NEWSLETTER_POPUP, isPresent()).forNoMoreThan(10).seconds(),
                    Click.on(NEWSLETTER_POPUP_CLOSE_BUTTON),
                    Ensure.that(CategoryPage.APPLIED_FILTER_BOX).isDisplayed()
            );
            if (PAGINATION_ARROW.resolveFor(actor).isPresent()){
                actor.attemptsTo(
                        WaitUntil.the(PAGINATION_ARROW, isClickable()),
                        Click.on(PAGINATION_ARROW),
                        WaitUntil.the(CATEGORY_HEADER, isPresent()),
                        Ensure.that(CategoryPage.APPLIED_FILTER_BOX).isDisplayed(),
                        RefreshPage.refresh(),
                        Ensure.that(CategoryPage.APPLIED_FILTER_BOX).isDisplayed()
                );
                theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), Matchers.containsString("p=2")));
            }
            actor.attemptsTo(
                    Open.productPageByPositionRandomly(),
                    MoveMouseDown.move(),
                    ReturnToPreviousPage.goToPreviousPage(),
                    WaitUntil.the(FILTER_BUTTONS, isPresent())
            );

            theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), containsString(url_filter.toLowerCase(Locale.ROOT))));
            theActorInTheSpotlight().should(seeThat(CategoryHeader.valueIs(), containsString(selectedFilter)));
            theActorInTheSpotlight().should(seeThat(CategoryHeader.valueIs(), containsString(numberOfProductsInFilter)));
        }


                                                              /*KSZTAŁT*/


        if (filterName.contains("Kształt")){
            actor.attemptsTo(
                    Click.on(ALL_FILTERS_BUTTON),
                    ClickFilterButton.number(6)
            );
            filter = FilterName.filterName().answeredBy(theActorInTheSpotlight());
            selectedFilter = filter.replace("(","").replaceAll("[0-9]", "").replace(")","").replaceAll("\\s+", "");
            url_filter = StringUtils.stripAccents(selectedFilter);
            numberOfProductsInFilter = filter.replace("(","").replaceAll("[^\\d.]", "").replace(")","").replaceAll("\\/","").replaceAll("\\s+", "");

            System.out.println("The selected filter name: " + selectedFilter);
            System.out.println("Filter name in url: " + url_filter.toLowerCase(Locale.ROOT));
            System.out.println("Number of products in the selected filter: " + numberOfProductsInFilter);
            actor.attemptsTo(
                    Click.on(SUBMIT_FILTER_BUTTON),
                    WaitUntil.the(SUBMIT_FILTER_BUTTON, isNotPresent()),
                    Ensure.that(CategoryPage.APPLIED_FILTER_BOX).isDisplayed(),
                    RefreshPage.refresh(),
                    WaitUntil.the(NEWSLETTER_POPUP, isPresent()).forNoMoreThan(10).seconds(),
                    Click.on(NEWSLETTER_POPUP_CLOSE_BUTTON),
                    Ensure.that(CategoryPage.APPLIED_FILTER_BOX).isDisplayed()
            );
            if (PAGINATION_ARROW.resolveFor(actor).isPresent()){
                actor.attemptsTo(
                        Ensure.that(CategoryPage.APPLIED_FILTER_BOX).isDisplayed(),
                        WaitUntil.the(CategoryPage.CATEGORY_HEADER, isPresent()),
                        WaitUntil.the(PAGINATION_ARROW, isClickable()),
                        Click.on(PAGINATION_ARROW),
                        WaitUntil.the(CATEGORY_HEADER, isPresent()),
                        Ensure.that(CategoryPage.APPLIED_FILTER_BOX).isDisplayed(),
                        RefreshPage.refresh(),
                        Ensure.that(CategoryPage.APPLIED_FILTER_BOX).isDisplayed()
                );
                theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), Matchers.containsString("p=2")));

            }
            actor.attemptsTo(
                    Open.productPageByPositionRandomly(),
                    MoveMouseDown.move(),
                    ReturnToPreviousPage.goToPreviousPage(),
                    WaitUntil.the(FILTER_BUTTONS, isPresent())
            );
            theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), containsString(url_filter.toLowerCase(Locale.ROOT))));
            theActorInTheSpotlight().should(seeThat(CategoryHeader.valueIs(), containsString(selectedFilter)));
            theActorInTheSpotlight().should(seeThat(CategoryHeader.valueIs(), containsString(numberOfProductsInFilter)));
        }


                                                        /*POJEMNOŚĆ*/


        if (filterName.contains("Pojemność")){
            actor.attemptsTo(
                    Click.on(ALL_FILTERS_BUTTON),
                    ClickFilterButton.number(8),
                    WaitUntil.the(CategoryPage.PRICE_FILTER_INPUT, isPresent()).forNoMoreThan(50).seconds(),
                    Clear.field(CategoryPage.PRICE_FILTER_INPUT),
                    WaitUntil.the(CategoryPage.PRICE_FILTER_INPUT, isClickable()),
                    SendKeys.of("10").into(CategoryPage.PRICE_FILTER_INPUT),
                    WaitUntil.the(CategoryPage.FILTER_BUTTON, isPresent()).forNoMoreThan(50).seconds(),
                    Click.on(SUBMIT_FILTER_BUTTON),
                    WaitUntil.the(SUBMIT_FILTER_BUTTON, isNotPresent()),
                    Ensure.that(CategoryPage.APPLIED_FILTER_BOX).isDisplayed(),
                    RefreshPage.refresh(),
                    WaitUntil.the(NEWSLETTER_POPUP, isPresent()).forNoMoreThan(10).seconds(),
                    Click.on(NEWSLETTER_POPUP_CLOSE_BUTTON),
                    Ensure.that(CategoryPage.APPLIED_FILTER_BOX).isDisplayed(),
                    WaitUntil.the(CategoryPage.CATEGORY_HEADER, isPresent()),
                    WaitUntil.the(PAGINATION_ARROW, isClickable()),
                    Click.on(PAGINATION_ARROW),
                    WaitUntil.the(CATEGORY_HEADER, isPresent()),
                    Ensure.that(CategoryPage.APPLIED_FILTER_BOX).isDisplayed(),
                    RefreshPage.refresh(),
                    Ensure.that(APPLIED_FILTER_BOX).isDisplayed(),
                    Open.productPageByPositionRandomly(),
                    MoveMouseDown.move(),
                    ReturnToPreviousPage.goToPreviousPage(),
                    WaitUntil.the(FILTER_BUTTONS, isPresent())
            );
            theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), Matchers.containsString("p=2")));
            theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), Matchers.containsString("capacity-10")));
        }

                                                          /*WYSOKOŚĆ*/


        if (filterName.contains("Wysokość")){
            actor.attemptsTo(
                    Click.on(ALL_FILTERS_BUTTON),
                    ClickFilterButton.number(9),
                    WaitUntil.the(CategoryPage.PRICE_FILTER_INPUT, isPresent()).forNoMoreThan(50).seconds(),
                    Clear.field(CategoryPage.PRICE_FILTER_INPUT),
                    WaitUntil.the(CategoryPage.PRICE_FILTER_INPUT, isClickable()),
                    SendKeys.of("10").into(CategoryPage.PRICE_FILTER_INPUT),
                    WaitUntil.the(CategoryPage.FILTER_BUTTON, isPresent()).forNoMoreThan(50).seconds(),
                    Click.on(SUBMIT_FILTER_BUTTON),
                    WaitUntil.the(SUBMIT_FILTER_BUTTON, isNotPresent()),
                    Ensure.that(CategoryPage.APPLIED_FILTER_BOX).isDisplayed(),
                    RefreshPage.refresh(),
                    WaitUntil.the(NEWSLETTER_POPUP, isPresent()).forNoMoreThan(10).seconds(),
                    Click.on(NEWSLETTER_POPUP_CLOSE_BUTTON),
                    Ensure.that(CategoryPage.APPLIED_FILTER_BOX).isDisplayed(),
                    WaitUntil.the(CategoryPage.CATEGORY_HEADER, isPresent()),
                    WaitUntil.the(PAGINATION_ARROW, isClickable()),
                    Click.on(PAGINATION_ARROW),
                    WaitUntil.the(CATEGORY_HEADER, isPresent()),
                    Ensure.that(CategoryPage.APPLIED_FILTER_BOX).isDisplayed(),
                    RefreshPage.refresh(),
                    Ensure.that(APPLIED_FILTER_BOX).isDisplayed(),
                    Open.productPageByPositionRandomly(),
                    MoveMouseDown.move(),
                    ReturnToPreviousPage.goToPreviousPage(),
                    WaitUntil.the(FILTER_BUTTONS, isPresent())
            );
            theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), Matchers.containsString("p=2")));
            theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), Matchers.containsString("height-10")));

        }

                                                       /*SZERKOŚĆ*/


        if (filterName.contains("Szerkość")){
            actor.attemptsTo(
                    Click.on(ALL_FILTERS_BUTTON),
                    ClickFilterButton.number(10),
                    WaitUntil.the(CategoryPage.PRICE_FILTER_INPUT, isPresent()).forNoMoreThan(50).seconds(),
                    Clear.field(CategoryPage.PRICE_FILTER_INPUT),
                    WaitUntil.the(CategoryPage.PRICE_FILTER_INPUT, isClickable()),
                    SendKeys.of("10").into(CategoryPage.PRICE_FILTER_INPUT),
                    WaitUntil.the(CategoryPage.FILTER_BUTTON, isPresent()).forNoMoreThan(50).seconds(),
                    Click.on(SUBMIT_FILTER_BUTTON),
                    WaitUntil.the(SUBMIT_FILTER_BUTTON, isNotPresent()),
                    Ensure.that(CategoryPage.APPLIED_FILTER_BOX).isDisplayed(),
                    RefreshPage.refresh(),
                    WaitUntil.the(NEWSLETTER_POPUP, isPresent()).forNoMoreThan(10).seconds(),
                    Click.on(NEWSLETTER_POPUP_CLOSE_BUTTON),
                    Ensure.that(CategoryPage.APPLIED_FILTER_BOX).isDisplayed(),
                    WaitUntil.the(CategoryPage.CATEGORY_HEADER, isPresent()),
                    WaitUntil.the(PAGINATION_ARROW, isClickable()),
                    Click.on(PAGINATION_ARROW),
                    WaitUntil.the(CATEGORY_HEADER, isPresent()),
                    Ensure.that(CategoryPage.APPLIED_FILTER_BOX).isDisplayed(),
                    RefreshPage.refresh(),
                    Ensure.that(APPLIED_FILTER_BOX).isDisplayed(),
                    Open.productPageByPositionRandomly(),
                    MoveMouseDown.move(),
                    ReturnToPreviousPage.goToPreviousPage(),
                    WaitUntil.the(FILTER_BUTTONS, isPresent())
            );
            theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), Matchers.containsString("p=2")));
            theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), Matchers.containsString("width-10")));

        }

                                                          /*IRLOŚĆ OSÓB*/


        if (filterName.contains("Irlość_osób")){
            actor.attemptsTo(
                    Click.on(ALL_FILTERS_BUTTON),
                    ClickFilterButton.number(12)
            );
            filter = FilterName.filterName().answeredBy(theActorInTheSpotlight());
            selectedFilter = filter.replace("(","").replaceAll("[0-9]", "").replace(")","").replaceAll("\\s+", "");
            url_filter = StringUtils.stripAccents(selectedFilter);
            numberOfProductsInFilter = filter.replace("(","").replaceAll("[^\\d.]", "").replace(")","").replaceAll("\\/","").replaceAll("\\s+", "").substring(1);

            System.out.println("The selected filter name: " + selectedFilter);
            System.out.println("Filter name in url: " + url_filter.toLowerCase(Locale.ROOT));
            System.out.println("Number of products in the selected filter: " + numberOfProductsInFilter);

            actor.attemptsTo(
                    Click.on(SUBMIT_FILTER_BUTTON),
                    WaitUntil.the(SUBMIT_FILTER_BUTTON, isNotPresent()),
                    Ensure.that(CategoryPage.APPLIED_FILTER_BOX).isDisplayed(),
                    RefreshPage.refresh(),
                    WaitUntil.the(NEWSLETTER_POPUP, isPresent()).forNoMoreThan(10).seconds(),
                    Click.on(NEWSLETTER_POPUP_CLOSE_BUTTON),
                    Ensure.that(CategoryPage.APPLIED_FILTER_BOX).isDisplayed()
            );
            if (PAGINATION_ARROW.resolveFor(actor).isPresent()){
                actor.attemptsTo(
                        Ensure.that(CategoryPage.APPLIED_FILTER_BOX).isDisplayed(),
                        WaitUntil.the(CategoryPage.CATEGORY_HEADER, isPresent()),
                        WaitUntil.the(PAGINATION_ARROW, isClickable()),
                        Click.on(PAGINATION_ARROW),
                        WaitUntil.the(CATEGORY_HEADER, isPresent()),
                        Ensure.that(CategoryPage.APPLIED_FILTER_BOX).isDisplayed(),
                        RefreshPage.refresh(),
                        Ensure.that(CategoryPage.APPLIED_FILTER_BOX).isDisplayed()
                );
                theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), Matchers.containsString("p=2")));
            }
            actor.attemptsTo(
                    Open.productPageByPositionRandomly(),
                    MoveMouseDown.move(),
                    ReturnToPreviousPage.goToPreviousPage(),
                    WaitUntil.the(FILTER_BUTTONS, isPresent())
            );

            theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), containsString(url_filter.toLowerCase(Locale.ROOT))));
            theActorInTheSpotlight().should(seeThat(CategoryHeader.valueIs(), containsString(selectedFilter)));
            theActorInTheSpotlight().should(seeThat(CategoryHeader.valueIs(), containsString(numberOfProductsInFilter)));

        }

                                                              /*ZASTOSOWANIE*/

        if (filterName.contains("Zastosowanie")) {
            actor.attemptsTo(
                    Click.on(ALL_FILTERS_BUTTON),
                    ClickFilterButton.number(13));
            filter = FilterName.filterName().answeredBy(theActorInTheSpotlight());
            selectedFilter = filter.replace("(","").replaceAll("[0-9]", "").replace(")","").replaceAll("\\s+", "");
            url_filter = StringUtils.stripAccents(selectedFilter);
            numberOfProductsInFilter = filter.replace("(","").replaceAll("[^\\d.]", "").replace(")","").replaceAll("\\/","").replaceAll("\\s+", "");

            System.out.println("The selected filter name: " + selectedFilter);
            System.out.println("Filter name in url: " + url_filter.toLowerCase(Locale.ROOT));
            System.out.println("Number of products in the selected filter: " + numberOfProductsInFilter);
            actor.attemptsTo(
                    Click.on(SUBMIT_FILTER_BUTTON),
                    WaitUntil.the(SUBMIT_FILTER_BUTTON, isNotPresent()),
                    Ensure.that(CategoryPage.APPLIED_FILTER_BOX).isDisplayed(),
                    RefreshPage.refresh(),
                    WaitUntil.the(NEWSLETTER_POPUP, isPresent()).forNoMoreThan(10).seconds(),
                    Click.on(NEWSLETTER_POPUP_CLOSE_BUTTON),
                    WaitUntil.the(CATEGORY_HEADER, isPresent()),
                    Ensure.that(CategoryPage.APPLIED_FILTER_BOX).isDisplayed()
            );
            theActorInTheSpotlight().should(seeThat(CurrentUrl.information(), containsString(url_filter.toLowerCase(Locale.ROOT))));
            theActorInTheSpotlight().should(seeThat(CategoryHeader.valueIs(), containsString(selectedFilter)));
            theActorInTheSpotlight().should(seeThat(CategoryHeader.valueIs(), containsString(numberOfProductsInFilter)));
            actor.attemptsTo(
                    Open.productPageByPositionRandomly(),
                    MoveMouseDown.move(),
                    ReturnToPreviousPage.goToPreviousPage(),
                    WaitUntil.the(FILTER_BUTTONS, isPresent())
            );
        }

    }

    public static ApplyFilters byFilterName(String filterName){
        return Instrumented.instanceOf(ApplyFilters.class).withProperties(filterName);
    }
}
