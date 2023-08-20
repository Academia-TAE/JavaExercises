package org.example;

public class BankAccount {
    private String ownerName;
    private double balance;

    public BankAccount(String ownerName) {
        this.ownerName = ownerName;
        this.balance = 0.0;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited $" + amount + " into the account.");
        printBalance();
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew $" + amount + " from the account.");
            printBalance();
        } else {
            System.out.println("Insufficient funds.");
            printBalance();
        }
    }

    private void printBalance() {
        System.out.println("Current balance: $" + balance);
    }
}