package com.company;

import com.company.Graph.WeightedGraph;

import java.util.Set;

public class Flight implements Comparable<Flight> {
    // field and method declarations problem 1b
    Airport source;
    Airport destination;
    private Integer number;
    private String fromAirport;
    private String toAirport;
    private double price;
    private int departureTime;
    private int arrivalTime;




    public Flight(Airport s, Airport d, double p) {
        source =  s;
        destination = d;
        price = p;
    }
    public String toSting(){
        return String.format("(%s -> %s, %f", source.getName(), destination.getName(), price);
    }

    public int compareTo(Flight otherFlight){
        if (this.price > otherFlight.price){
            return 1;
        }
        else  return -1;
    }
    public Flight(Integer number, String fromAirport, String toAirport, int price, int departureTime, int arrivalTime) {
        this.number = number;
        this.fromAirport = fromAirport;
        this.toAirport = toAirport;
        this.price = price;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public Airport getSource() {
        return source;
    }

    public void setSource(Airport source) {
        this.source = source;
    }

    public Airport getDestination() {
        return destination;
    }

    public void setDestination(Airport destination) {
        this.destination = destination;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
// you may find these useful:
    // return the duration of the flight (time in the air)



    public int getDuration(int arrivalTime, int departureTime) {

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


