package graphs;

import adts.IWeightedUndirectedGraph;

import java.util.*;

/**
 * The `MyGraph` class is a graph that uses an adjacency list to store the vertices and edges
 * @author Jacob J
 * @version 1.0
 */
public class MyGraph<V> implements IWeightedUndirectedGraph<V> {

    private Map<V, Node> adjacencyList = new HashMap<>();

    @Override
    public boolean addVertex(V element) {

        // Checking if the element is already in the graph.
        if (containsVertex(element)) {
            return false;
        }
        adjacencyList.put(element,null); // Adding the element to the graph. (the value is null because it is the
        // first element in the list)
        return true;
    }

    @Override
    public boolean addVertex(V... elements) {
        boolean result = true; // The result of the method.

        for (V element : elements) { // Iterating through the elements.

            boolean added = addVertex(element); // Adding each element to the graph.
            result = result && added; // If one of the elements is not added, the result will be false.
        }
        return result;
    }

    @Override
    public boolean addEdge(V first, V second, int weight) {
        if (containsEdge(first, second)) { // Checking if the edge is already in the graph.
            return false;
        }
        Node oldHeadFirst = adjacencyList.get(first); // Getting the old head of the first element.
        Node oldHeadSecond = adjacencyList.get(second); // Getting the old head of the second element.

        if (oldHeadFirst == null) { // If the first element is the first element in the list.

            adjacencyList.put(first, new Node(second, weight)); // Adding the second element to the list.
        }
        else { // If the first element is not the first element in the list.


            adjacencyList.put(first, new Node(second, weight, oldHeadFirst));// putting a new node at the start of
            // the linked list.
        }

        if (oldHeadSecond == null) { // If the second element is the first element in the list.

            adjacencyList.put(second, new Node(first, weight)); // Adding the first element to the list.
        }
        else { // If the second element is not the first element in the list.

            adjacencyList.put(second, new Node(first, weight, oldHeadSecond));// putting a new node at the start of
            // the linked list.
        }
        return true;
    }

    @Override
    public boolean containsVertex(V search) {
        return adjacencyList.containsKey(search);
    }

    @Override
    public boolean containsEdge(V first, V second) {
        return false;
    }

    @Override
    public boolean removeVertex(V element) {
        return false;
    }

    @Override
    public boolean removeEdge(V first, V second) {
        return false;
    }

    @Override
    public int vertexSize() {
        return 0;
    }

    @Override
    public int edgeSize() {
        return 0;
    }

    @Override
    public int degree(V vertex) {
        return 0;
    }

    //inner class
    private class Node{

        private V otherVertex; //the other vertex in the edge
        private int weight; //the weight of the edge


        private Node next; //next node in the linked list

        public Node(V otherVertex, int weight){
            this.otherVertex = otherVertex;
            this.weight = weight;
        }

        public Node(V otherVertex, int weight, Node next){
            this.otherVertex = otherVertex;
            this.weight = weight;
            this.next = next;
        }
    }
}
