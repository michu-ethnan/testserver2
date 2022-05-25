package com.deosite.tests;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = {"src/test/resources/features/creating_orders/order_products_logged_in_2.feature"},
        glue = {"com.deosite"}
)
public class OrderingLoggedInSuite_2 {
}
