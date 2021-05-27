package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

public class Airport {
    int n;
    private String name;
    private boolean visited;
    private LinkedList<Flight> flights;

    public Airport(int n, String name) {
        this.n = n;
        this.name = name;
        visited = false;
        flights = new LinkedList<>();
    }
    public boolean isVisited(){
        return visited;
    }
    public void visit(){
        visited = true;
    }
    public void unvisit(){
        visited = false;
    }

    public Airport(String name, LinkedList<Flight> flights) {
        this.name = name;
        this.flights = flights;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LinkedList<Flight> getFlights() {
        return flights;
    }

    public void setFlights(LinkedList<Flight> flights) {
        this.flights = flights;
    }
}
