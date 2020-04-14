package org.example;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Application app = new Application();
        app.run("Jerry", "BO10006789");
    }

    private static void print(String message) {
        System.out.println(message);
    }

    private void run(String name, String account) {
        BankAccount bankAccount = new BankAccount(name, account);

        // Welcome to the BankApp
        print("Welcome " + name);
        print("Your current account is " + account);

        showMainMenu();
        selectOption(bankAccount);
    }

    private void showMainMenu() {
        // Main Menu
        print(System.lineSeparator());
        print("********************");
        print("(W) Withdraw");
        print("(D) Deposit");
        print("(B) My Balance");
        print("(T) My Transactions");
        print("(E) Exit");
        print("********************");
    }

    private void selectOption(BankAccount bankAccount) {
        // Press a key to select an option
        try (Scanner scanner = new Scanner(System.in)){
            boolean closeApp = false;
            char option;
            while (true) {
                System.out.print("Select an option: ");
                option = getSelectedOption(scanner);
                switch (option) {
                    case 'A':
                        showMainMenu();
                        break;
                    case 'E':
                        print("Exit...");
                        closeApp = true;
                        break;
                    case 'B':
                        print("My Balance is " + bankAccount.getBalance());
                        break;
                    case 'W':
                        withdraw(bankAccount);
                        break;
                    case 'D':
                        deposit(bankAccount);
                    default:
                        print(option + " is an invalid option");
                        break;
                }

                // Is running
                if (closeApp) {
                    break;
                }

                print("(A) Show All options");
            }
        }
    }

    private char getSelectedOption(Scanner scanner) {
        return scanner.nextLine().trim().toUpperCase().charAt(0);
    }
    private double getAmount(Scanner scanner){
        return scanner.nextDouble();
    }

    private void withdraw(BankAccount bankAccount) {
        /*
        User should be able to select the amount
         */
        try (Scanner scanner = new Scanner(System.in)) {
        double amount=0;
        while(true){
            System.out.println("Insert an amount to withdraw");
            amount=getAmount(scanner);
            double saldo=bankAccount.getBalance();
            System.out.println(saldo);
            if(amount>saldo) {

                System.out.println("you don't have enough founds");
            }
            else {
                if (amount != 0 || amount < 0) {
                    System.out.println(amount);
                    bankAccount.withdraw(amount);
                } else {
                    System.out.println("invalid amount");
                }
            }
            break;
        }
            showMainMenu();
            selectOption(bankAccount);
        }


    }
    private void deposit(BankAccount bankAccount){
        try (Scanner scanner = new Scanner(System.in)) {
            double amount=0;
            while(true){
                System.out.println("Insert an amount to deposit");
                amount=getAmount(scanner);
                if(amount !=0||amount>0) {
                    System.out.println(amount);
                    bankAccount.deposit(amount);
                    break;
                }
            }
            showMainMenu();
            selectOption(bankAccount);
        }
    }
}
