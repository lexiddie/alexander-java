package com.dlex.Dijkstra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Dijkstra {
    void computeShortestPaths(Vertex sourceVertex) {
        sourceVertex.setDistance(0);
        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(sourceVertex);
        sourceVertex.setVisited(true);

        while( !priorityQueue.isEmpty() ) {
            // Getting the minimum distance vertex from priority queue
            Vertex actualVertex = priorityQueue.poll();

            for(Edge edge : actualVertex.getAdjacencyList()) {

                Vertex v = edge.getTargetVertex();
                if (!v.isVisited())
                {
                    double newDistance = actualVertex.getDistance() + edge.getWeight();

                    if ( newDistance < v.getDistance() ) {
                        priorityQueue.remove(v);
                        v.setDistance(newDistance);
                        v.setPredecessor(actualVertex);
                        priorityQueue.add(v);
                    }
                }
            }
            actualVertex.setVisited(true);
        }
    }

    List<Vertex> getShortestPathTo(Vertex targetVertex) {
        List<Vertex> path = new ArrayList<>();

        for(Vertex vertex = targetVertex; vertex!=null; vertex = vertex.getPredecessor()) {
            path.add(vertex);
        }

        Collections.reverse(path);
        return path;
    }

}