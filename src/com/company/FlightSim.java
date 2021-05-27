package com.company;

import com.company.Graph.WeightedGraph;

import java.util.ArrayList;
import java.util.List;

public class FlightSim {

    private static final FlightSim theInstance = new FlightSim();
    private List<Flight> flights = new ArrayList<>();

    public static FlightSim getInstance() {
        return theInstance;
    }

    public static void main(String[] args) {
        FlightSim sim = FlightSim.getInstance();
        sim.run();


    }

    private void run() {
        newGraph();

    }

    public void printGraph() {
        WeightedGraph weightedGraph =  WeightedGraph.getInstance();
        weightedGraph.printEdges();
    }

    public void newGraph() {
        WeightedGraph weightedGraph = new WeightedGraph(true);
        Airport Kjevik = new Airport(0, "Kjevik");
        Airport Sola = new Airport(1, "Sola");
        Airport Gardemoen = new Airport(2, "Gardemoen");
        Airport Værnes = new Airport(3, "Værnes");

        weightedGraph.addEdge(Kjevik, Sola, 100);
        weightedGraph.addEdge(Kjevik, Gardemoen, 400);
        weightedGraph.addEdge(Sola, Værnes, 300);
        weightedGraph.addEdge(Gardemoen, Værnes, 300);

        weightedGraph.printEdges();
    }

    /*public void addEdges(){

    }*/
    public void getAirport(String name) {

    }


}
