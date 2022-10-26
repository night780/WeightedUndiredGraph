
package adts;


/**
 * This is an interface for a weighted undirected graph.
 *
 * @param <V>
 * @author Jacob J
 * @version 1.0
 */
public interface IWeightedUndirectedGraph<V> {

    /**
     * "Adds a vertex to the graph, if it doesn't already exist."
     *
     * The first thing to notice is that the function returns a boolean. This is because the function can fail. If the
     * vertex already exists in the graph, then the function will return false. If the vertex doesn't exist in the graph
     * ,then the function will return true
     *
     * @param element The element to be added to the graph.
     * @return A boolean value.
     */
    boolean addVertex(V element);

    /**
     * Adds a vertex to the graph
     *
     * @param element The element to be added to the graph.
     * @return A boolean value.
     */
    boolean addVertex(V... element);

    /**
     * "Adds an edge between the two vertices first and second with the given weight. If the edge already exists, it
     * updates the weight of the edge to the given weight."
     *
     * The function returns true if the edge was added successfully, and false otherwise
     *
     * @param first The first vertex of the edge.
     * @param second The second vertex of the edge.
     * @param weight The weight of the edge.
     * @return A boolean value.
     */
    boolean addEdge(V first, V second, int weight);

    /**
     * Returns true if the graph contains the given vertex.
     *
     * @param element The element to be searched for in the graph.
     * @return A boolean value.
     */
    boolean containsVertex(V element);

    /**
     * Returns true if there is an edge between the two vertices, false otherwise.
     *
     * @param first The first vertex in the edge.
     * @param second The second vertex of the edge.
     * @return A boolean value.
     */
    boolean containsEdge(V first, V second);

    /**
     * Removes the vertex with the given element from the graph
     *
     * @param element The element to be removed from the graph.
     * @return A boolean value.
     */
    boolean removeVertex(V element);

    /**
     * Removes the edge between the two vertices first and second
     *
     * @param first The first vertex of the edge to be removed.
     * @param second The second vertex of the edge to be removed.
     * @return A boolean value.
     */
    boolean removeEdge(V first, V second);

    /**
     * Returns the number of vertices in the graph
     *
     * @return The size of the vertex.
     */
    int vertexSize();

    /**
     * Returns the number of edges in the graph.
     *
     * @return The size of the edge of the square.
     */
    int edgeSize();


    //algorithms

    /**
     * Returns the number of edges incident to vertex.
     *
     * @param vertex The vertex whose degree is to be calculated.
     * @return The number of edges incident to vertex.
     */
    int degree(V vertex);

}
