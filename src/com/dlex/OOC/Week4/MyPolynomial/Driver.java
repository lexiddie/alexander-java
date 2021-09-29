package com.dlex.OOC.Week4.MyPolynomial;

public class Driver {

    public static void main(String[] args) {

        MyPolynomial p1 = new MyPolynomial(1.1, 2.23, 5.3, 9.4, 25.5);
        MyPolynomial p2 = new MyPolynomial(10.0, 22.0, 10.0, 3.0, 9.5, 7.0);
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(p1.add(p2).toString());
        System.out.println(p1.multiply(p2).toString());

    }
}
