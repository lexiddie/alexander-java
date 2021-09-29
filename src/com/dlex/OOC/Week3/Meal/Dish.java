package com.dlex.OOC.Week3.Meal;

public abstract class Dish implements Sellable {
    @Override
    public abstract String name();

    @Override
    public Packaging packaging() {
        return new Plate();
    }

    @Override
    public abstract float price();

    @Override
    public String toString() {
        return "Item: " + this.name() + ", Packaging: " + this.packaging().pack() + ", Price: " + this.price();
    }
}
