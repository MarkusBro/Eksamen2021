package com.company.Graph;

import com.company.Airport;
import com.company.Flight;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class WeightedGraph {

    private final static WeightedGraph theInstance = new WeightedGraph(true);

    private HashMap<Airport, LinkedList<Airport>> adjacencyMap;
    private Set<Airport> airports;
    private boolean directed;

    public static WeightedGraph getInstance() {
        return theInstance;
    }


    public WeightedGraph(boolean directed) {
        this.directed = directed;
        airports = new HashSet<>();
    }

    public void addEdgeHelper(Airport a, Airport b, double price) {
        for (Flight flight : a.getFlights()) {
            if (flight.getSource() == a && flight.getDestination() == b) {
                flight.setPrice(price);
                return;
            }
        }
        a.getFlights().add(new Flight(a, b, price));
    }

    public void addEdge(Airport source, Airport destination, double price) {
        airports.add(source);
        airports.add(destination);

        addEdgeHelper(source, destination, price);

        if (!directed && source != destination) {
            addEdgeHelper(source, destination, price);
        }
        
    }

    public void printEdges() {
        for (Airport airport : adjacencyMap.keySet()) {
            System.out.println(airport.getName() + " har fly til: ");
            if (adjacencyMap.get(airport) != null) {
                for (Airport neighbor : adjacencyMap.get(airport)) {
                    System.out.println(neighbor.getName() + "");
                }
                System.out.println();
            } else {
                System.out.println("None");
            }
        }
    }

    public boolean hasEdge(Airport source, Airport destination) {
        return adjacencyMap.containsKey(source) && adjacencyMap.get(source) != null
                && adjacencyMap.get(source).contains(destination);
    }


}
