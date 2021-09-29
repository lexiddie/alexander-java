package com.dlex;

public class Recursion_BinarySearch {
    public static void main(String[] args) {
        int[] sortedNumber = {1, 5, 7, 9, 11, 15, 20, 25, 30, 45, 67, 77, 78, 79, 80, 88, 90};
        int result = binarySearch(sortedNumber, 500, 0, 16);
        System.out.println(result);
    }
    public static int binarySearch(int[] array, int key, int start, int end) {
        int middle = (start + end)/2;
        while (start <= end) {
            if (key == array[middle]) {
                return middle;
            } else if (key > array[middle]) {
                return binarySearch(array, key,middle + 1, end);
            } else if (key < array[middle]) {
                return binarySearch(array, key, start,middle - 1);
            }
        }
        return -1;
    }
}
