package driver;

import graphs.MyGraph;

/**
 * This class creates a graph and adds data to it and then checks if the data is in the graph
 * @author Jacob J
 * @version 1.0
 */
public class testGraph
{

    /**
     * This function adds the data to the graph and then checks if the data is in the graph
     * @param args the input arguments
     */
    public static void main(String[] args)
    {
        //declaring and initializing a graph and data
        String[] strings = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        MyGraph<String> StrinGraph = new MyGraph<>();

        //adding the data to the graph
        boolean result = StrinGraph.addVertex(strings);
        System.out.println(" All vertices added? :"+result);
        System.out.println();
        for (String string : strings) //iterating through the data
        {
            System.out.println("Contains ["+string+"]? :"+StrinGraph.containsVertex(string));

        }
        System.out.println();
StrinGraph.addEdge("A","B",1);
StrinGraph.addEdge("A","C",1);
StrinGraph.addEdge("A","E",1);

        System.out.println("Contains Edge [A,B]? :"+StrinGraph.containsEdge("A","B"));
        System.out.println("Contains Edge [A,C]? :"+StrinGraph.containsEdge("A","C"));
        System.out.println("Contains Edge [A,E]? :"+StrinGraph.containsEdge("A","E"));
        System.out.println("Contains Edge [A,D]? :"+StrinGraph.containsEdge("A","D"));
        System.out.println("Contains Edge [A,F]? :"+StrinGraph.containsEdge("A","F"));
        System.out.println("Contains Edge [A,G]? :"+StrinGraph.containsEdge("A","G"));
        System.out.println("Contains Edge [A,H]? :"+StrinGraph.containsEdge("A","H"));
        System.out.println("Contains Edge [A,I]? :"+StrinGraph.containsEdge("A","I"));
        System.out.println("Contains Edge [A,J]? :"+StrinGraph.containsEdge("A","J"));

        System.out.println("|V| = "+StrinGraph.vertexSize());
    }
}

