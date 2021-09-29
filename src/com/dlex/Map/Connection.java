package com.dlex.Map;

public class Connection {

	private final City toCity;
	private final int distance;

	public Connection (City toCity, int distance) {
		this.toCity = toCity;
		this.distance = distance;
	}

	public City getToCity() {
		return toCity;
	}

	public int getDistance() {
		return distance;
	}

	public String toString() {
		String result = toCity.getName();
		result += " [" + distance + " km.]";
		return result;
	}
}
