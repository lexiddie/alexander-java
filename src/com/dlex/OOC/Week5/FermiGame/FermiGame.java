package com.dlex.OOC.Week5.FermiGame;

import java.util.Arrays;
import java.util.Random;

public class FermiGame {

    private int[] values;

    public FermiGame() {
        this.values = generateValues();
    }

    private int[] generateValues() {
        int[] temp = new int[3];
        Random random = new Random();
        for (int i = 0; i < temp.length; i++) {
            temp[i] = random.nextInt(10);
        }
        return temp;
    }

    public int[] getValues() {
        return values;
    }

    public void setValues(int[] values) {
        this.values = values;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for ( int i : this.values) {
            stringBuilder.append(i).append(" ");
        }
        return stringBuilder.toString();
    }

    void checkGuess(String[] list) {
        String[] hints = new String[3];;
        StringBuilder guess = new StringBuilder();
        for (int i = 0; i < list.length; i++) {
            hints[i] = "";
            for (int j = 0; j < this.values.length; j++) {
                if (i == j && Integer.parseInt(list[i]) == this.values[j]) {
                    hints[i] = "Fermi";
                } else if (Integer.parseInt(list[i]) != this.values[j] && !hints[i].equals("Pico") && !hints[i].equals("Fermi")) {
                    hints[i] = "Nano";
                } else if (Integer.parseInt(list[i]) == this.values[j] && !hints[i].equals("Fermi")) {
                    hints[i] = "Pico";
                }
            }
            guess.append(list[i]).append(" ");
        }

        StringBuilder explanation = new StringBuilder();
        int countFermi = 0;
        int countNano = 0;
        int countPico = 0;
        for (int i = 0; i < hints.length; i++) {
            if (hints[i].equals("Fermi")) {
                countFermi++;
                explanation.append("The value ").append(list[i]).append(" matches at the correct position. ");
                if (countFermi == hints.length) {
                    explanation.setLength(0);
                    explanation.append("All match at the correct positions.");
                }
            } else if (hints[i].equals("Nano")) {
                countNano++;
                if (countNano == hints.length) {
                    explanation.setLength(0);
                    explanation.append("All value don't match.");
                }
            } else {
                countPico++;
                explanation.append("The value ").append(list[i]).append(" matches but at the wrong position. ");
                if (countPico == hints.length) {
                    explanation.setLength(0);
                    explanation.append("All match at the wrong positions.");
                }
            }
        }

        StringBuilder hint = new StringBuilder();

        Arrays.sort(hints);
        for (String i : hints) {
            hint.append(i).append(" ");
        }

        String labelGuess = String.format("%-12s", "Guess");
        String labelHint = String.format("%-20s", "Hint");
        String labelExplanation = String.format("%-12s", "Explanation");
        System.out.println(labelGuess + labelHint + labelExplanation);
        String resultGuess = String.format("%-12s", guess);
        String resultHint = String.format("%-20s", hint);
        String resultExplanation = String.format("%-12s", explanation.toString());
        System.out.println(resultGuess + resultHint + resultExplanation);
    }
}
