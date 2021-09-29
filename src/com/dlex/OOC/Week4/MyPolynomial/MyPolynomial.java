package com.dlex.OOC.Week4.MyPolynomial;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class MyPolynomial {

    private double[] coefficients;

    MyPolynomial(double... coefficients) {
        this.coefficients = coefficients;
    }

    MyPolynomial(String filename) {
        try {
            Scanner scanner = new Scanner(new File(filename));
            int degree = scanner.nextInt();
            coefficients = new double[degree + 1];
            for (int i = 0; i < coefficients.length; i++) {
                coefficients[i] = scanner.nextDouble();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public double[] getCoefficients() {
        return coefficients;
    }

    public void setCoefficients(double[] coefficients) {
        this.coefficients = coefficients;
    }

    public int getDegree() {
        return this.coefficients.length - 1;
    }

    public String toString() {
        StringBuilder temp = new StringBuilder();
        for (int i = coefficients.length - 1; i >= 0; i--) {
            temp.append(coefficients[i]).append(i != 0 ? "X^" + i + " + " : "");
        }
        return temp.toString();
    }

    public double evaluate(double value) {
        double temp = 0.0;
        for (int i = 0; i < this.coefficients.length; i++) {
            int currentIndex = this.coefficients.length - 1 - i;
            temp += this.coefficients[currentIndex] * Math.pow(value, currentIndex);
        }
        return temp;
    }

    public MyPolynomial add(MyPolynomial data)
    {
        MyPolynomial result = this;
        if (result.getDegree() < data.getDegree()) {
            result = data;
            data = this;
        }

        double[] current  = result.getCoefficients();
        double[] another = data.getCoefficients();
        for (int i = 0; i < current.length; i++)
        {
            if (i > another.length-1) {
                continue;
            }
            current[i] += another[i];
        }
        return new MyPolynomial(current);
    }

    public MyPolynomial multiply(MyPolynomial data)
    {
        double[] current  = new double[this.getDegree() + data.getDegree() + 1];
        double[] another = data.getCoefficients();
        for (int i =0; i < current.length; i++)
        {
            double temp = 0.0;
            for (int j = 0; j <= i; j++)
            {
                if (j > this.coefficients.length-1) {
                    continue;
                }
                if (i-j > another.length-1) {
                    continue;
                }
                temp += this.coefficients[j] * another[i-j];
            }
            current[i] = temp;
        }
        return new MyPolynomial(current);
    }
}
