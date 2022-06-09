package com.techelevator.items;

public class Beverage extends CateringItem{

    private String onScreenReminder = "Don't forget ice!";

    public Beverage(String productCode, String description, int quantity, float price) {
        super(productCode, description, quantity, price);
    }


}
