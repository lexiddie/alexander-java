package com.dlex;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class TextFiles_Write {
    public static void main(String[] args) {
        File writeData = new File("ToFriends.txt");
        try {
            PrintWriter input = new PrintWriter(writeData);
            input.println("It's gonna be fun");
            input.close();
        } catch (FileNotFoundException e) {
            System.err.print("File system doesn't exits");
        }
    }
}
