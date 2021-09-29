package com.dlex.CardGame;

import java.util.ArrayList;
import java.util.Random;

public class Card {

    private final ArrayList<String> ranTotalCards = new ArrayList<>();
    private final ArrayList<Integer> ranTotalResults = new ArrayList<>();
    private final String[] ranks = { "Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
    private final String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
    private String ranGame;

    public void randomCards() {
        Random random = new Random();
        int ranRanks = random.nextInt(13);
        int ranSuits = random.nextInt(4);
        String insert = ranks[ranRanks] + " of " + suits[ranSuits];
        this.setRanGame(insert);
        this.ranTotalCards.add(insert);
    }

    public int guessCards(int rank, int suit, int tries) {
        String[] check = this.ranGame.split(" ");
        if (check[0].equals(this.ranks[rank-1]) && check[2].equals(this.suits[suit-1])) {
            this.ranTotalResults.add(1);
            return 0;
        } else if (check[0].equals(this.ranks[rank-1])) {
            if (tries == 5)
                this.ranTotalResults.add(0);
            return 1;
        } else if (check[2].equals(this.suits[suit-1])) {
            if (tries == 5)
                this.ranTotalResults.add(0);
            return 2;
        } else {
            if (tries == 5)
                this.ranTotalResults.add(0);
            return 3;
        }
    }

    public String getRanGame() {
        return ranGame;
    }

    private void setRanGame(String ranGame) {
        this.ranGame = ranGame;
    }

    @Override
    public String toString() {
        StringBuilder build = new StringBuilder();
        String card = String.format("%20s", "Card");
        String result = String.format("%20s", "Result\n");
        String line1 = String.format("%20s", "____");
        String line2 = String.format("%20s", "______\n");
        build.append(card).append(result).append(line1).append(line2);
        for (int i = 0; i < ranTotalCards.size(); i++) {
            String showCard = ranTotalCards.get(i);
            int showResult = ranTotalResults.get(i);
            String cards = String.format("%20s", showCard);
            String check = "";
            if (showResult == 1) {
                check = "You won";
            } else {
                check = "You lost";
            }
            String results = String.format("%20s", check);
            build.append(cards).append(results).append("\n");
        }
        System.out.println(this.ranTotalCards.size());
        return build.toString();
    }
}
