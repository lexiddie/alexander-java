package com.dlex;

public class BinarySearch_LinearSearch {
    public static void main(String[] args) {
        int[] sortedNumber = {1, 5, 7, 9, 11, 15, 20, 25, 30, 45, 67, 77, 78, 79, 80, 88, 90};
        int result = binarySearch(sortedNumber, 25);
        System.out.println(result);
        int resultLinear = linearSearch(sortedNumber, 45);
        System.out.println(resultLinear);
    }
    private static int binarySearch(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int middle = (start + end)/2;
            if (key == arr[middle]) {
                return middle;
            } else if (key > arr[middle]) {
                start = middle + 1;
            } else if (key < arr[middle]) {
                end = middle - 1;
            }
        }
        return -1;
    }
    private static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (key == arr[i]) {
                return i;
            }
        }
        return -1;
    }
}
