package com.deosite.tests.pages;

import net.serenitybdd.screenplay.targets.Target;

public class CheckoutPage {

    public static Target DELIVERY_TYPE_COURIER = Target.the("Delivery type courier").locatedBy("//div[@data-test='bestway']");
    public static Target DELIVERY_TYPE_PICKUP_POINT = Target.the("Delivery type pickup point").locatedBy("//div[@data-test='shipping_pickup_point']");

    public static Target PICKUP_POINT_SELECT = Target.the("Pickup point select").locatedBy("//*[@id=\"__app__\"]/div[2]/div[3]/div/div[2]/div/div/div/div[1]/form/div[2]/div/div/div[2]/div[2]/div/div/div/div/div/div");
    public static Target BILLING_ADDRESS_SELECT = Target.the("Billing address select").locatedBy("//*[@id=\"__app__\"]/div[2]/div[3]/div/div[2]/div/div/div/div[1]/form/div[6]/div/div/div/div");

    public static Target SHIPPING_ADDRESS_CHECKBOX = Target.the("Shipping address checkbox").locatedBy("(//div[@name='shippingAddressSameAsBilling'])[2]");
    public static Target BILLING_ADDRESS_LIST = Target.the("Billing address list").locatedBy("//*[@id=\"__layers__\"]//div[@option]");
    public static Target SHIPPING_ADDRESS_SELECT = Target.the("Shipping address select").locatedBy("//*[@id=\"__app__\"]/div[2]/div[3]/div/div[2]/div/div/div/div[1]/form/div[10]/div[1]/div/div/div/div/div/div");
    public static Target SHIPPING_ADDRESS_LIST = Target.the("Shipping address list").locatedBy("//*[@id=\"__layers__\"]//div[@option]");

    public static Target EMAIL_INPUT = Target.the("Email input").locatedBy("//input[@name='email']");

    public static Target AS_COMPANY_BILLING_CHECKBOX = Target.the("Buy as a company billing checkbox").locatedBy("//div[@name='billingAddress.isCompany']");
    public static Target COMPANY_NAME_BILLING_INPUT = Target.the("Company name billing input").locatedBy("//input[@name='billingAddress.companyName']");
    public static Target NIP_BILLING_INPUT = Target.the("NIP billing input").locatedBy("//input[@name='billingAddress.vatId']");
    public static Target NAME_BILLING_INPUT = Target.the("Name billing input").locatedBy("//input[@name='billingAddress.firstName']");
    public static Target SURNAME_BILLING_INPUT = Target.the("Surname billing input").locatedBy("//input[@name='billingAddress.lastName']");
    public static Target STREET_BILLING_INPUT = Target.the("Street billing input").locatedBy("//input[@name='billingAddress.street']");
    public static Target CITY_BILLING_INPUT = Target.the("City billing input").locatedBy("//input[@name='billingAddress.city']");
    public static Target COUNTRY_BILLING_INPUT = Target.the("Country billing input").locatedBy("//*[@id=\"__app__\"]/div[2]/div[3]/div/div[2]/div/div/div/div[1]/form/div[6]/div/div[6]/div/div/div/div/div");
    public  static Target COUNTRY_BILLING_INPUT_LIST = Target.the("Country billing input list").locatedBy("//*[@id=\"__layers__\"]//div[@option]");

    public static Target POST_CODE_BILLING_INPUT = Target.the("Post Code billing input").locatedBy("//input[@name='billingAddress.postalCode']");
    public static Target NUMBER_BILLING_INPUT = Target.the("Number billing input").locatedBy("//input[@name='billingAddress.phone']");

    public static Target SHIPPING_ADDRESS_IS_THE_SAME_CHECKBOX = Target.the("Shipping address is the same as billing checkbox").locatedBy("//div[@name='shippingAddressSameAsBilling']");

    public static Target AS_COMPANY_SHIPPING_CHECKBOX = Target.the("Buy as a company shipping checkbox").locatedBy("//div[@name='shippingAddress.isCompany']");
    public static Target COMPANY_NAME_SHIPPING_INPUT = Target.the("Company name shipping input").locatedBy("//input[@name='shippingAddress.companyName']");
    public static Target NAME_SHIPPING_INPUT = Target.the("Name shipping input").locatedBy("//input[@name='shippingAddress.firstName']");
    public static Target SURNAME_SHIPPING_INPUT = Target.the("Surname shipping input").locatedBy("//input[@name='shippingAddress.lastName']");
    public static Target STREET_SHIPPING_INPUT = Target.the("Street shipping input").locatedBy("//input[@name='shippingAddress.street']");
    public static Target CITY_SHIPPING_INPUT = Target.the("City shipping input").locatedBy("//input[@name='shippingAddress.city']");
    public static Target COUNTRY_SHIPPING_INPUT = Target.the("Country shipping input").locatedBy("//select[@name='shippingAddress.country']");
    public static Target POST_CODE_SHIPPING_INPUT = Target.the("Post Code shipping input").locatedBy("//input[@name='shippingAddress.postalCode']");
    public static Target NUMBER_SHIPPING_INPUT = Target.the("Number shipping input").locatedBy("//input[@name='shippingAddress.phone']");

