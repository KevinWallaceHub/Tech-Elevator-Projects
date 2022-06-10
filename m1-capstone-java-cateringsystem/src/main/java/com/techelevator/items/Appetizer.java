package com.techelevator.items;

public class Appetizer extends CateringItem{

    private String onScreenReminder = "You might need extra plates";
    private String itemType = "Appetizer";

    public Appetizer(String productCode, String description, int quantity, float price) {
        super(productCode, description, quantity, price);
    }

}
