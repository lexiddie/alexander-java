package com.dlex.OOC.Week4.PizzaHit;

public abstract class Topping implements Choice {

    @Override
    public abstract String name();

    @Override
    public float price() {
        return 15;
    }

    @Override
    public String toString() {
        return "Choice: " + this.name() + ", Price: " + this.price();
    }
}
