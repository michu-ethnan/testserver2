package com.deosite.tests.tasks.categoryPage;

import com.deosite.tests.tasks.mainMenu.ClickCategory;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;


public class SelectCategory implements Task {

    private final String categoryName;
    public SelectCategory(String categoryName){
        this.categoryName = categoryName;
    }
    @Override
    @Step("{0} selects #categoryName")
    public <T extends Actor> void performAs(T actor) {

        if (categoryName.contains("Ogród")){
            actor.attemptsTo(
                    ClickCategory.byCategoryNumber(0)
            );

        }
        if (categoryName.contains("Jadalnia")){
            actor.attemptsTo(
                   ClickCategory.byCategoryNumber(1)
            );

        }
        if (categoryName.contains("Kuchnia")){
            actor.attemptsTo(
                  ClickCategory.byCategoryNumber(2)
            );

        }
        if (categoryName.contains("ŁazienkaIgarderoba")){
            actor.attemptsTo(
                    ClickCategory.byCategoryNumber(3)
            );

        }
        if (categoryName.contains("Dekoracje")){
            actor.attemptsTo(
                 ClickCategory.byCategoryNumber(4)
            );

        }
        if (categoryName.contains("ŚwiatDziecka")){
            actor.attemptsTo(
                  ClickCategory.byCategoryNumber(5)
            );

        }
        if (categoryName.contains("Nowości")){
            actor.attemptsTo(
                    ClickCategory.byCategoryNumber(7)
            );

        }
        if (categoryName.contains("Wyprzedaż")){
            actor.attemptsTo(
                    ClickCategory.byCategoryNumber(6)
            );

        }
        if (categoryName.contains("Promocje")){
            actor.attemptsTo(
                    ClickCategory.byCategoryNumber(8)
            );}
        if (categoryName.contains("Marki")){
            actor.attemptsTo(
                    ClickCategory.byCategoryNumber(9)
            );

        }
        if (categoryName.contains("Inspiracje")){
            actor.attemptsTo(
                    ClickCategory.byCategoryNumber(10)
            );

        }

    }
    public static SelectCategory byName(String categoryName) {
        return Instrumented.instanceOf(SelectCategory.class).withProperties(categoryName);
    }
}
