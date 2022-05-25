package com.deosite.tests.model.minicart;

public class QuanityChange implements ChangeQuantity {

    private final String numberOfProducts;

    public QuanityChange(
            String numberOfProducts
    ){
        this.numberOfProducts = numberOfProducts;
    }

    public String changeQuantity() {
        return numberOfProducts;
    }
}
