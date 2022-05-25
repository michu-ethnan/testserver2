package com.deosite.tests.tasks.order;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Task;

public class GoToCheckout {

    public static Task withProduct(String product) {
        return Instrumented.instanceOf(CheckoutWithProduct.class).withProperties(product);
    }
}
