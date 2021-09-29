package com.dlex.CalcLexer;

public class Driver {
    public static void main(String[] args) {
        CalcLexer calcLexer = new CalcLexer("Solo");
        String error = calcLexer.errorMessage;
        System.out.println(error);

        CalcParser calcParser = new CalcParser("Lex");
        String secondError = calcParser.errorMessage;
        System.out.println(secondError);
    }
}
