package com.company;

import java.util.ArrayList;

public class Airport {
    private String name;
    private ArrayList<Flight> flights;


    public Airport(String name, ArrayList<Flight> flights) {
        this.name = name;
        this.flights = flights;
    }

    public ArrayList<Flight> getFlights() {
        return flights;
    }

    public void setFlights(ArrayList<Flight> flights) {
        this.flights = flights;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
