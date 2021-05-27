package com.company.Graph;

import java.util.LinkedList;

public class WeightedGraph {

    public static class Edge {

        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }
    public static class Graph{
        int vertices;
        LinkedList<Edge> [] adjecencyList;

        public Graph(int vertices){
            this.vertices = vertices;
            adjecencyList = new LinkedList[vertices];

            for (int i = 0; i < vertices; i++) {
                adjecencyList[i] = new LinkedList<>();
            }
        }
        public void addEdge(int source, int destination, int weight){
            Edge edge = new Edge(source,destination,weight);
            adjecencyList[source].addFirst(edge);
        }

        public void printGraph(){
            for (int i = 0; i < vertices ; i++) {
                LinkedList<Edge> list = adjecencyList[i];
                for (int j = 0; j < list.size() ; j++) {
                    System.out.println("vertex- " + i + " is connected to " +
                            list.get(j).destination + " wigth " + list.get(j).weight);
                }
            }
        }
    }
}
