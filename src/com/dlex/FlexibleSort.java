package com.dlex;

public class FlexibleSort {
    public static void main(String[] args) {
        int[] myArray = {5, 3, 2, 8, 7};
        bubbleSort(myArray, -1);
    }
    public static void bubbleSort(int[] array, int order) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (order == -1) {
                    if (array[i] > array[j]) {
                        int temp = array[i];
                        array[i] = array[j];
                        array[j] = temp;
                    }
                } else if (order == 1) {
                    if (array[i] < array[j]) {
                        int temp = array[i];
                        array[i] = array[j];
                        array[j] = temp;
                    }
                }
            }
        }
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
