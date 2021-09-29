package com.dlex.OOC.Week5.CompactPolynomial;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class CompactPolynomial {

    private ArrayList<ArrayList<String>> coefficients = new ArrayList<>();

    CompactPolynomial(double... coefficients) {
        this.coefficients = handleInsert(coefficients);
    }

    CompactPolynomial(ArrayList<ArrayList<String>> coefficients) {
        this.coefficients = coefficients;
    }

    CompactPolynomial(String filename) {
        try {
            Scanner scanner = new Scanner(new File(filename));
            int count = 0;
            while(scanner.hasNext()) {
                ArrayList<String> insert = new ArrayList<>();
                double value = scanner.nextDouble();
                if (value != 0) {
                    insert.add(String.valueOf(value));
                    insert.add(String.valueOf(count));
                    this.coefficients.add(insert);
                }
                count += 1;
            }
            System.out.println(Arrays.toString(this.coefficients.toArray()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private ArrayList<ArrayList<String>> handleInsert(double[] coefficients) {
        ArrayList<ArrayList<String>> temp = new ArrayList<>();
        for (int i = 0; i < coefficients.length; i++) {
            ArrayList<String> insert = new ArrayList<>();
            if (coefficients[i] != 0) {
                insert.add(String.valueOf(coefficients[i]));
                insert.add(String.valueOf(i));
                temp.add(insert);
            }
        }
        return temp;
    }

    public ArrayList<ArrayList<String>> getCoefficients() {
        return coefficients;
    }

    int getDegree() {
        return Integer.parseInt(this.coefficients.get(this.coefficients.size() - 1).get(1));
    }

    public String toString() {
        StringBuilder temp = new StringBuilder();
        for (int i = this.coefficients.size() - 1; i >= 0; i--) {
            ArrayList<String> result = this.coefficients.get(i);
            temp.append(result.get(0)).append(Integer.parseInt(result.get(1)) != 0 ? "X^" + result.get(1) + " + " : "");
        }
        return temp.toString();
    }

    double evaluate(double value) {
        double temp = 0.0;
        for (int i = this.coefficients.size() - 1; i >= 0; i--) {
            ArrayList<String> result = this.coefficients.get(i);
            temp += Double.parseDouble(result.get(0)) * Math.pow(value, Integer.parseInt(result.get(1)));
        }
        return temp;
    }

    public CompactPolynomial add(CompactPolynomial data) {
        CompactPolynomial result = this;
        if (result.getDegree() < data.getDegree()) {
            result = data;
            data = this;
        }

        ArrayList<ArrayList<String>> current = result.getCoefficients();
        ArrayList<ArrayList<String>> another = data.getCoefficients();
        for (int i = 0; i < current.size(); i++) {
            if (i > another.size() - 1) {
                continue;
            }
            ArrayList<String> temp = new ArrayList<>();
            temp.add(String.valueOf(Double.parseDouble(current.get(i).get(0)) + Double.parseDouble(another.get(i).get(0))));
            temp.add(String.valueOf(i));
            current.set(i, temp);
        }
        return new CompactPolynomial(current);
    }


    public CompactPolynomial multiply(CompactPolynomial data)
    {
        ArrayList<ArrayList<String>> current = new ArrayList<>();
        ArrayList<ArrayList<String>> another = data.getCoefficients();
        for (int i =0; i < (this.getDegree() + data.getDegree() + 1); i++)
        {
            double temp = 0.0;
            for (int j = 0; j <= i; j++)
            {
                if (j > this.coefficients.size() - 1) {
                    continue;
                }
                if (i - j > another.size() - 1) {
                    continue;
                }
                temp += Double.parseDouble(this.coefficients.get(j).get(0)) * Double.parseDouble(another.get(i - j).get(0));
            }
            ArrayList<String> array = new ArrayList<>();
            array.add(String.valueOf(temp));
            array.add(String.valueOf(i));
            current.add(i, array);
        }
        return new CompactPolynomial(current);
    }
}
