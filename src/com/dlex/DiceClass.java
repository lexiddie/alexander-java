package com.dlex;

import java.util.Random;

public class DiceClass {

    private int diceValue;
    private int userValue;

    public DiceClass() {
        this.diceValue = Roll();
    }
    public int Roll() {
        Random randomNum = new Random();
        return randomNum.nextInt(6) + 1;
    }
    public int getDiceValue() {
        return this.diceValue;
    }
    public void setDiceValue(int n) {
        this.userValue = this.diceValue + n;
        this.diceValue += Roll();
    }
    public String HighLow(int n) {
        String[] check = {"Low", "Medium", "High"};
        if (n <= 12 && n >= 9) {
            return check[2];
        } else if (n <= 8 && n >= 5) {
            return check[1];
        } else {
            return check[0];
        }
    }
    public String Check() {
        String[] winlose = {"Win", "Lose"};
        if (HighLow(this.diceValue).equals(HighLow(this.userValue))) {
            return winlose[0];
        } else {
            return winlose[1];
        }
    }

}
