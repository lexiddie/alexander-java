package com.dlex.OOC.Week4.PizzaHit;

import java.util.Scanner;

public class PizzaDemo {

    public static void main(String[] args) {
        PizzaBuilder pizzaBuilder = new PizzaBuilder();

//        Pizza hawaiian = pizzaBuilder.hawaiian();
//        hawaiian.showChoice();
//        System.out.format("Total price: %.2f", hawaiian.getPrice());
//        System.out.println();
//        System.out.println();
//
//        Pizza chickenMarinara = pizzaBuilder.chickenMarinara();
//        chickenMarinara.showChoice();
//        System.out.format("Total price: %.2f", chickenMarinara.getPrice());
//        System.out.println();
//        System.out.println();

        //olive thin crust tomato sauce ham pepper
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input the choices to custom the Pizza order");
        String input = scanner.nextLine();
        String[] list = input.split(" ");
        Pizza order = pizzaBuilder.handleOrder(list);
        order.showChoice();
        System.out.format("Total price: %.2f", order.getPrice());
        scanner.close();
    }
}
