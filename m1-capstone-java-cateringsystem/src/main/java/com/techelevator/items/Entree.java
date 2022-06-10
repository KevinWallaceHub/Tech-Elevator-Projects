package com.techelevator.items;

public class Entree extends CateringItem{

    private String onScreenReminder = "Did you remember desert?";
    private String itemType = "Entree";

    public Entree(String productCode, String description, int quantity, float price) {
        super(productCode, description, quantity, price);
    }

}
