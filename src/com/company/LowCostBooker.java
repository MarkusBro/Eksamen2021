package com.company;

import com.company.Graph.WeightedGraph;

import java.util.HashMap;

public class LowCostBooker {
    // field and method declarations problem 1b

    /**
     * Finds and returns the flights that will take the customer
     * from one airport, to the other at minimum cost,
     *
     * @param start the starting airport
     * @param end   the destination airport
     */
    WeightedGraph weightedGraph;

    public void bookFlightsLowCost(Airport start, Airport end) {
        // field and method declarations problem 1b
        HashMap<Airport, Airport> changedAt = new HashMap<>();
        changedAt.put(start, null);

        HashMap<Airport, Double> lowCostPath = new HashMap<>();

        for (Airport airport : weightedGraph.getAirports()) {
            if (airport == start)
                lowCostPath.put(start, 0.0);
            else lowCostPath.put(airport, Double.POSITIVE_INFINITY);
        }

        for (Flight flight : start.getFlights()) {
            lowCostPath.put(flight.getDestination(), flight.getPrice());
            changedAt.put(flight.destination, start);
        }
        start.visit();

        while (true) {
            Airport currentAirport = closestAirport(lowCostPath);

            if (currentAirport == end) {
                System.out.println("Den billigste reisen mellom " + start.getName() + " og " + end.getName());

                Airport child = end;

                String path = end.getName();
                while (true) {
                    Airport parent = changedAt.get(child);
                    if (parent == child) {
                        break;
                    }
                    path = parent.getName() + " " + path;
                    child = parent;
                }
                System.out.println(path);
                System.out.println("Denne flyreisen koster " + lowCostPath.get(end));
                return;
            }
            currentAirport.visit();

            for (Flight flight : currentAirport.getFlights()) {
                if (flight.getDestination().isVisited())
                    continue;
                if (lowCostPath.get(currentAirport)
                        + flight.getPrice() < lowCostPath.get(flight.destination)) {
                    lowCostPath.put(flight.destination, lowCostPath.get(currentAirport) + flight.getPrice());
                    changedAt.put(flight.destination, currentAirport);
                }
            }
        }
    }

    private Airport closestAirport(HashMap<Airport, Double> lowCostPath) {
        double lowCost = Double.POSITIVE_INFINITY;
        Airport closestAirport = null;
        for (Airport airport : weightedGraph.getAirports()) {
            if (airport.isVisited())
                continue;
            double currentDistance = lowCostPath.get(airport);
            if (currentDistance == Double.POSITIVE_INFINITY)
                continue;
            if (currentDistance < lowCost) {
                lowCost = currentDistance;
                closestAirport = airport;
            }
        }
        return closestAirport;
    }
}
