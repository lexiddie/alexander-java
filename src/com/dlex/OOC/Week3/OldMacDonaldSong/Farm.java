package com.dlex.OOC.Week3.OldMacDonaldSong;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

class Farm {

	private final ArrayList<Animal> animals = new ArrayList<>();
	
    void addAnimal(Animal animal) {
    	this.animals.add(animal);
	}
	
	Iterator<Animal> iterator() {
		return this.animals.iterator();
	}
	
	Iterator<Animal> iteratorUnique() {
		ArrayList<Animal> temp = new ArrayList<>();
		for (Animal a : this.animals) {
			if (!temp.contains(a)) {
				temp.add(a);
			}
		}
		return temp.iterator();
	}
	
	void printStatus() {
		ArrayList<Integer> counts = new ArrayList<>();
		ArrayList<String> checks = new ArrayList<>();
		ArrayList<Animal> temp = new ArrayList<>(this.animals);
		temp.sort(Comparator.comparing(Animal::getName));
		for (Animal i : temp) {
			if (!checks.contains(i.getName())) {
				checks.add(i.getName());
				counts.add(1);
			} else {
				int index = checks.indexOf(i.getName());
				counts.add(index, counts.get(index) + 1);
			}
		}
		String label = String.format("%12s", "Animal Count");
		String line = String.format("%12s", "------ -----");
		System.out.println(label);
		System.out.println(line);
		for (int i = 0; i < checks.size(); i++) {
			System.out.printf("%-7s", checks.get(i).toLowerCase());
			System.out.printf("%-6s", counts.get(i));
			System.out.println();
		}
	}
    
}
