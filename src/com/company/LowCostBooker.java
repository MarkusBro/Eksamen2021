package com.company;

import java.util.*;

public class LowCostBooker {
    // field and method declarations problem 1b

    /**
     * Finds and returns the flights that will take the customer
     * from one airport, to the other at minimum cost,
     *
     * @param from the starting airport
     * @param to   the destination airport
     */


    public List<Flight> bookFlights(Flight from, Flight to) {
        // field and method declarations problem 1b
        Map<Flight, Flight> lowFlight = new HashMap<>();
        Flight currentFligh = from;
        Flight previousFlight = from;

        Queue<Flight> queue = new LinkedList<>();
        queue.add(currentFligh);


        Set<Flight> visitedFlight = new HashSet<>();
        visitedFlight.add(currentFligh);

        while(!queue.isEmpty()){
            currentFligh = queue.remove();
            if (currentFligh.equals(to)){
                if (!previousFlight.equals(currentFligh)){
                    lowFlight.put(previousFlight, currentFligh);
                }
                break;
            }else {
                for (Flight nextFlight : currentFligh.getNextFlight()){
                    if (!visitedFlight.contains(nextFlight)){
                        queue.add(nextFlight);
                        visitedFlight.add(nextFlight);
                    }
                }
            }
        }


        return bookFlights(from, to);
    }
}
