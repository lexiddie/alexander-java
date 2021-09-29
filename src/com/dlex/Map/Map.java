package com.dlex.Map;

public class Map {

	private final City[] cities;
	private final int size;
	private int cityCount;
	
	public Map (int size) {
		cities = new City[size];
		for (int i=0; i<size; i++) {
			cities[i] = null;
		}
		this.size = size;
		cityCount = 0;
	}
	
	public void addCity(String cityName) {
		if (cityCount < size) {
			City city = new City(cityName);
			cities[cityCount] = city;
			cityCount++;
		}
	}
	
	public void connect(String from, String to, int distance) {
		City fromCity = searchCity(from);
		City toCity = searchCity(to);
		if (fromCity != null && toCity != null) {
			Connection connectTo = new Connection(toCity, distance);
			fromCity.addConnection(connectTo);
			Connection connectFrom = new Connection(fromCity, distance);
			toCity.addConnection(connectFrom);
		} else {
			System.out.println("City not found");
		}
	}
	
	private City searchCity(String name) {
		for (City city : cities) {
			if (city != null &&
				city.getName().equals(name)) {
				return city;
			}
		}
		return null;
	}
	
	public String toString() {
		StringBuilder result = new StringBuilder();
		for (int i=0; i < cityCount; i++) {
			result.append(cities[i]).append("\n");
		}
		return result.toString();
	}
}