    public static Target CONTINUE_SHOPPING_BUTTON = Target.the("Continue shopping button").locatedBy("//div[@class='css-yemyw3']");
    public static Target SUBMIT_BUTTON = Target.the("Submit button").locatedBy("//button[@data-test='go-to-payment']");
    public static Target SUBMIT_BUTTON_AFTER_LOGIN = Target.the("Submit button after login").locatedBy("//*[@id=\"__app__\"]/div/div[3]/div/div[1]/div/div/div/div[1]/form/div[11]/div[2]/button");
    public static Target SUBMIT_BUTTON_PICKUP_DELIVERY_SELECTED = Target.the("Submit button after login with " +
            "selected " +
            "pickup delivery").locatedBy("/html/body/div[1]/div[1]/div/div[3]/div/div[1]/div/div/div/div[1]/form/div[8]/div[2]/button");
    public static Target COUPON_CODE_INPUT = Target.the("Coupon code input").locatedBy("//input[@data-test='discount" +
            "-code-input']");
    public static Target COUPON_CODE_BUTTON = Target.the("Coupon code button").locatedBy("//div[@data-test='discount" +
            "-code-have']");
    public static Target COUPON_CODE_BUTTON_AFTER_LOGIN = Target.the("Coupon code button after login").locatedBy(
            "//*[@id=\"__app__\"]/div/div[3]/div/div[1]/div/div/div/div[2]/div[2]/div[2]/div");
    public static Target COUPON_CODE_INPUT_AFTER_LOGIN = Target.the("Coupon code input after login").locatedBy(
            "//*[@id=\"__app__\"]/div/div[3]/div/div[1]/div/div/div/div[2]/div[2]/div[2]/div/div/label/input");
    public static Target APPLY_COUPON_CODE_BUTTON = Target.the("Apply coupon code button").locatedBy("//button[@data-test='discount-code-confirm']");
    public static Target DELETE_COUPON_CODE_BUTTON = Target.the("Delete coupon code button").locatedBy("//button" +
            "[@data-test='discount-code-delete']");

    public static Target DISCOUNT_PRICE_HEADER = Target.the("Discount price header").locatedBy(" ((//div[@data-test='subtotal-checkout'])[2]/..//div)[5]");

    public static Target DISCOUNT_PRICE = Target.the("Discount Price").locatedBy("(//span[@data-test='total-checkout'])[8]");



    public static Target DELETE_PRODUCT_BUTTON_AFTER_COUPON_CODE =
            Target.the("Delete product button at checkout").locatedBy("(//button[@data-test='delete-product-minicart'])[2]");

    public static Target QUANTITY_PICKER_CHECKOUT = Target.the("Quantity picker").locatedBy("(//div[@data-test='quantity-picker-small'])[2]");


    public static Target DELETE_COUPON_CODE_BUTTON_AFTER_LOGIN = Target.the("Delete coupon code after login").locatedBy(
            "//*[@id=\"__app__\"]/div/div[3]/div/div[1]/div/div/div/div[2]/div[2]/div[2]/div/div/div/button");
    public static Target DELETE_PRODUCT_BUTTON_AT_CHECKOUT =
            Target.the("Delete product button at checkout").locatedBy("(//button[@data-test='delete-product-minicart'])[6]");
    public static Target SHIPPING_VALUE = Target.the("Shipping value").locatedBy("(//span[@data-test='total-checkout'])[7]");
    public static Target TOTAL_SUM_AT_CHECKOUT = Target.the("Total sum at checkout").locatedBy("(//span[@data-test='total-checkout'])[9]");
    public static Target CART_VALUE = Target.the("Cart value").locatedBy("(//span[@data-test='total-checkout'])[8]");
    public static Target LOGIN_LINK = Target.the("Login link").locatedBy("//*[@id=\"__app__\"]/div[2]/div[3]/div/div[1]/div/div/div/div[1]/form/div[4]/div/div[2]/p/a");
    public static Target PICKUP_LOCATION_LIST = Target.the("pickup location list").locatedBy("//*[@id=\"__layers__\"]//div[@option]");
}
