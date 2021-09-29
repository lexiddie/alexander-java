package com.dlex.OOC.Week4.PizzaHit;

public abstract class Cheese implements Choice {
    @Override
    public abstract String name();

    @Override
    public float price() {
        return 40;
    }

    @Override
    public String toString() {
        return "Choice: " + this.name() + ", Price: " + this.price();
    }
}
