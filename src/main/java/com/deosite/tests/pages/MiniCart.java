package com.deosite.tests.pages;

import net.serenitybdd.screenplay.targets.Target;

public class MiniCart {

    public static Target PRODUCTS = Target.the("Products in mini cart").locatedBy("//div[@data-test='product-mini-cart]/div/a");
    public static Target GO_TO_CHECKOUT_BUTTON = Target.the("Go to checkout button").locatedBy("//button[@data-test='go-to-checkout']");
    public static Target DELETE_PRODUCT_BUTTON = Target.the("Delete product button").locatedBy("//button[@data-test='delete-product-minicart']");
    public static Target EMPTY_CART_MESSAGE = Target.the("Empty cart message").locatedBy("//*[@id=\"__layers__\"]/div" +
            "/div[2]/div/div[3]/div/div/div/div[1]/div[2]/div/span[2]");
    public static Target MINICART_BUTTON = Target.the("Minicart button").locatedBy("(//div[@data-test='mini-cart'])[1]");
    public static Target MINICART_BUTTON_LOGGED_IN = Target.the("Mini cart button logged in").locatedBy("//*[@id=\"__menubarsticky__\"]/div/div/div[3]/div/div[1]/header/div/div/div/div/div[4]/div[2]/button");
    public static Target QUANTITY_PICKER = Target.the("Quantity picker").locatedBy("//div[@data-test='quantity-picker-small']");
    public static Target QUANTITY_AMOUNT = Target.the("Quantity amount").locatedBy("//*[@id=\"__layers__\"]//div[@option]");
    public static Target MINICART_HEADER = Target.the("Minicart header").locatedBy("//*[@id=\"__layers__\"]/div/div[2" +
            "]/div/div[3]/div/div/div/div[1]/div[2]/div/span");
    public static Target CLOSE_CART_BUTTON = Target.the("Close cart button").locatedBy("(//div[@id=\"__layers__\"]//button[1])[1]");
    public static Target TOTAL_SUM = Target.the("Total sum in minicart").locatedBy("//*[@id=\"__layers__\"]/div/div[2]/div/div[3]/div/div/div/div[1]/div[2]/div/div/div[4]/div/div/div[2]/span/span[1]");
    public static Target MINICART_LOADER = Target.the("Minicart loader").locatedBy("//*[@id=\"__layers__\"]/div/div[2" +
            "]/div/div[3]/div/div/div/div[1]/div[3]/button/div[3]/div/div/div");
    public static Target PRODUCT_PRICE_LIST = Target.the("Product price list").locatedBy("//div[@data-test='price-product-row']");
    public static Target PRODUCT_NAME_IN_MINICART = Target.the("Product name in minicart").locatedBy("(//div[@data-test=\"product-mini-cart\"]//a[@title]//div)[4]");
    public static Target MINICART_BUTTON_TEXT = Target.the("Minicart button text").locatedBy("//*[@id" +
            "=\"__menubarsticky__\"]/div/div/div[3]/div/div[1]/header/div/div/div/div/div[4]/div[2]/button/div[2]/span");
}
