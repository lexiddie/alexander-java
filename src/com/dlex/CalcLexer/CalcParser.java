package com.dlex.CalcLexer;

public class CalcParser extends CalcError {

  private final CalcLexer lexer;
  private double value;

  public CalcParser(String s) {
    super();
    lexer = new CalcLexer(s);
    errorMessage = lexer.getErrorMessage();
    if (errorMessage != null) return;

    value = parseExpression();
    if (errorMessage != null) return;

    match(CalcLexer.EOLN_TOKEN);
  }

  public String getValue() {
    return Double.toString(value);
  }

  private void match(int token) {
    if (lexer.nextToken() != token) {
      if (token == CalcLexer.EOLN_TOKEN)
        errorMessage = 
          "Unexpected text after the expression.";
      else if (token == CalcLexer.NUMBER_TOKEN) 
        errorMessage = "Expected a number.";
      else errorMessage = 
             "Expected a " + ((char) token) + ".";
      return;
    }
    lexer.advance();
      errorMessage = lexer.getErrorMessage();
  }

  private double parseExpression() {
    double result = parseMulExp();
    if (errorMessage != null) return result;
    while (true) {
      if (lexer.nextToken() == '+') {
        match('+');
        if (errorMessage != null) return result;
        result += parseMulExp();
        if (errorMessage != null) return result;
      } else if (lexer.nextToken() == '-') {
        match('-');
        if (errorMessage != null) return result;
        result -= parseMulExp();
        if (errorMessage != null) return result;
      } else return result;
    }
  }

  private double parseMulExp() {
    double result = parseRootExp();
    if (errorMessage != null) return result;

    while (true) {
      if (lexer.nextToken() == '*') {
        match('*');
        if (errorMessage != null) return result;
        result *= parseRootExp();
        if (errorMessage != null) return result;
      } else if (lexer.nextToken() == '/') {
        match('/');
        if (errorMessage != null) return result;
        result /= parseRootExp();
        if (errorMessage != null) return result;
      } else return result;
    }
  }

  private double parseRootExp() {
    double result = 0.0;
    if (lexer.nextToken() == '(') {
      match('(');
      if (errorMessage != null) return result;
      result = parseExpression();
      if (errorMessage != null) return result;
      match(')');
      if (errorMessage != null) return result;
    }
    else if (lexer.nextToken() ==CalcLexer.NUMBER_TOKEN) {
      result = lexer.getNum();
      if (errorMessage != null) return result;
      match(CalcLexer.NUMBER_TOKEN);
      if (errorMessage != null) return result;
    }
    else {
      errorMessage = 
        "Expected a number or a parenthesis.";
    }
    return result;
  }

}