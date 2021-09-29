package com.dlex;

import java.util.Scanner;

public class SecretMessage {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("All messages in the conversation to encrypting: ");
        String n = scan.nextLine();
        scan.close();
        String encrypt = encrypt(n);
        System.out.println("This is the encrypted messages: " + encrypt);
        String decrypt = decrypt(encrypt);
        System.out.println("This is the decrypted messages: " + decrypt);

    }

    public static String encrypt(String message) {
        char[] arr = message.toCharArray();
        StringBuilder output = new StringBuilder();
        for (char c : arr) {
            char word = c;
            if (c >= 'A' && c <= 'F' || c >= 'a' && c <= 'f') {
                word += 20;
            } else if (c >= 'G' && c <= 'Z') {
                word -= 90;
                word += 84;
            } else if (c >= 'g' && c <= 'z') {
                word -= 122;
                word += 116;
            } else if (c == ' ' || c == '\'') {
                word += 129;
            }
            output.append(word);
        }
        return output.toString();
    }

    public static String decrypt(String message) {
        char[] arr = message.toCharArray();
        StringBuilder output = new StringBuilder();
        for (char c : arr) {
            char word = c;
            if (c >= 'A' && c <= 'T' || c >= 'a' && c <= 't') {
                word += 6;
            } else if (c >= 'U' && c <= 'Z' || c >= 'u' && c <= 'z') {
                word -= 20;
            } else if (c == '¡' || c == '¨') {
                word -= 129;
            }
            output.append(word);
        }
        return output.toString();
    }
}
