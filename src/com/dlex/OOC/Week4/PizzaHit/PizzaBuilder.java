package com.dlex.OOC.Week4.PizzaHit;


public class PizzaBuilder {

    private final static Choice[] choices = { new AlfredoSauce(), new GoatCheese(), new GrilledChicken(), new Ham(), new MarinaraSauce(), new MozzarellaCheese(), new Olive(), new Onion(), new Pepper(), new Pineapple(), new ThickCrust(), new ThinCrust(), new TomatoSauce(), new Turkey()};

    Pizza hawaiian() {
        Pizza pizza = new Pizza();
        pizza.addChoice(new ThickCrust());
        pizza.addChoice(new TomatoSauce());
        pizza.addChoice(new Ham());
        pizza.addChoice(new Pineapple());
        pizza.addChoice(new Onion());
        return pizza;
    }

    Pizza chickenMarinara() {
        Pizza pizza = new Pizza();
        pizza.addChoice(new ThickCrust());
        pizza.addChoice(new MarinaraSauce());
        pizza.addChoice(new GrilledChicken());
        pizza.addChoice(new Olive());
        pizza.addChoice(new Pepper());
        return pizza;
    }

    Pizza handleOrder(String[] list) {
        Pizza pizza = new Pizza();
        for (String i : list) {
            for (Choice j : choices) {
                if (i.toLowerCase().equals(j.name().toLowerCase())) {
                    pizza.addChoice(j);
                    break;
                }
            }
        }
        return pizza;
    }
}
