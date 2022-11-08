package graphs;

import adts.Edge;
import adts.IWeightedUndirectedGraph;

import java.util.*;

/**
 * The `MyGraph` class is a graph that uses an adjacency list to store the vertices and edges
 *
 * @author Jacob J
 * @version 1.0
 */
public class MyGraph<V> implements IWeightedUndirectedGraph<V> {

    private Map<V, Node> adjacencyList = new HashMap<>();
    private int edgeCount = 0;
    private int vertexCount = 0;

    @Override
    public boolean addVertex(V element) {

        // Checking if the element is already in the graph.
        if (containsVertex(element)) {
            return false;
        }
        adjacencyList.put(element, null); // Adding the element to the graph. (the value is null because it is the
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

        addDirectedEdge(first, second, weight); // Adding the first edge to the graph.
        addDirectedEdge(second, first, weight); // Adding the second edge to the graph.
        edgeCount++; // Incrementing the edge count.
        edgeCount++; // Incrementing the edge count.
        return true;
    }

    /**
     * Adding a new node to the start of the linked list
     *
     * @param first  The first element in the edge.
     * @param second The second element in the edge.
     * @param weight The weight of the edge.
     */
    private void addDirectedEdge(V first, V second, int weight) {
        Node oldHead = adjacencyList.get(first); // Getting the old head of the first element.

        if (oldHead == null) { // If the first element is the first element in the list.
            adjacencyList.put(first, new Node(second, weight)); // Adding the second element to the list.

        } else // If the first element is not the first element in the list.
        {

            // putting a new node at the start of the linked list.
            adjacencyList.put(first, new Node(second, weight, oldHead));
        }
    }

    @Override
    public boolean containsVertex(V search) {
        return adjacencyList.containsKey(search);
    }

    @Override
    public boolean containsEdge(V first, V second) {

        if (containsVertex(first) && containsVertex(second)) {
            Node current = adjacencyList.get(first); // Getting the first element in the list.

            while (current != null) { // Iterating through the list.
                if (current.otherVertex.equals(second)) { // Checking if the current element is the second element.
                    return true;
                }
                current = current.next; // Moving to the next element in the list.
            }
        }
        return false;
    }

    @Override
    public boolean removeVertex(V element) {
        if (containsVertex(element)) { // Checking if the element is in the graph.
            adjacencyList.remove(element); // Removing the element from the graph.
            vertexCount--; // Decrementing the vertex count.
            return true;
        }
        return false; // Did not remove the vertex.
    }

    @Override
    public boolean removeEdge(V first, V second) {
        if (containsEdge(first, second)) { // Checking if the edge is in the graph.
            removeDirectedEdge(first, second); // Removing the first edge.
            removeDirectedEdge(second, first); // Removing the second edge.
            edgeCount--; // Decrementing the edge count.
            edgeCount--; // Decrementing the edge count.
            return true;
        }
        return false;
    }

    private void removeDirectedEdge(V first, V second) {
        Node current = adjacencyList.get(first); // Getting the first element in the list.

        if (current.otherVertex.equals(second)) { // Checking if the first element is the second element.
            adjacencyList.put(first, current.next); // Removing the first element from the list.
        } else { // If the first element is not the second element.
            while (current.next != null) { // Iterating through the list.
                if (current.next.otherVertex.equals(second)) { // Checking if the next element is the second element.
                    current.next = current.next.next; // Removing the next element from the list.
                    break;
                }
                current = current.next; // Moving to the next element in the list.
            }
        }
    }

    @Override
    public int vertexSize() {
        //the same as the number of keys in the map
        return adjacencyList.size();
    }

    @Override
    public int edgeSize() {

        return 0;
    }

    @Override
    public int degree(V vertex) {
        return 0;
    }

    /**
     * Returns a set of all vertices in the graph.
     *
     * @return A set of all the vertices in the graph.
     */
    @Override
    public Set<V> vertices() {
        return adjacencyList.keySet();
    }

