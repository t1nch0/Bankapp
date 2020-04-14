package org.example;

public class BankAccount {
    private final String owner;
    private final String accountNumber;
    private double total;

    public BankAccount(String owner, String accountNumber) {
        this.owner = owner;
        this.accountNumber = accountNumber;
        this.total = 1000;
    }

    public void withdraw(Double amount) {
        //total = total - 10;

        total=total-amount;
    }
    public void deposit(Double amount){
    total=total+amount;
    }

    public double getBalance() {
        return total;
    }
}
