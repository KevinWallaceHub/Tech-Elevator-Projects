package com.techelevator.items;

public class Appetizer extends CateringItem{


    private String itemType = "Appetizer";
    private String onScreenReminder = "You might need extra plates";

    public Appetizer(String productCode, String description, int quantity, float price) {
        super(productCode, description, quantity, price);
    }

    @Override
    public String getItemType() {
        return itemType;
    }

    @Override
    public String getOnScreenReminder() {
        return onScreenReminder;
    }

}
