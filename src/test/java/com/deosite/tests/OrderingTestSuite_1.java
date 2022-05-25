package com.deosite.tests;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = {"src/test/resources/features/creating_orders/add_product_to_cart_and_order_1.feature"},
        glue = {"com.deosite"}
)
public class OrderingTestSuite_1 {
}

