package com.dlex.Dijkstra;

import java.util.ArrayList;
import java.util.List;

public class Vertex implements Comparable<Vertex> {

    private String name;
    private List<Edge> adjacencyList;
    private boolean visited;
    private Vertex predecessor;
    private double distance = Double.MAX_VALUE;

    public Vertex(String name) {
        this.name = name;
        this.adjacencyList = new ArrayList<>();
    }

    public void addNeighbour(Edge edge) {
        this.adjacencyList.add(edge);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Edge> getAdjacencyList() {
        return adjacencyList;
    }

    public void setAdjacencyList(List<Edge> adjacencyList) {
        this.adjacencyList = adjacencyList;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Vertex getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Vertex predecessor) {
        this.predecessor = predecessor;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public int compareTo(Vertex otherVertex) {
        return Double.compare(this.distance, otherVertex.getDistance());
    }
}