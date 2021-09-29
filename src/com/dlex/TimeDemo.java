package com.dlex;

import java.util.Scanner;

public class TimeDemo {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Input the hour: ");
        int hour = scan.nextInt();
        System.out.print("Input the minute: ");
        int minute = scan.nextInt();
        System.out.print("Input the second: ");
        int second = scan.nextInt();
        scan.close();
        Time time = new Time();
        System.out.println("Format to 12 Hours method: " + time.to12HourFormat(hour, minute, second));
        System.out.println("Format to String method:  " + time);
    }
}
