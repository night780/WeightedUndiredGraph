package driver;

import graphs.MyGraph;

import java.util.List;

/**
 * This class creates a graph and adds data to it and then checks if the data is in the graph
 *
 * @author Jacob J
 * @version 1.0
 */
public class testGraph {

    /**
     * This function adds the data to the graph and then checks if the data is in the graph
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        MyGraph<Character> charGraph = new MyGraph<>();

        charGraph.addVertex('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J');

        charGraph.addEdge('A', 'B', 1);
        charGraph.addEdge('A', 'C', 1);
        charGraph.addEdge('A', 'D', 1);
        charGraph.addEdge('B', 'E', 1);
        charGraph.addEdge('B', 'F', 1);
        charGraph.addEdge('C', 'G', 1);
        charGraph.addEdge('C', 'H', 1);
        charGraph.addEdge('D', 'I', 1);
        charGraph.addEdge('D', 'J', 1);

        List<Character> traversal = charGraph.dfs('C');

        System.out.println(traversal);
    }



    private void firstGraphTest(){
        //declaring and initializing a graph and data
        String[] strings = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        MyGraph<String> StrinGraph = new MyGraph<>();

        //adding the data to the graph
        boolean result = StrinGraph.addVertex(strings);
        System.out.println(" All vertices added? :" + result);
        System.out.println();
        for (String string : strings) //iterating through the data
        {
            System.out.println("Contains [" + string + "]? :" + StrinGraph.containsVertex(string));

        }
        System.out.println();
        StrinGraph.addEdge("A", "B", 1);
        StrinGraph.addEdge("A", "C", 1);
        StrinGraph.addEdge("A", "E", 1);


        // Checking if the edge is in the graph and then removing it and then checking if it is in the graph again.
        System.out.println("Contains Edge [A,B]? :" + StrinGraph.containsEdge("A", "B"));
        System.out.println("\tRemoving edge [A,B]");
        StrinGraph.removeEdge("A", "B");
        System.out.println("Contains Edge [A,B]? :" + StrinGraph.containsEdge("A", "B"));
        System.out.println();



        // Checking if the vertex is in the graph and then removing it and then checking if it is in the graph again.
        System.out.println("Contains vertex [A]? :" + StrinGraph.containsVertex("A"));
        System.out.println("\tRemoving vertex [A]" );
        StrinGraph.removeVertex("A");
        System.out.println("Contains vertex [A]? :" + StrinGraph.containsVertex("A"));
        System.out.println();


        System.out.println("Contains Edge [A,C]? :" + StrinGraph.containsEdge("A", "C"));
        System.out.println("Contains Edge [A,E]? :" + StrinGraph.containsEdge("A", "E"));

        // Printing the number of vertices and edges in the graph
        System.out.println("Number of vertices: " + StrinGraph.vertices());
        System.out.println("Number of edges: " + StrinGraph.edges());


        System.out.println("Breath First Search: " + StrinGraph.bfs("C"));

        System.out.println("Depth First Search: " + StrinGraph.dfs("C"));
        // Printing the number of vertices in the graph.
        System.out.println("|V| = " + StrinGraph.vertexSize());
    }
}

