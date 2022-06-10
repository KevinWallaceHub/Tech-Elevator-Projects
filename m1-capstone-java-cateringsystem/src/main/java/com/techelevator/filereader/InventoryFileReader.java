package com.techelevator.filereader;

import com.techelevator.items.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/*
    This class should contain any and all details of access to the inventory file
 */
public class InventoryFileReader {

    private String inventoryFileName;
    private Map<String, CateringItem> inventory = new TreeMap<>();

    public InventoryFileReader(String inventoryFileName) {
        this.inventoryFileName = inventoryFileName;
    }

    public Map<String, CateringItem> getInventory(int startingQuantity) {
        File source = new File(this.inventoryFileName);
        try (Scanner fileScanner = new Scanner(source)) {
            while (fileScanner.hasNextLine()) {
                String fileLine = fileScanner.nextLine();
                String[] itemParts = fileLine.split("\\|");
                CateringItem newItemToAdd;
                String productCode = itemParts[1].toUpperCase();
                if (itemParts[0].equals("A")) {
                    newItemToAdd = new Appetizer(productCode, itemParts[2], startingQuantity, Float.parseFloat(itemParts[3]));
                    inventory.put(productCode, newItemToAdd);
                }
                if (itemParts[0].equals("B")) {
                    newItemToAdd = new Beverage(productCode, itemParts[2], startingQuantity, Float.parseFloat(itemParts[3]));
                    inventory.put(productCode, newItemToAdd);
                }
                if (itemParts[0].equals("E")) {
                    newItemToAdd = new Entree(productCode, itemParts[2], startingQuantity, Float.parseFloat(itemParts[3]));
                    inventory.put(productCode, newItemToAdd);
                }
                if (itemParts[0].equals("D")) {
                    newItemToAdd = new Desert(productCode, itemParts[2], startingQuantity, Float.parseFloat(itemParts[3]));
                    inventory.put(productCode, newItemToAdd);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return inventory;


    }
}
