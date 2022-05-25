package com.deosite.tests.pages;

import net.serenitybdd.screenplay.targets.Target;

public class PaymentPage {

    public static Target CREATE_ACCOUNT_CHECKBOX = Target.the("Create account checkbox").locatedBy("//div[@name='shouldCreateAccount']");
    public static Target AGREEMENT_CHECKBOX = Target.the("Agreement checkbox").locatedBy("(//div[@data-test='agreement'])[2]");
    public static Target AGREEMENT_CHECKBOX_LOGGED_IN = Target.the("Agreement checkbox logged in").locatedBy("//*[@id=\"__app__\"]/div[2]/div[3]/div/div/div[1]/div/div/div/div[1]/form/div[4]/div/div/div/div[1]/div/div");
    public static Target CARD_PAYMENT_CHECKBOX = Target.the("Card payment checkbox").locatedBy("//*[@id=\"__app__\"]/div/div[3]/div/div[1]/div/div/div/div[1]/form/div[4]/div/div/div[1]]");
    public static Target TRANSFER_PAYMENT_CHECKBOX = Target.the("Transfer payment checkbox").locatedBy("//div[@data-test='banktransfer']");
    public static Target TRANSFER_PAYMENT_CHECKBOX_AFTER_LOGIN =
            Target.the("Transfer payment checkbox after login").locatedBy("//div[@data-test='banktransfer']");
    public static Target PICKUP_PAYMENT_CHECKBOX = Target.the("Pickup payment checkbox").locatedBy("//div[@data-test='cashondelivery']");
    public static Target PICKUP_PAYMENT_CHECKBOX_AFTER_LOGIN =
            Target.the("Pickup payment checkbox after login").locatedBy("//div[@data-test='cashondelivery']");
    public static Target BACK_TO_CHECKOUT_BUTTON = Target.the("Back to checkout button").locatedBy("//button[@data" +
            "-test" +
            "='back-to-checkout']");
    public static Target PLACE_ORDER_BUTTON = Target.the("Place order button").locatedBy("//button[@data-test='submit" +
            "-order" +
            "']");
    public static Target ACCOUNT_PASSWORD_INPUT = Target.the("Account password input").locatedBy("//input[@name='accountPassword']");
    public static Target ACCOUNT_AGREEMENT_CHECKBOX = Target.the("Account agreement checkbox").locatedBy("//div[@name" +
            "='accountAgreement']");
    public static Target COUPON_CODE_BUTTON = Target.the("Coupon code button").locatedBy("//div[@data-test='discount" +
            "-code-have']");
    public static Target COUPON_CODE_BUTTON_AFTER_LOGIN = Target.the("Coupon code button after login").locatedBy(
            "//div[@data-test='have-discount-code']");
    public static Target COUPON_CODE_INPUT = Target.the("Coupon code input").locatedBy("//input[@data-test='discount" +
            "-code-input']");
    public static Target COUPON_CODE_INPUT_AFTER_LOGIN = Target.the("Coupon code input after login").locatedBy(
            "//*[@id=\"__app__\"]/div/div[3]/div/div/div[1]/div/div/div/div[2]/div[2]/div[4]/div/div/label/input");
    public static Target DELETE_COUPON_CODE_BUTTON = Target.the("Delete coupon code button").locatedBy("//button" +
            "[@data-test='discount-code-delete']");
    public static Target DELETE_COUPON_CODE_BUTTON_AFTER_LOGIN =
            Target.the("Delete coupon code button after login").locatedBy("//*[@id=\"__app__\"]/div/div[3]/div/div" +
                    "/div" +
                    "[1]/div/div/div/div[2]/div[2]/div[4]/div/div/div/button");
    public static Target DELETE_PRODUCT_BUTTON_ON_PAYMENT_PAGE =
            Target.the("Delete product button on payment page").locatedBy("(//button[@data-test='delete-product-minicart'])[6]");
    public static Target CART_VALUE = Target.the("Cart value on payment page").locatedBy("(//span[@data-test='total-checkout'])[7]");
    public static Target SHIPPING_PRICE = Target.the("Shipping price on payment page").locatedBy("(//span[@data-test='total-checkout'])[6]");
    public static Target TOTAL_SUM = Target.the("Total sum on payment page").locatedBy("(//span[@data-test='total-checkout'])[8]");
    public static Target EPOINTS_BUTTON = Target.the("Epoints button").locatedBy("//div[@data-test='epoints-have']");
    public static Target EPOINTS_INPUT = Target.the("Epoints input").locatedBy("//input[@data-test='epoints-input']");
    public static Target APPLY_EPOINTS_BUTTON = Target.the("Apply epoints button").locatedBy("//button[@data-test='epoints-confirm']");
    public static Target DELETE_EPOINTS_BUTTON = Target.the("Delete epoints button").locatedBy("//*[@id=\"__app__\"]/div[2]/div[3]/div/div/div[1]/div/div/div/div[2]/div[2]/button");
    public static Target FREE_DELIVERY_NOTIFICATION = Target.the("Free delivery notification").locatedBy("//div[@data" +
            "-test='free']");
    public static Target COUPON_CODE_DISCOUNT = Target.the("Coupon code discount").locatedBy("//*[@id=\"__app__" +
            "\"]/div/div[3]/div/div/div[1]/div/div/div/div[2]/div[2]/div[4]/div[3]/div[2]/span/span[1]");
    public static Target EPOINTS_DISCOUNT = Target.the("Epoints discount").locatedBy("//*[@id=\"__app__\"]/div[2]/div[3]/div/div/div[1]/div/div/div/div[2]/div[2]/button");
}