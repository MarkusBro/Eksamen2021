package com.company;

import java.util.Set;

public class Flight {
    // field and method declarations problem 1b
    private Integer number;
    private String fromAirport;
    private String toAirport;
    private Integer price;
    private Integer departureTime;
    private Integer arrivalTime;
    private Set<Flight> nextFlight;


    //Graph graph = new Graph();


    public Flight() {

    }

    public Flight(Integer number, String fromAirport, String toAirport, Integer price, Integer departureTime, Integer arrivalTime) {
        this.number = number;
        this.fromAirport = fromAirport;
        this.toAirport = toAirport;
        this.price = price;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public Set<Flight> getNextFlight(){
        return nextFlight;
    }

    // you may find these useful:
    // return the duration of the flight (time in the air)
    public int getDuration() {

        return arrivalTime - departureTime;
    }

    /**
     * return the time the customer has to wait on the ground,
     * when changing from this flight to f
     */

    public int getWaitingTime(Flight f) {
        return f.departureTime - this.arrivalTime;
    }
}


