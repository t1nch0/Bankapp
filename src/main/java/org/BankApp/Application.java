package org.BankApp;

import java.util.Scanner;


public class Application {
    public static void main(String[] args) {
        Application application=new Application();
        application.init();

    }
    private void init(){
        // User details
        String name = "Jerry";
        String account = "BO10006789";
        // Welcome to the BankApp
        printMsg("Welcome " + name);
        printMsg("Your current account is " + account);

        showMainMenu();
        scannerInit();
        // Press a key to select an option

    }
    private void scannerInit(){
        try (Scanner scanner = new Scanner(System.in)) {
            char option;
            do {
                printMsg("Select an option: ");
                option = (char) scanner.nextLine().trim().toUpperCase().charAt(0);
                switch (option) {
                    case 'W':
                        printMsg("you withdrew money:");
                        printMsg("(A) Show All options");
                        break;
                    case 'D':
                        printMsg("your deposited money:");
                        printMsg("(A) Show All options");
                        break;
                    case 'B':
                        printMsg("your balance is:");
                        printMsg("(A) Show All options");
                        break;
                    case 'T':
                        printMsg("your last transactions are:");
                        printMsg("(A) Show All options");
                        break;
                    case 'E':
                        printMsg("Exit...");
                        break;
                    case 'A':

                        showMainMenu();
                        break;
                    default:
                        printMsg(option + " is an invalid option");
                        printMsg("(A) Show All options");
                        break;
                }
                printMsg(System.lineSeparator());

            } while (option != 'E');
        }
    }
    private void showMainMenu(){
        // Main Menu
        //printMsg();
        printMsg(System.lineSeparator());
        printMsg("********************");
        printMsg("(W) Withdraw");
        printMsg("(D) Deposit");
        printMsg("(B) My Balance");
        printMsg("(T) My Transactions");
        printMsg("(E) Exit");
        printMsg("********************");

    }
    private void printMsg(String text){
        System.out.println(text);
    }

}
