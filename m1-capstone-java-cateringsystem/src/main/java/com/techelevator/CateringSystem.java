package com.techelevator;

import com.techelevator.items.CateringItem;

import java.util.Map;
import java.util.TreeMap;

/*
    This class should encapsulate all the functionality of the Catering system, meaning it should
    contain all the "work"
 */
public class CateringSystem {

    private float currentAccountBalance=0;
    private Map<String, Integer> cart = new TreeMap<>();
    private Map<String, CateringItem> inventory;

    public CateringSystem(Map<String,CateringItem> inventory){
        this.inventory = inventory;

    }


    public boolean addMoney(int amount) {
        if(amount > 500) {
            return false;
        }if(currentAccountBalance + amount > 1500) {
            return false;
        } currentAccountBalance += amount;

        return true;
    }

    public float getCurrentAccountBalance() {
        return currentAccountBalance;
    }

}
