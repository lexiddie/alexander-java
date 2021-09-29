package com.dlex.OOC.Week3.OldMacDonaldSong;

import java.util.Iterator;

class FarmBuilder {

	final static private Animal[] animals = { new Cow("Cow", "Moo"), new Chick("Chick", "Cluck"), new Dog("Dog", "Woof"), new Horse("Horse", "Neigh"), new Pig("Pig", "Oink")};
	
	Farm buildFarm(String[] names) {
		Farm farm = new Farm();
		for (String name : names) {
			for (Animal animal : animals) {
				if (name.equals(animal.getName().toLowerCase())) {
					farm.addAnimal(animal);
					break;
				}
			}
		}
		for (Iterator<Animal> it = farm.iterator(); it.hasNext(); ) {
			Animal i = it.next();

			System.out.println(i);
		}
		System.out.println();
		return farm;
	}

}
