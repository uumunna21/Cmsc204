import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class Town_STUDENT_Test.
 */
public class Town_STUDENT_Test {
    
    /** The town 3. */
    private Town town1, town2, town3;

    /**
     * Sets the up.
     */
    @Before
    public void setUp() {
        town1 = new Town("CityA");
        town2 = new Town("CityB");
        town3 = new Town("CityA");
    }

    /**
     * Test equals.
     */
    @Test
    public void testEquals() {
        assertTrue(town1.equals(town3));
        assertFalse(town1.equals(town2));
    }

    /**
     * Test compare to.
     */
    @Test
    public void testCompareTo() {
        assertTrue(town1.compareTo(town2) < 0);
    }

    /**
     * Test to string.
     */
    @Test
    public void testToString() {
        assertEquals("CityA", town1.toString());
    }

    /**
     * Test hash code.
     */
    @Test
    public void testHashCode() {
        assertEquals(town1.hashCode(), town3.hashCode());
    }
}