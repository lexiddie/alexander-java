package com.dlex.OOC.Week3.OldMacDonaldSong;

import java.util.ArrayList;
import java.util.Iterator;

class Song {

	private final static String[] sequences = {"Old MacDonald had a farm, E-I-E-I-O", "And on his farm he had some (animal), E-I-E-I-O", "With an (doubleSound) here and an (doubleSound) there", "Here a (sound) there a (sound)", "Everywhere a (doubleSound)"};
	private final ArrayList<Animal> animals = new ArrayList<>();

	void printSong(Farm farm) {
		StringBuilder sequel = new StringBuilder();
		for (Iterator<Animal> it = farm.iteratorUnique(); it.hasNext(); ) {
			Animal i = it.next();
			sequel.append(i.getName()).append(" ");
			animals.add(i);
		}
		System.out.println();
		System.out.println("Old MacDonald Song");
		System.out.println("------------------");
		sequenceAnimals(sequel.toString());
	}

	private void sequenceAnimals(String sequel) {
		String[] arr = sequel.split(" ");
		for (int i = 0; i < arr.length; i++) {
			int toLoop = i;
			for (String j : sequences) {
				printSequence(arr[i].toLowerCase(), j);
				System.out.println();
			}
			while (toLoop != 0) {
				toLoop -= 1;
				for (int x = 2; x < 5; x++) {
					printSequence(arr[toLoop].toLowerCase(), sequences[x]);
					System.out.println();
				}

			}
			System.out.println(sequences[0]);
			System.out.println("\n");
		}
	}

	private void printSequence(String animal, String sequence) {
		for (String i : sequence.split(" ")) {
			if (i.contains("(animal),") || i.contains("(doubleSound)") || i.contains("(sound)")) {
				System.out.print(getValue(animal, i) + " ");
			} else {
				System.out.print(i + " ");
			}

		}
	}

	private String getValue(String animal, String target) {
		int index = 0;
		for (int i = 0; i < animals.size(); i++) {
			if (animal.equals(animals.get(i).getName().toLowerCase())) {
				index = i;
				break;
			}
		}
		if (target.equals("(animal),")) {
			return animals.get(index).getName().toLowerCase() + "s";
		} else if (target.equals("(sound)")) {
			return animals.get(index).getSound().toLowerCase();
		} else {
			return animals.get(index).getSound().toLowerCase() + "-" + animals.get(index).getSound().toLowerCase();
		}
	}
}
