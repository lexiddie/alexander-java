package com.dlex.OOC.Week3.Meal;

import java.util.ArrayList;
import java.util.List;

public class Meal {

    private List<Sellable> items = new ArrayList<>();

    void addItem(Sellable item) {
        this.items.add(item);
    }

    public float getPrice() {
        float count = 0;
        for (Sellable i : items) {
            count += i.price();
        }
        return (count - (count * 5 / 100));
    }

    void showItems() {
        for (Sellable i : items) {
            System.out.println(i);
        }
    }
}
