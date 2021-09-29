package com.dlex.OOC.Week5.CompactPolynomial;

public class Driver {

    public static void main(String[] args) {

        CompactPolynomial p1 = new CompactPolynomial(1.1, 2.23, 5.3, 9.4, 25.5);
        CompactPolynomial p2 = new CompactPolynomial(10.0, 22.0, 10.0, 3.0, 9.5, 7.0);
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(p1.add(p2).toString());
        System.out.println(p1.multiply(p2).toString());
    }
}
