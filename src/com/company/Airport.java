package com.company;

import java.util.ArrayList;

public class Airport {
    private String name;
    private ArrayList<Flight> flights;


    public Airport(String name, ArrayList<Flight> flights) {
        this.name = name;
        this.flights = flights;
    }
}
