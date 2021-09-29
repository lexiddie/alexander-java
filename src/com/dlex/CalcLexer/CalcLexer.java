package com.dlex.CalcLexer;

public class CalcLexer extends CalcError {

  private final java.util.StringTokenizer tokens;
  private int tokenChar;
  private double tokenNum;
  public static final int NUMBER_TOKEN = -1;
  public static final int EOLN_TOKEN = -2;


  public CalcLexer(String s) {
    super();
    tokens = new java.util.StringTokenizer(s," \t\n\r+-*/()",true);
    advance();
  }


  public void advance() {

    while (true) {

      if (!tokens.hasMoreTokens()) {
        tokenChar = EOLN_TOKEN;
        return;
      }

      String s = tokens.nextToken();
      char c1 = s.charAt(0);
      if (s.length()>1 || Character.isDigit(c1)) {
        try {
          tokenNum = Double.parseDouble(s);
          tokenChar = NUMBER_TOKEN;
        } catch (NumberFormatException x) {
          errorMessage = "Illegal format for a number.";
        }
        return;
      }
      else if (!Character.isWhitespace(c1)) {
        tokenChar = c1;
        return;
      }
    }
  }

  public double getNum() {
    return tokenNum;
  }

  public int nextToken() {
    return tokenChar;
  }
}