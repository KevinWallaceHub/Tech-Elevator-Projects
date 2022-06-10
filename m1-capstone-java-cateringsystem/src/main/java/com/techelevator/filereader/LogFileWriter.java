package com.techelevator.filereader;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
    This class should contain any and all details of access to the log file
 */
public class LogFileWriter {

    private File file = new File("Log.txt");

    private void logWriter(String messageToLog) {
        try (
                FileWriter fileWriter = new FileWriter(file,true);
                PrintWriter logWriter = new PrintWriter(fileWriter)
        ) {
            LocalDateTime now = LocalDateTime.now();
            String formatedTimeStamp = now.format(DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a"));

            logWriter.println(formatedTimeStamp + " " + messageToLog);

        } catch (IOException e) {
            System.out.println("Who do I tell when my logger breaks????");
        }

    }

    public void logMoneyAdded(int amountAdded, float currentAccountBalance) {

        logWriter("ADD MONEY: $" +amountAdded + ".00 $" + String.format("%.2f",currentAccountBalance));
    }

    public void logProductOrdered(float currentAccountBalance, int quantity, String description, String productCode,
                                  float pricePaid) {

        logWriter(quantity + " " + description + " " + productCode + " $" + String.format("%.2f",pricePaid) + " $" + String.format("%.2f",currentAccountBalance));

    }

    public void logGiveChange(float amount) {

        logWriter("GIVE CHANGE: $" + String.format("%.2f",amount) + " $0.00");

    }

}
