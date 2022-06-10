package com.techelevator.items;

/*
    This represents a single catering item in the system
 */
public abstract class CateringItem {

    private String productCode;
    private String description;
    private int quantity;
    private float price;
    private String onScreenReminder;
    private String itemType;


    public CateringItem(String productCode, String description, int quantity, float price) {
        this.productCode = productCode;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getOnScreenReminder() {
        return onScreenReminder;
    }

    public String getProductCode() {
        return productCode;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getPrice() {
        return price;
    }

    public String getItemType() {
        return itemType;
    }
}
