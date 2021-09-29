package com.dlex.Farm;

public class Farm {
    private final String[] animals = {"chick", "cow", "dog", "pig"};
    private final String[] sounds = {"cluck", "moo", "woof", "oink"};
    private final int[] counts = new int[4];

    public void sequenceAnimals(String animal) {
        String[] arr = animal.split(" ");
        String[] output = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < animals.length; j++) {
                if (arr[i].equals(animals[j])) {
                    output[i] = sounds[j];
                    counts[j] += 1;
                }
            }
        }
        for (int x = 0; x < arr.length; x++) {
            System.out.println(arr[x] + ":  " + output[x]);
        }

        String labelAnimal = String.format("\n%-10s", "Animal");
        String labelCount = String.format("%-10s", "Count");
        String line1 = String.format("\n%-10s", "______");
        String line2 = String.format("%-10s", "_____");
        String head = labelAnimal + labelCount + line1 + line2;
        System.out.println(head);
        for (int y = 0; y < animals.length; y++) {
            String showAnimal = String.format("%-10s", animals[y]);
            String showCount = String.format("%-10s", counts[y]);
            System.out.println(showAnimal + showCount);
        }
    }
}
