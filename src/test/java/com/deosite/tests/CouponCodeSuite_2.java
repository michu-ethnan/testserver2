package com.deosite.tests;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = {"src/test/resources/features/coupon_codes_and_epoints_2"},
        glue = {"com.deosite"}
)

public class CouponCodeSuite_2 {
}
