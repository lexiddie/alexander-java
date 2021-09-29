package com.dlex.SavingAccountsV2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BankingSystem {
    public static void main(String[] args) {
        ArrayList<SavingAccounts> accounts = new ArrayList<SavingAccounts>();
        File savingBank = new File("savingaccounts.txt");
        int counts = loadUsers(accounts, savingBank);
        while (true) {
            System.out.println("1/ Create a new account: ");
            System.out.println("2/ Deposit to an account: ");
            System.out.println("3/ Withdraw from an account: ");
            System.out.println("4/ Transfer to other accounts:");
            System.out.println("5/ Display all bank accounts:");
            System.out.println("6/ Exit the program:");
            Scanner scan = new Scanner(System.in);
            int command = scan.nextInt();
            if (command == 1) {
                boolean check = createAccount(accounts);
                if (check) {
                    System.out.println("Your bank account has been created");
                } else {
                    System.out.println("Your bank account number already exists");
                }
            } else if (command == 2) {
                boolean check = depositAccount(accounts);
                if (check) {
                    System.out.println("Deposit to account is succeed");
                } else {
                    System.out.println("Invalid bank account number");
                }

            } else if (command == 3) {
                boolean check = withdrawAccount(accounts);
                if (check) {
                    System.out.println("Withdraw from account has been succeed");
                } else {
                    System.out.println("Invalid bank account number");
                }
            } else if (command == 4) {
                boolean check = transferMoney(accounts);
                if (check) {
                    System.out.println("Money has been transferred");
                } else {
                    System.out.println("Invalid bank account number");
                }
            }
            else if (command == 5) {
                boolean check = displayBankAccounts(accounts);
                if (!check) {
                    System.out.println("There isn't any bank account");
                }
            }
            else {
                System.out.println("Exit the program");
                saveUsers(accounts, savingBank);
                scan.close();
                return;
            }
        }

    }


    public static int loadUsers(ArrayList<SavingAccounts> accounts, File savingbank) {
        int count = 0;
        try {
            Scanner scan = new Scanner(savingbank);
            while (scan.hasNext()) {
                String accountName;
                String accountNumber;
                double balance;
                String buffer = scan.nextLine();
                StringTokenizer st = new StringTokenizer(buffer);
                accountName = st.nextToken();
                accountNumber = st.nextToken();
                balance = Double.parseDouble(st.nextToken());
                SavingAccounts insert = new SavingAccounts(accountName, accountNumber, balance);
                accounts.add(insert);
                count++;
            }

        }catch (FileNotFoundException e) {
            System.err.print("File not found");
        }
        return count;
    }
    public static void saveUsers(ArrayList<SavingAccounts> accounts, File savingbank) {
        try {
            PrintWriter write = new PrintWriter(savingbank);
            for (SavingAccounts upload : accounts) {
                String nameFormat = String.format("%10s", upload.getAccountName());
                String numberFormat = String.format("%10s", upload.getAccountNumber());
                String balanceFormat = String.format("%10s", upload.getBalance());
                String insert = nameFormat + numberFormat + balanceFormat;
                write.println(insert);
            }
            write.close();
        }catch (FileNotFoundException e) {
            System.err.print("File system doesn't exits");
        }
    }
    public static boolean createAccount(ArrayList<SavingAccounts> accounts) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Input the account numbers: ");
        String numbers = scan.next();
        for (SavingAccounts account : accounts) {
            if (account.getAccountNumber().equals(numbers)) {
                return false;
            }
        }
        scan.nextLine();
        System.out.print("Input the account name: ");
        String names = scan.nextLine();
        System.out.print("Input the account Balance: ");
        double balance = scan.nextDouble();
        SavingAccounts insert = new SavingAccounts(names, numbers, balance);
        accounts.add(insert);
        return true;

    }
    public static boolean depositAccount(ArrayList<SavingAccounts> accounts) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Input the account numbers: ");
        String numbers = scan.next();
        for (SavingAccounts account : accounts) {
            if (account.getAccountNumber().equals(numbers)) {
                System.out.print("Input your amount to deposit: ");
                double amount = scan.nextDouble();
                account.deposit(amount);
                return true;
            }
        }
        return false;
    }
    public static boolean withdrawAccount(ArrayList<SavingAccounts> accounts) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Input the account numbers: ");
        String numbers = scan.next();
        for (SavingAccounts account : accounts) {
            if (account.getAccountNumber().equals(numbers)) {
                while (true) {
                    System.out.print("Input your amount to withdraw: ");
                    double amount = scan.nextDouble();
                    boolean check = account.withdraw(amount);
                    if (check) {
                        return true;
                    }
                    System.out.println("Invalid account balance: ");
                }
            }
        }
        return false;
    }
    public static boolean transferMoney(ArrayList<SavingAccounts> accounts) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Input the first account numbers to transfer: ");
        String numbers = scan.next();
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAccountNumber().equals(numbers)) {
                System.out.print("Input the second account numbers to transfer: ");
                String second = scan.next();
                for (SavingAccounts account : accounts) {
                    if (account.getAccountNumber().equals(second)) {
                        while (true) {
                            System.out.print("Input your amount to transfer: ");
                            double amount = scan.nextDouble();
                            boolean check = accounts.get(i).withdraw(amount);
                            if (check) {
                                return true;
                            }
                            System.out.println("Invalid account balance: ");
                        }
                    }
                }
                return false;
            }
        }
        return false;
    }
    public static boolean displayBankAccounts(ArrayList<SavingAccounts> accounts) {
        if (accounts.size() == 0) {
            return false;
        } else {
            for (SavingAccounts account : accounts) {
                System.out.println(account.toString());
            }
            return true;
        }
    }
}
