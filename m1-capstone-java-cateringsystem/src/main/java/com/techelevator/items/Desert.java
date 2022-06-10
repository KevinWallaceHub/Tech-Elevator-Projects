package com.techelevator.items;

public class Desert extends CateringItem{

    private String onScreenReminder = "Coffee goes with desert";
    private String itemType = "Desert";

    public Desert(String productCode, String description, int quantity, float price) {
        super(productCode, description, quantity, price);
    }

    @Override
    public String getOnScreenReminder() {
        return onScreenReminder;
    }

    @Override
    public String getItemType() {
        return itemType;
    }

}
