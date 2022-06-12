package com.techelevator.view;

import com.techelevator.Change;
import com.techelevator.items.CateringItem;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * This is the only class that should have any usage of System.out or System.in
 *
 * Usage of System.in or System.out should not appear ANYWHERE else in your code outside of this class.
 *
 * Work to get input from the user or display output to the user should be done in this class, however, it
 * should include no "work" that is the job of the catering system.
 */
public class Menu {

    private static final Scanner input = new Scanner(System.in);

    public void showWelcomeMessage() {
        System.out.println("*************************");
        System.out.println("**     Weyland Corp.   **");
        System.out.println("**      Catering       **");
        System.out.println("*************************");
        System.out.println();
    }

    public int getUserInputAsInt() {
        try {
            return input.nextInt();
        } catch (InputMismatchException e) {
            input.next();
            System.out.println("Please input a valid integer");
            return getUserInputAsInt();
        }
    }

    public String getUserInputAsString() {
        return input.next();
    }

    public void showMainMenu() {
        System.out.println("(1) Display Catering Items");
        System.out.println("(2) Order");
        System.out.println("(3) Quit");

    }

    public void showOrderMenu(float currentBalance) {
        System.out.println("(1) Add Money");
        System.out.println("(2) Select Products");
        System.out.println("(3) Complete Transaction");

        System.out.printf("Current account balance is : $%5.2f", currentBalance);
        System.out.println();
        System.out.println();

    }

    public void displayGoodbyeMessage() {
        System.out.println("Thank you for shopping, Goodbye");
    }

    public void showListOfCateringItems(CateringItem[] cateringItems) {
        String headerLine = cateringItemFormater("Product Code", "Description", "Qty", "Price");
        System.out.println(headerLine);
        for (CateringItem cateringItem : cateringItems) {
            String itemLine = cateringItemFormater(
                    cateringItem.getProductCode(),
                    cateringItem.getDescription(),
                    String.valueOf(cateringItem.getQuantity()),
                    String.format("$%.2f", cateringItem.getPrice())
            );
            System.out.println(itemLine);
        }
        System.out.println();

    }

    private String cateringItemFormater(String productCode, String description, String qty, String price) {
        return String.format("%15s %30s %5s %10s", productCode, description, qty, price);
    }

    public void displayAddMoneyMenu() {
        System.out.println("Please enter a whole dollar amount you would like to deposit up to 500");
    }

    public void transactionFailed(String messageToPrint) {

        System.out.println(messageToPrint);

    }

    public String selectProductCode() {
        System.out.println("Please enter the product code for the product you wish to select");
        return getUserInputAsString();
    }

    public int selectDesiredQuantity() {
        System.out.println("Please enter the quantity you wish to purchase");
        int desiredQuantity = getUserInputAsInt();
        while (desiredQuantity < 0) {
            System.out.println("Quantity needs to be a positive number");
            desiredQuantity = getUserInputAsInt();

        }
        System.out.println("Thank you");

        return desiredQuantity;
    }

    public void displayCartInformation(String[][] cartInfo, float totalCharges) {

        for (String[] innerArray : cartInfo) {

            System.out.println(
                    String.format(
                            "%3s %-10s %30s %-7s %-10s %-50s",
                            innerArray[0],
                            innerArray[1],
                            innerArray[2],
                            innerArray[3],
                            innerArray[4],
                            innerArray[5]
                    )
            );

        }
        System.out.println();
        System.out.printf("Total Charges: $%5.2f", totalCharges);
        System.out.println();

    }

    public void displayChange(Change changeProvided) {

        String outputString = "";

        if (changeProvided.getNumberOfFifties() > 0) {
            outputString = String.join(", ", outputString, String.format(
                    "(%d) Fifties",
                    changeProvided.getNumberOfFifties()
            ));
        }
        if (changeProvided.getNumberOfTwenties() > 0) {
            outputString = String.join(
                    ", ",
                    outputString,
                    String.format("(%d) Twenties", changeProvided.getNumberOfTwenties())
            );
        }
        if (changeProvided.getNumberOfTens() > 0) {
            outputString = String.join(
                    ", ",
                    outputString,
                    String.format("(%d) Tens", changeProvided.getNumberOfTens())
            );
        }
        if (changeProvided.getNumberOfFives() > 0) {
            outputString = String.join(
                    ", ",
                    outputString,
                    String.format("(%d) Fives", changeProvided.getNumberOfFives())
            );
        }
        if (changeProvided.getNumberOfOnes() > 0) {
            outputString = String.join(
                    ", ",
                    outputString,
                    String.format("(%d) Ones", changeProvided.getNumberOfOnes())
            );
        }
        if (changeProvided.getNumberOfQuarters() > 0) {
            outputString = String.join(
                    ", ",
                    outputString,
                    String.format("(%d) Quarters", changeProvided.getNumberOfQuarters())
            );
        }
        if (changeProvided.getNumberOfDimes() > 0) {
            outputString = String.join(
                    ", ",
                    outputString,
                    String.format("(%d) Dimes", changeProvided.getNumberOfDimes())
            );
        }
        if (changeProvided.getNumberOfNickels() > 0) {
            outputString = String.join(
                    ", ",
                    outputString,
                    String.format("(%d) Nickels", changeProvided.getNumberOfNickels())
            );
        }

        outputString = "You received" + outputString + " in change";

        System.out.println(outputString);

    }

}
