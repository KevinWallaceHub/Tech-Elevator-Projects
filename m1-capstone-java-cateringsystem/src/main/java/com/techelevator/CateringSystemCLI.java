package com.techelevator;

import com.techelevator.items.CateringItem;
import com.techelevator.view.Menu;

/*
 * This class should control the workflow of the application, but not do any other work
 *
 * The menu class should communicate with the user, but do no other work
 *
 * This class should control the logical workflow of the application, but it should do no other
 * work.  It should communicate with the user (System.in and System.out) using the Menu class and ask
 * the CateringSystem class to do any work and pass the results between those 2 classes.
 */
public class CateringSystemCLI {

    /*
     * The menu class is instantiated in the main() method at the bottom of this file.
     * It is the only class instantiated in the starter code.
     * You will need to instantiate all other classes using the new keyword before you can use them.
     *
     * Remember every class and data structure is a data types and can be passed as arguments to methods or constructors.
     */
    private Menu menu;
    private CateringSystem cateringSystem = new CateringSystem();

    public CateringSystemCLI(Menu menu) {
        this.menu = menu;
    }

    /*
     * This starts the application, but you shouldn't need to change it.
     */
    public static void main(String[] args) {
        Menu menu = new Menu();
        CateringSystemCLI cli = new CateringSystemCLI(menu);
        cli.run();
    }

    /*
     * Your application starts here
     */
    public void run() {

        menu.showWelcomeMessage();

        while (true) {

            menu.showMainMenu();
            int mainMenuSelection = menu.getUserInputAsInt();
            if (mainMenuSelection == 1) {
                menu.showListOfCateringItems(new CateringItem[]{});
            }
            if (mainMenuSelection == 2) {
                runOrderMenu();
            }

            if (mainMenuSelection == 3) {
                menu.displayGoodbyeMessage();
                break;
            }

			/*
			Display the Starting Menu and get the users choice.
			Remember all uses of System.out and System.in should be in the menu

			IF the User Choice is Display Catering Items,
				THEN display catering items
			ELSE IF the User's Choice is Purchase,
				THEN go to the purchase menu
			*/
        }

    }

    private void runOrderMenu() {
        menu.showOrderMenu(cateringSystem.getCurrentAccountBalance());
        int orderMenuSelection = menu.getUserInputAsInt();
        if (orderMenuSelection == 1) {
            menu.displayAddMoneyMenu();
            int amountToAdd = menu.getUserInputAsInt();
            boolean moneyWasAdded = cateringSystem.addMoney(amountToAdd);
            if(!moneyWasAdded){
                menu.transactionFailed();
            }
            runOrderMenu();

            if (orderMenuSelection == 2) {
//                    select products
            }
            if (orderMenuSelection == 3) {
//                    complete transaction
            }
        }
    }

}
