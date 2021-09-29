package com.dlex.Map;

public class MapDriver {
	public static void main(String[] args) {
		Map map = new Map(5);
		map.addCity("BKK");
		map.addCity("NS");
		map.addCity("RY");
		map.addCity("HH");
		map.addCity("CNX");
		map.connect("BKK", "NS", 150);
		map.connect("BKK", "HH", 220);
		map.connect("BKK", "RY", 100);
		map.connect("HH", "CNX", 300);
		map.connect("HH", "BKK", 50);
		map.connect("RY", "HH", 100);
		map.connect("HH", "NS", 400);
		System.out.println(map);
	}

}
