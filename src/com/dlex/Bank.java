package com.dlex;

import java.util.Scanner;

public class Bank {
    public static void main(String[] args) {
        BankAccount[] accounts = new BankAccount[100];
        loadDefaultAccount(accounts);
        while (true) {
            System.out.println("1) To create Bank Account: ");
            System.out.println("2) To deposit money: ");
            System.out.println("3) To withdraw money: ");
            System.out.println("4) To Query: ");
            System.out.println("5) To Quit: ");
            Scanner scan = new Scanner(System.in);
            String input = scan.next();
            switch (input) {
                case "1" -> {
                    System.out.print("Input the Bank Account number within 10 digit number: ");
                    String accountNumber = scan.next();
                    System.out.print("Input the Bank Account name: ");
                    String accountName = scan.next();
                    System.out.print("Beginning account Balance: ");
                    double balance = scan.nextDouble();
                    int check = createAccount(accounts, accountName, accountNumber, balance);
                    if (check != -1) {
                        System.out.println("Bank account has been created");
                    } else {
                        System.out.println("Bank account failed");
                    }
                }
                case "2" -> {
                    System.out.print("Input your Bank Account number to deposit: ");
                    String deposit = scan.next();
                    int check = depositMoney(accounts, deposit);
                    if (check != -1) {
                        System.out.print("Deposit Successful");
                    } else {
                        System.out.print("Invalid account number!!");
                    }
                }
                case "3" -> {
                    System.out.print("Input your Bank Account number to withdraw: ");
                    String drawMoney = scan.next();
                    int check = withdrawMoney(accounts, drawMoney);
                    if (check != -1) {
                        System.out.print("Withdraw Successful");
                    } else {
                        System.out.print("Invalid account number!!");
                    }
                }
                case "4" -> {
                    System.out.print("Input your Bank Account number to Query: ");
                    String query = scan.next();
                    int check = queryAccount(accounts, query);
                    if (check != -1) {
                        System.out.print(accounts[check].toString());
                    } else {
                        System.out.print("Invalid account number!!");
                    }
                }
                default -> {
                    System.out.print("Quit");
                    scan.close();
                    return;
                }
            }
        }
    }

    public static void loadDefaultAccount(BankAccount[] accounts) {
        for (int i = 0; i < accounts.length; i++) {
            BankAccount bank = new BankAccount();
            accounts[i] = bank;
        }
    }

    public static int createAccount(BankAccount[] accounts, String accountNumber, String accountName, double balance) {
        for (int i = 0; i < accounts.length; i++) {
            String check = accounts[i].getAccountName();
            if (check.equals("Undefined")) {
                BankAccount bank = new BankAccount();
                bank.createAccount(accountNumber, accountName, balance);
                accounts[i] = bank;
                return i;
            }
        }
        return -1;
    }

    public static int depositMoney(BankAccount[] accounts, String deposit) {
        for (int i = 0; i < accounts.length; i++) {
            String check = accounts[i].getAccountNumber();
            if (deposit.equals(check)) {
                Scanner scanNumber = new Scanner(System.in);
                System.out.print("Enter the amount to deposit: ");
                double amount = scanNumber.nextDouble();
                scanNumber.close();
                accounts[i].depositMoney(amount);
                return i;
            }
        }
        return -1;
    }

    public static int withdrawMoney(BankAccount[] accounts, String drawMoney) {
        for (int i = 0; i < accounts.length; i++) {
            String check = accounts[i].getAccountNumber();
            if (drawMoney.equals(check)) {
                Scanner scanNumber = new Scanner(System.in);
                System.out.print("Enter the amount to withdraw: ");
                double amount = scanNumber.nextDouble();
                scanNumber.close();
                accounts[i].withdrawMoney(amount);
                return i;
            }
        }
        return -1;
    }

    public static int queryAccount(BankAccount[] accounts, String query) {
        for (int i = 0; i < accounts.length; i++) {
            String check = accounts[i].getAccountNumber();
            if (query.equals(check)) {
                return i;
            }
        }
        return -1;
    }
}
