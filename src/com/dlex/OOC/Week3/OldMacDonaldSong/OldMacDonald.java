package com.dlex.OOC.Week3.OldMacDonaldSong;

import java.util.Scanner;

public class OldMacDonald {

	public static void main(String[] args) {
		//cow pig chick, chick dog horse pig
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		FarmBuilder farmBuilder = new FarmBuilder();
		Farm farm = farmBuilder.buildFarm(input.split(" "));
		farm.printStatus();
		Song song = new Song();
		song.printSong(farm);
		scanner.close();
	}

}
