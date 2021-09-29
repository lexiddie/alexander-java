package com.dlex;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ElementDemo {

    public static void main(String[] args) {
        Element[] elements = new Element[101];
        File elementFile = new File("periodic.txt");
        int count = loadElements(elementFile, elements);
        printPeriodicTable(elements);
        System.out.println("There are " + count + " elements.");

        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter 1 to search name: \nEnter 2 to search symbol: \nEnter 3 to Quit");
            int n = scan.nextInt();
            if (n == 1) {
                System.out.print("Input the element name to search: ");
                String name = scan.next();
                int index = searchName(elements,name);
                if (index == -1) {
                    System.out.println("Element Symbol does not found!!");
                } else {
                    System.out.println(elements[index].toString());
                }
            } else if (n == 2) {
                System.out.print("Input the element symbol to search: ");
                String symbol = scan.next();
                int index = searchSymbol(elements,symbol);
                if (index == -1) {
                    System.out.println("Element Symbol does not found!!");
                } else {
                    System.out.println(elements[index].toString());
                }
            } else {
                System.out.print("Quit");
                scan.close();
                return;
            }
        }

    }

    public static int loadElements(File elementFile, Element[] elements) {
        int count = 0;
        try {
            Scanner scan = new Scanner(elementFile);
            while (scan.hasNext()) {
                String name;
                String symbol;
                int number;
                int group;
                int period;
                double mass;

                String buffer = scan.nextLine();
                StringTokenizer st = new StringTokenizer(buffer);
                name = st.nextToken();
                symbol = st.nextToken();
                number = Integer.parseInt(st.nextToken());
                group = Integer.parseInt(st.nextToken());
                period = Integer.parseInt(st.nextToken());
                mass = Double.parseDouble(st.nextToken());
                Element element = new Element(name, symbol, number, group, period, mass);
                elements[count] = element;
                count++;
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.err.print("File not found");
        }
        return count;
    }

    public static void printPeriodicTable(Element[] elements) {
        for (Element element : elements) {
            System.out.println(element.toString());
        }
    }

    public static int searchName(Element[] elements, String name) {
        for (int i = 0; i < elements.length; i++) {
            String checkName = elements[i].getName();
            if (name.equals(checkName)) {
                return i;
            }
        }
        return -1;
    }

    public static int searchSymbol(Element[] elements, String symbol) {
        for (int i = 0; i < elements.length; i++) {
            String checkSymbol = elements[i].getSymbol();
            if (symbol.equals(checkSymbol)) {
                return i;
            }
        }
        return -1;
    }
}
