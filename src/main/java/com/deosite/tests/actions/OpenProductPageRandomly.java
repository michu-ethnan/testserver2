package com.deosite.tests.actions;

import com.deosite.tests.pages.ProductPage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import java.util.List;
import java.util.Random;

import static com.deosite.tests.pages.SearchPage.PRODUCTS_TITLE;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class OpenProductPageRandomly implements Interaction {




    @Override
    @Step("{0} opens product page")
    public <T extends Actor> void performAs(T actor) {


        int size = PRODUCTS_TITLE.resolveAllFor(actor).size();
        List<WebElementFacade> products = PRODUCTS_TITLE.resolveAllFor(actor);
            Random r = new Random();
            int i = r.nextInt(products.size());
            products.get(i).click();
actor.attemptsTo(
        WaitUntil.the(ProductPage.PRODUCT_NAME, isVisible())
);


    }
}