    /**
     * Returns a set of all edges in the graph.
     *
     * @return A set of edges.
     */
    @Override
    public Set<Edge<V>> edges() {
        Set<Edge<V>> edges = new HashSet<>(); // The set of edges.

        for (V vertex : vertices()) { // Iterating through the vertices.
            Node current = adjacencyList.get(vertex); // Getting the first element in the list.

            while (current != null) { // Iterating through the list.
                edges.add(new Edge<>(vertex, current.otherVertex, current.weight)); // Adding the edge to the set.
                current = current.next; // Moving to the next element in the list.
            }
        }
        return edges;
    }

    /**
     * Return a list of all the vertices in the graph in the order they were visited by a depth-first search starting at
     * the given vertex.
     *
     * @return A list of vertices in the graph in the order they were visited by the DFS algorithm.
     */
    @Override
    public List<V> dfs(V source) {

        Set<V> allVerts = vertices(); // Getting all the vertices in the graph.

        if (allVerts.isEmpty()) { // Checking if the graph is empty.
            return new ArrayList<>(); // Returning an empty list.
        }

        List<V> traversalResults = new ArrayList<>(); // The list of vertices in the order they were visited.
        Set<V> visited = new HashSet<>(); // The set of visited vertices.

        dfsRecursive(source, traversalResults, visited); // Calling the recursive method.
        return traversalResults;
    }

    //a list for our results - maintains the traversal order
    // a set for determining  what we've seen already, fast!
    private void dfsRecursive(V current, List<V> traversal, Set<V> visted) {
        if(!visted.contains(current)) {
            // Adding the current vertex to the set of visited vertices.
            visted.add(current);

            // Adding the current vertex to the list of vertices in the order they were visited.
            traversal.add(current);

            // Getting the first element in the list.
            Node neighbor = adjacencyList.get(current);


            // Iterating through the linked list.
            while(neighbor != null) {

                // Calling the recursive method on the next vertex in the linked list.
                dfsRecursive(neighbor.otherVertex, traversal, visted);

                // Moving to the next element in the linked list.
                neighbor = neighbor.next;
            }
        }
    }

    /**
     * Return a list of all the nodes in the graph in the order they were visited by a breadth-first search starting at the
     * given node.
     *
     * @return A list of vertices in the order they were visited.
     */
    @Override
    public List<V> bfs(V source) {

        List<V> traversal= new ArrayList<>(); // The list of vertices in the order they were visited.
        Set<V> visited = new HashSet<>(); // The set of visited vertices.
        Queue<V> bfsQueue = new LinkedList<>(); // The queue of vertices to visit.

        bfsQueue.add(source); // Adding the source vertex to the queue.
        int count = 0; // The number of vertices visited.

        while(traversal.size() < count){
            V next = bfsQueue.remove(); // Removing the first element in the queue.

            if(!visited.contains(next)) { // Checking if the vertex has been visited.
                visited.add(next); // Adding the vertex to the set of visited vertices.
                traversal.add(next); // Adding the vertex to the list of vertices in the order they were visited.

                Node neighbor = adjacencyList.get(next); // Getting the first element in the list.

                while(neighbor != null) { // Iterating through the list.
                    if (!visited.contains(neighbor.otherVertex)) { // Checking if the vertex has been visited.
                        bfsQueue.add(neighbor.otherVertex); // Adding the vertex to the queue.
                        neighbor = neighbor.next; // Moving to the next element in the list.
                    }
                }
            }
        }

        return traversal;
    }


    //inner class
    private class Node {

        private V otherVertex; //the other vertex in the edge
        private int weight; //the weight of the edge


        private Node next; //next node in the linked list

        public Node(V otherVertex, int weight) {
            this.otherVertex = otherVertex;
            this.weight = weight;
        }

        public Node(V otherVertex, int weight, Node next) {
            this.otherVertex = otherVertex;
            this.weight = weight;
            this.next = next;
        }


    }

    @Override
    public String toString() {
        return "MyGraph{" +
                "adjacencyList=" + adjacencyList +
                ", edgeCount=" + edgeCount +
                ", vertexCount=" + vertexCount +
                '}';
    }
}
