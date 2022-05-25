package com.deosite.tests.tasks.mainMenu;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.deosite.tests.pages.MainMenu.SUBCATEGORY_LIST;

public class ClickSubcategory implements Interaction {

    private final int number;

    public ClickSubcategory(int number) {
        this.number = number;
    }

    @Override
    @Step("{0} clicks #subcategory")
    public <T extends Actor> void performAs(T actor) {
        int size = SUBCATEGORY_LIST.resolveAllFor(actor).size();
        System.out.println(size);
        List<WebElementFacade> subcategories = SUBCATEGORY_LIST.resolveAllFor(actor);
        System.out.println(subcategories);
        for (WebElement subcategory : subcategories) {
            System.out.println(subcategory);
            actor.attemptsTo(Click.on(SUBCATEGORY_LIST.resolveAllFor(actor).get(number)));
        }
    }

    public static ClickSubcategory byNumber (int number) {
        return Instrumented.instanceOf(ClickSubcategory.class).withProperties(number);
    }
}
