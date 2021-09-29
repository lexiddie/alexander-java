package com.dlex.SavingAccountsV2;

public class SavingAccounts {

    private String accountName;
    private String accountNumber;
    private double balance;

    public SavingAccounts() {
        this.accountName = "Unassigned";
        this.accountNumber = "Unassigned";
        this.balance = 0.0;
    }

    public SavingAccounts(String accountName, String accountNumber) {
        this.accountName = accountName;
        this.accountNumber = accountNumber;
    }

    public SavingAccounts(String accountName, String accountNumber, double balance) {
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public boolean deposit(double amount) {
        if (amount < 0) {
            return false;
        } else {
            this.balance += amount;
            return true;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > this.balance) {
            return false;
        } else {
            this.balance -= amount;
            return true;
        }
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("AccountNumber: ").append(this.accountNumber);
        result.append(", ");
        result.append("AccountName: ").append(this.accountName);
        result.append(", ");
        result.append("AccountBalance: ").append(this.balance);
        return result.toString();
    }
}
