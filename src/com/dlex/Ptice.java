package com.dlex;

import java.util.Scanner;

public class Ptice {

    public static void main(String[] args) {
        String[] AdrainArr = {"A", "B", "C", "A", "B", "C", "A", "B", "C", "A", "B", "C"};
        String[] BrunoArr = {"B", "A", "B", "C", "B", "A", "B", "C", "B", "A", "B", "C"};
        String[] GoranArr = {"C", "C", "A", "A", "B", "B", "C", "C", "A", "A", "B", "B"};
        Scanner scan = new Scanner(System.in);
        System.out.print("Please input the number of question to correct: ");
        int quest = scan.nextInt();
        String[] arr = new String[quest];

        for (int i = 0; i < quest; i++) {
            System.out.print("Please input the correct answers: ");
            String answer = scan.next();
            arr[i] = answer;
        }

        int adrain = 0;
        int bruno = 0;
        int goran = 0;
        String[] name = {"adrain", "bruno", "goran"};

        for (int i = 0; i < quest; i++) {
            boolean adrainCheck = AdrainArr[i].equals(arr[i]);
            boolean brunoCheck = BrunoArr[i].equals(arr[i]);
            boolean goranCheck = GoranArr[i].equals(arr[i]);
            if (adrainCheck && brunoCheck && goranCheck) {
                adrain += 1;
                bruno += 1;
                goran += 1;
            }
            else if (adrainCheck && brunoCheck) {
                adrain += 1;
                bruno += 1;
            }
            else if (adrainCheck && goranCheck) {
                adrain += 1;
                goran += 1;
            }
            else if (brunoCheck && goranCheck) {
                bruno += 1;
                goran += 1;
            }
            else if (brunoCheck) {
                bruno += 1;
            }
            else if (adrainCheck) {
                adrain += 1;
            }
            else if (goranCheck) {
                goran += 1;
            }
        }

        if (adrain >= 3 && bruno >= 3 && goran >= 3) {
            int result = (adrain + bruno + goran)/3;
            System.out.print(result+ "\n");
            for (String s : name) {
                System.out.println(s);
            }
        } else if (adrain >= 3) {
            System.out.print(adrain+"\n");
            System.out.print(name[0]);
        } else if (bruno >= 3) {
            System.out.print(bruno+"\n");
            System.out.print(name[1]);
        } else if (goran >= 3) {
            System.out.print(goran+"\n");
            System.out.print(name[2]);
        }
    }
}
