package com.deosite.tests.actions;

import net.serenitybdd.core.steps.Instrumented;

public class Search {

    public static SearchForProducts forProductByKeyword(String keyword) {
        return Instrumented.instanceOf(SearchForProducts.class).withProperties(keyword);
    }

    public static SearchForTranslatedProducts forProductByTranslatedKeyword(String keyword) {
        return Instrumented.instanceOf(SearchForTranslatedProducts.class).withProperties(keyword);
    }
}
