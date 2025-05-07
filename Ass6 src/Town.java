// TODO: Auto-generated Javadoc
/**
 * The Class Town.
 */
public class Town implements Comparable<Town> {
    
    /** The name. */
    private String name;

    /**
     * Instantiates a new town.
     *
     * @param name the name
     */
    public Town(String name) {
        this.name = name;
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
     * Compare to.
     *
     * @param other the other
     * @return the int
     */
    @Override
    public int compareTo(Town other) {
        return this.name.compareTo(other.name);
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return name;
    }

    /**
     * Equals.
     *
     * @param obj the obj
     * @return true, if successful
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Town) {
            Town other = (Town) obj;
            return this.name.equals(other.name);
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
        return name.hashCode();
    }
}