package com.techelevator;

import com.techelevator.items.CateringItem;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
    This class should encapsulate all the functionality of the Catering system, meaning it should
    contain all the "work"
 */
public class CateringSystem {

    private float currentAccountBalance = 0;
    private Map<String, Integer> cart = new TreeMap<>();
    private Map<String, CateringItem> inventory;

    public CateringSystem(Map<String, CateringItem> inventory) {
        this.inventory = inventory;
    }

    public CateringItem[] getInventoryArray() {

        CateringItem[] outputArray = new CateringItem[inventory.size()];

        int entryValue = 0;
        for (Map.Entry<String, CateringItem> entry : inventory.entrySet()) {
            outputArray[entryValue] = entry.getValue();
            entryValue++;
        }

        return outputArray;

    }


    public boolean addMoney(int amount) {
        if (amount > 500) {
            return false;
        }
        if (currentAccountBalance + amount > 1500) {
            return false;
        }
        currentAccountBalance += amount;

        return true;
    }

    public float getCurrentAccountBalance() {
        return currentAccountBalance;
    }

    public Map<String, CateringItem> getInventory() {
        return inventory;
    }

    public boolean isValidProductCode(String productCode) {

        return this.inventory.containsKey(productCode);
    }

    public int getQuantity(String productCode) {

        return this.inventory.get(productCode).getQuantity();
    }

    public boolean hasSufficientFunds(String productCode, int quantityRequested) {

        float unitPrice = inventory.get(productCode).getPrice();
        float totalPrice = unitPrice * quantityRequested;
        return totalPrice <= currentAccountBalance;
    }

    public void addProductToCart(int quantityRequested, String productCode) {

        CateringItem item = inventory.get(productCode);
        item.setQuantity(item.getQuantity() - quantityRequested);
        float priceOfRequest = item.getPrice() * quantityRequested;
        this.currentAccountBalance -= priceOfRequest;

        if (cart.containsKey(productCode)) {
            quantityRequested = cart.get(productCode) + quantityRequested;
        }

        this.cart.put(item.getProductCode(), quantityRequested);

    }

    public String[][] getCartInformation(){
        String[][] outputArray = new String[cart.size()][6];
        int i = 0;
        for(Map.Entry<String, Integer> entry : cart.entrySet()){
            String[] innerArray = new String[6];
            innerArray[0] = String.valueOf(entry.getValue());
            innerArray[1] = inventory.get(entry.getKey()).getItemType();
            innerArray[2] = inventory.get(entry.getKey()).getDescription();
            innerArray[3] = String.format("$%1.2f", inventory.get(entry.getKey()).getPrice());
            innerArray[4] = String.format("$%1.2f", entry.getValue()*inventory.get(entry.getKey()).getPrice());
            innerArray[5] =  inventory.get(entry.getKey()).getOnScreenReminder();
            outputArray[i] = innerArray;
            i++;
        } return outputArray;
    }
}
