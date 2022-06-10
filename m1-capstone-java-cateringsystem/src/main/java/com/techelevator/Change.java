package com.techelevator;

public class Change {

    private float currentBalance;
    private int numberOfFifties = 0;
    private int numberOfTwenties = 0;
    private int numberOfTens = 0;
    private int numberOfFives = 0;
    private int numberOfOnes = 0;
    private int numberOfQuarters = 0;
    private int numberOfDimes = 0;
    private int numberOfNickels = 0;

    public Change(float currentBalance) {
        this.currentBalance = currentBalance;
        this.makeChange();
    }

    private void makeChange() {
        numberOfFifties = (int) Math.floor(currentBalance / 50);
        currentBalance -= numberOfFifties * 50;
        numberOfTwenties = (int) Math.floor(currentBalance / 20);
        currentBalance -= numberOfTwenties * 20;
        numberOfTens = (int) Math.floor(currentBalance / 10);
        currentBalance -= numberOfTens * 10;
        numberOfFives = (int) Math.floor(currentBalance / 5);
        currentBalance -= numberOfFives * 5;
        numberOfOnes = (int) Math.floor(currentBalance);
        currentBalance -= numberOfOnes;
        numberOfQuarters = (int) Math.floor(currentBalance / 0.25);
        currentBalance -= numberOfQuarters * 0.25;
        numberOfDimes = (int) Math.floor(currentBalance / 0.10);
        currentBalance -= numberOfDimes * 0.10;
        numberOfNickels = (int) Math.floor(currentBalance / 0.05);
        currentBalance -= numberOfNickels * 0.05;

    }

    public float getCurrentBalance() {
        return currentBalance;
    }

    public int getNumberOfFifties() {
        return numberOfFifties;
    }

    public int getNumberOfTwenties() {
        return numberOfTwenties;
    }

    public int getNumberOfTens() {
        return numberOfTens;
    }

    public int getNumberOfFives() {
        return numberOfFives;
    }

    public int getNumberOfOnes() {
        return numberOfOnes;
    }

    public int getNumberOfQuarters() {
        return numberOfQuarters;
    }

    public int getNumberOfDimes() {
        return numberOfDimes;
    }

    public int getNumberOfNickels() {
        return numberOfNickels;
    }
}
