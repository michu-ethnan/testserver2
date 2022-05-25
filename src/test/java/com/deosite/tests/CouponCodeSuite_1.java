package com.deosite.tests;

import io.cucumber.junit.*;
import net.serenitybdd.cucumber.*;
import org.junit.runner.*;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = {"src/test/resources/features/coupon_codes_and_epoints_1"},
        glue = {"com.deosite"}
)

public class CouponCodeSuite_1 {
}
