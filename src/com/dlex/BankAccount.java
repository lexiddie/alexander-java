package com.dlex;

public class BankAccount {
    private String accountNumber;
    private String accountName;
    private double balance;

    public BankAccount() {
        this.accountNumber = "999999999";
        this.accountName = "Undefined";
        this.balance = 0.0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void depositMoney(double amount) {
        setBalance(getBalance() + amount);
    }
    public void withdrawMoney(double amount) {
        setBalance(getBalance() - amount);
    }
    public void createAccount(String accountNumber, String accountName, double balance) {
        setAccountNumber(accountNumber);
        setAccountName(accountName);
        setBalance(balance);
    }
    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", accountName='" + accountName + '\'' +
                ", balance=" + balance +
                '}';
    }
}
