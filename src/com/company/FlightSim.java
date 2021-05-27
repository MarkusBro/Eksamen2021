package com.company;

import com.company.Graph.WeightedGraph;

public class FlightSim {


    private static final FlightSim theInstance = new FlightSim();

    public static FlightSim getInstance() {
        return theInstance;
    }

    public static void main(String[] args) {
        int vertices = 3;
        WeightedGraph.Graph graph = new WeightedGraph.Graph(vertices);
        graph.addEdge(0, 1, 100);
        graph.addEdge(0, 2, 400);
        graph.addEdge(1, 3, 300);
        graph.addEdge(2, 3, 300);
        graph.printGraph();

        
    }


}
