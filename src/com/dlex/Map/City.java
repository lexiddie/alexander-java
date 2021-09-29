package com.dlex.Map;

public class City {

	private final String name;
	private final Connection[] connections;
	
	public City (String name) {
		this.name = name;
		connections = new Connection[4];
	}
	
	public String getName() {
		return name;
	}
	
	public Connection[] getConnections() {
		return connections;
	}
	
	public void addConnection(Connection connection) {
		for (int i=0; i<4; i++) {
			if (connections[i] == null) {
				connections[i] = connection;
				return;
			}
		}
	}
	
	public String toString() {
		StringBuilder result = new StringBuilder(name + "\n");
		for (int i=0; i<4; i++) {
			if (connections[i] != null) {
				result.append("-> ").append(connections[i]).append("\n");
			}
		}
		return result.toString();
	}
}
