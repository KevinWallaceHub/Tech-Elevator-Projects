package com.techelevator;

import com.techelevator.items.CateringItem;

import java.util.Map;

/*
    This class should encapsulate all the functionality of the Catering system, meaning it should
    contain all the "work"
 */
public class CateringSystem {

    private float currentAccountBalance=0;
    private Map<String, CateringItem> cart;
    private Map<String, CateringItem> inventory;


    public float addMoney(int amount) {

        currentAccountBalance += amount;
        return currentAccountBalance;

    }

    public float getCurrentAccountBalance() {
        return currentAccountBalance;
    }

}
