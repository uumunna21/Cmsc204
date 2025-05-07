// TODO: Auto-generated Javadoc
/**
 * The Class Road.
 */
public class Road implements Comparable<Road> {
    
    /** The source. */
    private Town source;
    
    /** The destination. */
    private Town destination;
    
    /** The weight. */
    private int weight;
    
    /** The name. */
    private String name;

    /**
     * Instantiates a new road.
     *
     * @param source the source
     * @param destination the destination
     * @param weight the weight
     * @param name the name
     */
    public Road(Town source, Town destination, int weight, String name) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
        this.name = name;
    }

    /**
     * Gets the source.
     *
     * @return the source
     */
    public Town getSource() {
        return source;
    }

    /**
     * Gets the destination.
     *
     * @return the destination
     */
    public Town getDestination() {
        return destination;
    }

    /**
     * Gets the weight.
     *
     * @return the weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Contains.
     *
     * @param town the town
     * @return true, if successful
     */
    public boolean contains(Town town) {
        return source.equals(town) || destination.equals(town);
    }

    /**
     * Compare to.
     *
     * @param other the other
     * @return the int
     */
    @Override
    public int compareTo(Road other) {
        return Integer.compare(this.weight, other.weight);
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return name + " [" + source + " <--> " + destination + "] " + weight + " mi";
    }

    /**
     * Equals.
     *
     * @param obj the obj
     * @return true, if successful
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Road) {
            Road other = (Road) obj;
            return (source.equals(other.source) && destination.equals(other.destination)) ||
                   (source.equals(other.destination) && destination.equals(other.source));
        }
        return false;
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        return source.hashCode() + destination.hashCode();
    }
}