package com.deosite.tests.pages;

import net.serenitybdd.screenplay.targets.Target;

public class MainMenu {

    public static Target FIRST_MAIN_CATEGORY = Target.the("First Main Category").locatedBy("(//div[@data-test='main-categories'])[2]/button[1]");
    public static Target SEARCH_BAR = Target.the("Search bar").locatedBy("//input[@data-test='search-desktop']");
    public static Target MINI_CART_BUTTON = Target.the("Mini cart button").locatedBy("(//div[@data-test='mini-cart'])[1]");
    public static Target MINI_CART_BUTTON_AFTER_LOGIN = Target.the("Mini cart button after login").locatedBy("(//div[@data-test='mini-cart'])[1]");
    public static Target CATEGORY_BUTTON = Target.the("Category button").locatedBy("//div[@test-data='main-categories" +
            "']");

    public static Target CATEGORY_LIST = Target.the("Category list").locatedBy("(//div[@data-test='main-categories'])[2]/button");
    public static Target SUBCATEGORY_LIST = Target.the("Subcategory list").locatedBy("//div[@class='css-1nwe63y']/div[@class='css" +
            "-u7kr1c']");

    public static Target NEWSLETTER_POPUP = Target.the("newsletter popup").locatedBy("//*[@id=\"__layers__\"]/div/div[2]/div/div[2]/div/div/div/div/div[2]/div[1]");

    public static Target NEWSLETTER_POPUP_CLOSE_BUTTON = Target.the("newsletter popup close button").locatedBy("//*[@id=\"__layers__\"]/div/div[2]/div/div[2]/div/div/div/div/div[2]/div[1]");

    public static Target SEARCH_RESULTS_BOX = Target.the("Search results box").locatedBy("//div[@class='css-1d41y14']");
    public static Target ALL_FILTERS_BUTTON = Target.the("All filters button").locatedBy("(//div[@data-test='filters-container-desktop']//button)[15]");

    public static Target ALL_FILTERS_BUTTON_AFTER_APPLYING_FILTER = Target.the("All filters button").locatedBy("//*[@id=\"__app__\"]/div[2]/div[3]/div/div[3]/div/div[2]/div/div[1]/div/div/div[1]/button");

}

