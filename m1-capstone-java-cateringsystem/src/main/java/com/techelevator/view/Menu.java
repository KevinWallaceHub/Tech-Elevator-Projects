package com.techelevator.view;

import com.techelevator.items.CateringItem;

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
	public int getUsarInputAsInt(){
		return input.nextInt();
	}

	public void showMainMenu(){
		System.out.println("(1) Display Catering Items");
		System.out.println("(2) Order");
		System.out.println("(3) Quit");

	}

	public void showOrderMenu(){
		System.out.println("(1) Add Money");
		System.out.println("(2) Select Products");
		System.out.println("(3) Complete Transaction");

	}

	public void displayGoodbyeMessage(){
		System.out.println("Thank you for shopping, Goodbye");
	}

	public void showListOfCateringItems(CateringItem[] cateringItems){
		String headerLine = cateringItemFormater("Product Code","Descrption","Qty","Price");
		System.out.println(headerLine);
		for(CateringItem cateringItem: cateringItems){
		//	String itemLine = cateringItem.getProductCode;
		}
	}

	private String cateringItemFormater(String productCode,String description, String qty, String price){
		return String.format("%15s %30s %5s %10s",productCode, description, qty, price);
	}



}
