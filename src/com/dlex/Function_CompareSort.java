package com.dlex;

public class Function_CompareSort {
    public static void main(String[] args) {
        String[] arr = {"solo", "lex", "han", "newt", "apple"};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                String a = arr[i];
                String b = arr[j];
                int compare = a.compareTo(b);
                if (compare < 0) {
                    String temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (String s : arr) {
            System.out.print(s + " ");
        }
    }
}
