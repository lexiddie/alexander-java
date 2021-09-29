//Sokvathara Lin 6018002package com.dlex.
package com.dlex.OOC.Week3.Meal;

class MealBuilder {

    Meal prepareVeggieMeal() {
        Meal meal = new Meal();
        meal.addItem(new VeggieBurger());
        meal.addItem(new Coke());
        return meal;
    }

    Meal prepareChickyMeal() {
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Sprite());
        return meal;
    }

    Meal prepareFamilyMeal() {
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new ChickenBurger());
        meal.addItem(new VeggieBurger());
        meal.addItem(new VeggieBurger());
        meal.addItem(new Coke());
        meal.addItem(new Coke());
        meal.addItem(new Coke());
        return meal;
    }

    Meal prepareThirstyMeal() {
        Meal meal = new Meal();
        meal.addItem(new Coke());
        meal.addItem(new Coke());
        return meal;
    }

    Meal prepareHungerMeal() {
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new ChickenBurger());
        return meal;
    }

    Meal prepareBrunchMeal() {
        Meal meal = new Meal();
        meal.addItem(new Coffee());
        meal.addItem(new FrenchFries());
        return meal;
    }

    Meal prepareHappyMeal() {
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Coffee());
        meal.addItem(new FrenchFries());
        return meal;
    }

    Meal prepareBeefyMeal() {
        Meal meal = new Meal();
        meal.addItem(new BeefBurger());
        meal.addItem(new MountainDew());
        meal.addItem(new FrenchFries());
        return meal;
    }


}
