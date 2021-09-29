package com.dlex.OOC.Week1.OldMacDonaldSong;

class Farm {

    private final static String[] sequences = {"Old MacDonald had a farm, E-I-E-I-O", "And on his farm he had some (animal), E-I-E-I-O", "With an (doubleSound) here and an (doubleSound) there", "Here a (sound) there a (sound)", "Everywhere a (doubleSound)"};

    private final static String[][] animals = {{"dog", "dogs", "woof"}, {"chick", "chicks", "cluck"}, {"cow", "cows", "moo"}, {"pig", "pigs", "oink"}};

    void sequenceAnimals(String sequel) {
        String[] arr = sequel.split(" ");
        for (int i = 0; i < arr.length; i++) {
            int toLoop = i;
            for (String j : sequences) {
                printSequence(arr[i], j);
                System.out.println();
            }
            while (toLoop != 0) {
                toLoop -= 1;
                for (int x = 2; x < 5; x++) {
                    printSequence(arr[toLoop], sequences[x]);
                    System.out.println();
                }

            }
            System.out.println(sequences[0]);
            System.out.println("\n");
        }
    }

    private void printSequence(String animal, String sequence) {
        String[] check = sequence.split(" ");
        for (String i : check) {
            if (i.contains("(animal),") || i.contains("(doubleSound)") || i.contains("(sound)")) {
                System.out.print(getValue(animal, i) + " ");
            } else {
                System.out.print(i + " ");
            }

        }
    }

    private String getValue(String animal, String target) {
        int index = 0;
        for (int i = 0; i < animals.length; i++) {
            if (animal.equals(animals[i][0])) {
                index = i;
                break;
            }
        }
        if (target.equals("(animal),")) {
            return animals[index][1];
        } else if (target.equals("(sound)")) {
            return animals[index][2];
        } else {
            return animals[index][2] + "-" + animals[index][2];
        }
    }

}
