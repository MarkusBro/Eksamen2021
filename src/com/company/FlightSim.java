package com.company;

public class FlightSim {


    private static final FlightSim theInstance = new FlightSim();

    public static FlightSim getInstance() {
        return theInstance;
    }

    public static void main(String[]args){
        FlightSim sim = new FlightSim.getInstance();

    }

    
}
