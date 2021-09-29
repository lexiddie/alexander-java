package com.dlex.Tutorial;

public class Recursion_Repeats {
    public static void main(String[] args) {
        int[] number1 = {1,2,3,4,5,6};
        int[] number2 = {1,2,3,4,6,6};

        boolean result = repeats(number2);
        System.out.println("Check the result " + result);
    }

    public static boolean repeats(int[] numberList) {
        if (numberList.length != 0 && numberList.length != 1) {
            if (numberList[0] == numberList[1]) {
                return true;
            } else {
                int[] result = new int[numberList.length - 1];
                System.out.println(numberList.length);
                for (int i = 1; i < numberList.length; i++) {
                    result[i - 1] = numberList[i];
                    System.out.println(numberList[i]);
                }
                repeats(result);
            }
        }
        return false;
    }
}
