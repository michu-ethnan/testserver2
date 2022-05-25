package com.deosite.tests.actions;

import com.deosite.tests.tasks.mainMenu.ClickCategory;
import net.serenitybdd.core.steps.Instrumented;

public class Hover {

    public static ClickCategory categoryNumber(int number) {
        return Instrumented.instanceOf(ClickCategory.class).withProperties(number);
    }
}
