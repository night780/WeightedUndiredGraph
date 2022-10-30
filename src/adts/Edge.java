package adts;

/**
 * An edge is a connection between two vertices
 * @author Jacob J
 * @version 1.0
 */
public class Edge<V> {
    private V source;
    private V destination;
    private int weight;


    /**
     * A constructor for the Edge class.
     *
     * @param source The source vertex
     * @param destination The destination vertex
     * @param weight The weight of the edge
     */
    public Edge(V source, V destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    /**
     * Returns the source of the event.
     *
     * @return The source vertex of the edge.
     */
    public V getSource() {
        return source;
    }

    /**
     * Returns the destination vertex of this edge.
     *
     * @return The destination vertex.
     */
    public V getDestination() {
        return destination;
    }

    /**
     * This function returns the weight of the object.
     *
     * @return The weight of the object.
     */
    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "source=" + source +
                ", destination=" + destination +
                ", weight=" + weight +
                '}';
    }
}
