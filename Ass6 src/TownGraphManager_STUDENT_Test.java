import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class TownGraphManager_STUDENT_Test.
 */
public class TownGraphManager_STUDENT_Test {
    
    /** The manager. */
    private TownGraphManager manager;

    /**
     * Sets the up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {
        manager = new TownGraphManager();
        manager.addTown("Alpha");
        manager.addTown("Beta");
        manager.addTown("Gamma");
        manager.addRoad("Alpha", "Beta", 5, "Route1");
        manager.addRoad("Beta", "Gamma", 10, "Route2");
    }

    /**
     * Test add town and road.
     */
    @Test
    public void testAddTownAndRoad() {
        assertTrue(manager.containsTown("Alpha"));
        assertEquals("Route1", manager.getRoad("Alpha", "Beta"));
    }

    /**
     * Test get path.
     */
    @Test
    public void testGetPath() {
        ArrayList<String> path = manager.getPath("Alpha", "Gamma");
        assertFalse(path.isEmpty());
    }

    /**
     * Test delete road.
     */
    @Test
    public void testDeleteRoad() {
        assertTrue(manager.deleteRoad("Alpha", "Beta", "Route1"));
        assertNull(manager.getRoad("Alpha", "Beta"));
    }

    /**
     * Test delete town.
     */
    @Test
    public void testDeleteTown() {
        assertTrue(manager.deleteTown("Gamma"));
        assertFalse(manager.containsTown("Gamma"));
    }
}