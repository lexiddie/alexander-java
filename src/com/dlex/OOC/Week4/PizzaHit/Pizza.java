package com.dlex.OOC.Week4.PizzaHit;

import java.util.ArrayList;
import java.util.List;

public class Pizza {

    private final List<Choice> items = new ArrayList<>();

    void addChoice(Choice item) {
        this.items.add(item);
    }

    public float getPrice() {
        float count = 0;
        for (Choice i : items) {
            count += i.price();
        }
        return (count - (count * 5 / 100));
    }

    void showChoice() {
        for (Choice i : items) {
            System.out.println(i);
        }
    }
}
