package com.dlex.Dijkstra;

public class Edge {

    private double weight;
    private Vertex startVertex;
    private Vertex targetVertex;

    Edge(double weight, Vertex startVertex, Vertex targetVertex) {
        this.weight = weight;
        this.startVertex = startVertex;
        this.targetVertex = targetVertex;
    }

    double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Vertex getStartVertex() {
        return startVertex;
    }

    public void setStartVertex(Vertex startVertex) {
        this.startVertex = startVertex;
    }

    Vertex getTargetVertex() {
        return targetVertex;
    }

    public void setTargetVertex(Vertex targetVertex) {
        this.targetVertex = targetVertex;
    }
}