package com.techelevator.items;

public class Beverage extends CateringItem{

    private String onScreenReminder = "Don't forget ice!";
    private String itemType = "Beverage";

    public Beverage(String productCode, String description, int quantity, float price) {
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
