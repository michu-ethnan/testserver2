package com.deosite.tests.tasks.product;

import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AddProduct {

    public static Task toCart() {
        return instrumented(AddToCart.class);
    }
}
