package com.dlex;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GCContent {
    public static void main(String[] args) {
        File countFile = new File("DNA_sequence02.txt");
        try {
            Scanner scan = new Scanner(countFile);
            StringBuilder input = new StringBuilder();
            while (scan.hasNext()) {
                String buffer = scan.nextLine();
                input.append(buffer.toUpperCase());
            }
            scan.close();
            char[] toChar = input.toString().toCharArray();
            char[] check = {'A', 'T', 'G','C'};
            int[] count = new int[check.length];
            for (char c : toChar) {
                for (int j = 0; j < check.length; j++) {
                    if (c == check[j]) {
                        count[j] += 1;
                    }
                }
            }
            double math = ((count[2] + count[3]) * 100) / (count[0] + count[1] + count[2] + count[3]);
            System.out.println("GC content: " + math + " %");
            System.out.format("%.2f", math);
        } catch (FileNotFoundException e) {
            System.err.print("File is not found");
        }
    }
}
