package com.dlex.OOC.Week5.CompactPolynomial;
import org.junit.Test;

public class CompactPolynomialJUNIT {
    @Test
    public void testAddAndMultiply() {
        CompactPolynomial p1 = new CompactPolynomial(1.1, 2.23, 5.3, 9.4, 25.5);
        CompactPolynomial p2 = new CompactPolynomial(10.0, 22.0, 10.0, 3.0, 9.5);

        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(p1.add(p2).toString());
        System.out.println(p1.multiply(p2).toString());
    }

    @Test
    public void testValidDouble() {
        CompactPolynomial p1 = new CompactPolynomial(-10.0, 1.0, 5.0, 3.0, 9.0);
        System.out.println(p1.toString());
    }

    @Test
    public void testEvaluation() {
        CompactPolynomial p1 = new CompactPolynomial(-10.0, 1.0, 5.0, 3.0, 9.0);
        System.out.println(p1.toString());
        System.out.println(p1.evaluate(5));
    }
}
