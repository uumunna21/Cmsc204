import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class Road_STUDENT_Test.
 */
public class Road_STUDENT_Test {
    
    /** The b. */
    private Town a, b;
    
    /** The road. */
    private Road road;

    /**
     * Sets the up.
     */
    @Before
    public void setUp() {
        a = new Town("Alpha");
        b = new Town("Beta");
        road = new Road(a, b, 7, "Main St");
    }

    /**
     * Test contains.
     */
    @Test
    public void testContains() {
        assertTrue(road.contains(a));
        assertTrue(road.contains(b));
    }

    /**
     * Test equals.
     */
    @Test
    public void testEquals() {
        Road same = new Road(b, a, 7, "Main St");
        assertEquals(road, same);
    }

    /**
     * Test to string.
     */
    @Test
    public void testToString() {
        String str = road.toString();
        assertTrue(str.contains("Main St"));
        assertTrue(str.contains("7"));
    }

    /**
     * Test compare to.
     */
    @Test
    public void testCompareTo() {
        Road shorter = new Road(a, b, 3, "Side St");
        assertTrue(road.compareTo(shorter) > 0);
    }
    
    /**
     * Test hash code.
     */
    @Test
    public void testHashCode() {
        Town t1 = new Town("Alpha");
        Town t2 = new Town("Beta");

        Road road1 = new Road(t1, t2, 5, "Route1");
        Road road2 = new Road(t2, t1, 5, "Route1"); // same towns, different order

        assertEquals(road1.hashCode(), road2.hashCode());
    }

}