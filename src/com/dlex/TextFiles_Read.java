package com.dlex;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class TextFiles_Read {
    public static void main(String[] args) {
        File myFile = new File("message.txt");
        try {
            Scanner scan = new Scanner(myFile);
            while (scan.hasNext()) {
                System.out.println(scan.nextLine());
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.err.print("File not found");
        }

    }
}
