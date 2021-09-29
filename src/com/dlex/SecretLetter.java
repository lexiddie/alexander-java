package com.dlex;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SecretLetter {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Encrypt the message Enter 0 " + "\nDecrypt the message Enter 1 " );
        int check = scan.nextInt();
        if (check == 0) {
            System.out.print("Input the filename to encrypt: ");
            String input = scan.next();
            selectEncrypt(input);
        } else if (check == 1) {
            System.out.print("Input the filename to decrypt: ");
            String input = scan.next();
            selectDecrypt(input);
        }
        scan.close();
    }

    public static void selectEncrypt(String pathname) {
        File pathFile = new File(pathname);
        File encrypt = new File("SecretLetter_encrypt.txt");
        try {
            Scanner newScan = new Scanner(pathFile);
            StringBuilder toEncrypt = new StringBuilder();
            while (newScan.hasNext()) {
                toEncrypt.append(newScan.nextLine());
            }
            newScan.close();
            PrintWriter writer = new PrintWriter(encrypt);
            String result = encrypt(toEncrypt.toString());
            writer.println(result);
            writer.close();
            System.out.print("Encrypt texts successful.");
        } catch (FileNotFoundException e) {
            System.err.print("File not found");
        }
    }

    public static void selectDecrypt(String pathname) {
        File pathFile = new File(pathname);
        File decrypt = new File("SecretLetter_decrypt.txt");
        try {
            Scanner newScan = new Scanner(pathFile);
            StringBuilder toDecrypt = new StringBuilder();
            while (newScan.hasNext()) {
                toDecrypt.append(newScan.nextLine());
            }
            newScan.close();
            PrintWriter writer = new PrintWriter(decrypt);
            String result = decrypt(toDecrypt.toString());
            writer.println(result);
            writer.close();
            System.out.print("Decrypt texts successful.");

        }catch (FileNotFoundException e) {
            System.err.print("File not found");
        }
    }

    public static String encrypt(String message) {
        char[] arr = message.toCharArray();
        StringBuilder output = new StringBuilder();
        for (char c : arr) {
            char n = c;
            if (n >= 65 && n <= 75 || n >= 97 && n <= 107) {
                n += 15;
            } else if (n >= 76 && n <= 90) {
                n -= 90;
                n += 79;
            } else if (n >= 108 && n <= 122) {
                n -= 122;
                n += 111;
            }
            output.append(n);
        }
        return output.toString();
    }

    public static String decrypt(String message) {
        char[] arr = message.toCharArray();
        StringBuilder output = new StringBuilder();
        for (char c : arr) {
            char n = c;
            if (n >= 79 && n <= 90 || n >= 111 && n <= 122) {
                n -= 15;
            } else if (n >= 65 && n <= 78 || n >= 97 && n <= 110) {
                n += 11;
            }
            output.append(n);
        }
        return output.toString();
    }

}
