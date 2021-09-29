package com.dlex.OOC.Week3.Meal;

public class MealBuilderDemo {
    public static void main(String[] args) {
        MealBuilder builder = new MealBuilder();

        Meal happy = builder.prepareHappyMeal();
        happy.showItems();
        System.out.format("Total price: %.2f", happy.getPrice());
        System.out.println();
        System.out.println();

        Meal beefy = builder.prepareBeefyMeal();
        beefy.showItems();
        System.out.format("Total price: %.2f", beefy.getPrice());
        System.out.println();
        System.out.println();
    }
}
