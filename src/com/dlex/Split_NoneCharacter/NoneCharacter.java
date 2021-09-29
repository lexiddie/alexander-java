package com.dlex.Split_NoneCharacter;

public class NoneCharacter {
    public static void main(String[] args) {
        String input = "Hi,X How-how are:any you?";
        String[] parts = input.split("[\\W]");
        for (String part : parts) {
            System.out.print(part + " ");
        }

        System.out.println();

        String input2 = "Hi,X How-how are:any you?";
        String[] parts2 = input2.split("[\\,\\s\\-\\:\\?]");
        for (int i = 0; i < parts.length; i++) {
            System.out.print(parts2[i] + " ");
        }
    }
}
