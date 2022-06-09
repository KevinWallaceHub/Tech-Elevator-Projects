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

    public Map<String, CateringItem> getInventory(int startingQuantity){
        File source = new File(this.inventoryFileName);
        try(Scanner fileScanner = new Scanner(source)){
            while(fileScanner.hasNextLine()){
                String fileLine = fileScanner.nextLine();
                String[] itemParts = fileLine.split("\\|");
                CateringItem newItemToAdd;
                if(itemParts[0] == "A"){
                    newItemToAdd = new Appetizer(itemParts[1],itemParts[2],startingQuantity,Float.parseFloat(itemParts[3]));
                }
                if(itemParts[0] == "B"){
                    newItemToAdd = new Beverage(itemParts[1],itemParts[2],startingQuantity,Float.parseFloat(itemParts[3]));
                }
                if(itemParts[0] == "E"){
                    newItemToAdd = new Entree(itemParts[1],itemParts[2],startingQuantity,Float.parseFloat(itemParts[3]));
                }
                if(itemParts[0] == "D"){
                    newItemToAdd = new Desert(itemParts[1],itemParts[2],startingQuantity,Float.parseFloat(itemParts[3]));
                }
                inventory.put(itemParts[1],newItemToAdd);
            }
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }


    }
}
