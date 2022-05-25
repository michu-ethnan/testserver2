package com.deosite.tests.tasks.mainMenu;

import com.deosite.tests.pages.CategoryPage;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static com.deosite.tests.pages.MainMenu.CATEGORY_LIST;
import static com.deosite.tests.pages.MainMenu.FIRST_MAIN_CATEGORY;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ClickCategory implements Interaction {

    private final int number;

    public ClickCategory(int number) {
        this.number = number;
    }

    @Override
    @Step("{0} clicks #category")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(FIRST_MAIN_CATEGORY, isClickable()).forNoMoreThan(100).seconds(),
                WaitUntil.the(CATEGORY_LIST, isEnabled()).forNoMoreThan(100).seconds(),
                WaitUntil.the(CATEGORY_LIST, isPresent()).forNoMoreThan(100).seconds(),
                Click.on(CATEGORY_LIST.resolveAllFor(actor).get(number)),
                WaitUntil.the(CategoryPage.CATEGORY_HEADER, isPresent()).forNoMoreThan(50).seconds()
                );
    }

    public static ClickCategory byCategoryNumber(int number) {
        return Instrumented.instanceOf(ClickCategory.class).withProperties(number);
    }
}
