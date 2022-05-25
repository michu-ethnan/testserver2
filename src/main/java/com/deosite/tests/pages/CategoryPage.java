package com.deosite.tests.pages;

import net.serenitybdd.screenplay.targets.Target;

public class CategoryPage {

    public static Target PAGINATION_SELECT = Target.the("Pagination select").locatedBy("(//div[@data-test='quantity-picker-small'])[1]");
    public static Target PAGINATION_NUMBER_LIST = Target.the("Oagination number list").locatedBy("//*[@id=\"__layers__\"]//div[@option]");
    public static Target PAGINATION_INPUT = Target.the("Pagination input").locatedBy("//*[@id=\"__app__\"]/div[2]/div" +
            "[3]/div/div[2]/div/div/div[2]/div[1]/div/div[2]/div/div[2]/div/span/div[1]/div/div/input");
    public static Target PAGINATION_ARROW = Target.the("Pagination arrow").locatedBy("(//button[@data-test='pagination-next'])[1]");
    public static Target PAGINATION_ARROW_BOTTOM = Target.the("Pagination arrow bottom").locatedBy("(//button[@data-test='pagination-next'])[2]");
    public static Target CATEGORY_HEADER = Target.the("Category header").locatedBy("(//*[@id=\"__app__\"]//h3)[1]");
    public static Target COLLECTION_BANNERS = Target.the("Collection banners").locatedBy("//div[@class='css-11322cg']");
    public static Target FILTER_BUTTONS = Target.the("Filter buttons").locatedBy("//div[@data-test='filters-container-desktop']//button");
    public static Target FILTER_CHECKBOXES = Target.the("Filter checkboxes").locatedBy("//*[@id=\"__layers__\"]//div[@option]/div/div[1]");
    public static Target SUBMIT_FILTER_BUTTON = Target.the("Submit filter button").locatedBy("//button[@data-test='apply-filter']");
    public static Target SORTING_BUTTON = Target.the("Sorting button").locatedBy("//button[@data-test='sorting-button']");
    public static Target SORTING_OPTIONS = Target.the("Sorting options").locatedBy("//*[@id=\"__layers__\"]//div[@option]");
    public static Target FILTERS_LIST = Target.the("List of filters").locatedBy("//button[@class='css-1jppxge']");
    public static Target PRICE_FILTER_INPUT = Target.the("Price filter input").locatedBy("(//*[@id=\"__layers__\"]//label/input)[1]");
    public static Target FILTER_BUTTON = Target.the("Filter button").locatedBy("//button[@data-test='apply-filter']");
    public static Target APPLIED_FILTER_BOX = Target.the("Applied filter box").locatedBy("//button[@class='css-1491jk5']");
    public static Target CLEAR_FILTERS_BUTTON = Target.the("Clear filters button").locatedBy("//button[@data-test='clear-filter']");
    public static Target CATEGORY_MENU_BANNER = Target.the("Pagination arrow").locatedBy("//div[@class='css-1h3hv7h']");
    public static Target SIDE_MENU = Target.the("Side menu").locatedBy("//ul[@class='css-1voqx6l']");
    public static Target PAGINATION_SELECT_BOTTOM = Target.the("Pagination select bottom").locatedBy("(//div[@data-test='quantity-picker-small'])[2]");

    public static Target INSPIRATIONS_BANNER_1 = Target.the("Inspirations").locatedBy("(//div[@class=\"css-9s6v9e\"]/div)[1]");

    public static Target INSPIRATIONS_BANNER_2 = Target.the("Inspirations").locatedBy("(//div[@class='css-9s6v9e']/div)[2]");

    public static Target INSPIRATIONS_BANNER_3 = Target.the("Inspirations").locatedBy("(//div[@class='css-9s6v9e']/div)[3]");

    public static Target INSPIRATIONS_BANNER_4 = Target.the("Inspirations").locatedBy("(//div[@class='css-9s6v9e']/div)[4]");

    public static Target INSPIRATIONS_BANNER_5 = Target.the("Inspirations").locatedBy("(//div[@class='css-9s6v9e']/div)[5]");

    public static Target INSPIRATIONS_BANNER_6 = Target.the("Inspirations").locatedBy("(//div[@class='css-9s6v9e']/div)[6]");

    public static Target INSPIRATIONS_BANNER_7 = Target.the("Inspirations").locatedBy("(//div[@class='css-9s6v9e']/div)[7]");

    public static Target INSPIRATIONS_BANNER_8 = Target.the("Inspirations").locatedBy("(//div[@class='css-9s6v9e']/div)[8]");
    public static Target INSPIRATIONS_BANNER_9 = Target.the("Inspirations").locatedBy("(//div[@class='css-9s6v9e']/div)[9]");


    public static Target GO_TO_MAIN_PAGE_BUTTON = Target.the("Go to main page button").locatedBy("//div[@class=\"css-1c8xiaf\"]");
    public static Target INSPIRATION_LIST = Target.the("Inspirations list").locatedBy("//div[@class=\"css-u8jc59\"]//..//a");

    public static Target PROMOTION_LIST = Target.the("Inspirations list").locatedBy("//div[@class=\"css-1pq9bkx\"]//..//a");

    public static Target FIRST_PROMOTION_BANNER = Target.the("First promotion banner").locatedBy("//*[@id=\"__app__\"]/div[2]/div[3]/div/div[2]/div/div/div[2]/div/div[1]/div");
    public static Target SECOND_PROMOTION_BANNER = Target.the("Second promotion banner").locatedBy("//*[@id=\"__app__\"]/div[2]/div[3]/div/div[2]/div/div/div[2]/div/div[2]/div/div[1]");
    public static Target THIRD_PROMOTION_BANNER = Target.the("Third promotion banner").locatedBy("//*[@id=\"__app__\"]/div[2]/div[3]/div/div[2]/div/div/div[2]/div/div[3]/div");
    public static Target FOURTH_PROMOTION_BANNER = Target.the("Fourth promotion banner").locatedBy("//*[@id=\"__app__\"]/div[2]/div[3]/div/div[2]/div/div/div[2]/div/div[4]/div");

}