import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class MorseCodeTreeTest.
 */
public class MorseCodeTreeTest {

    /** The tree. */
    private MorseCodeTree tree;

    /**
     * Sets the up.
     */
    @Before
    public void setUp() {
        tree = new MorseCodeTree();
    }

    /**
     * Test fetch.
     */
    @Test
    public void testFetch() {
        assertEquals("e", tree.fetch("."));
        assertEquals("s", tree.fetch("..."));
        assertEquals("z", tree.fetch("--.."));
        assertEquals("q", tree.fetch("--.-"));
    }

    /**
     * Test to array list LNR.
     */
    @Test
    public void testToArrayListLNR() {
        ArrayList<String> expected = new ArrayList<>();
        // Manually entered from the correct LNR traversal order
        String[] expectedOrder = {
            "h", "s", "v", "i", "f", "u", "e", "l", "r", "a", "p", "w", "j", 
            "b", "d", "x", "n", "c", "k", "y", "t", "z", "g", "q", "m", "o"
        };
        for (String s : expectedOrder) {
            expected.add(s);
        }
        assertEquals(expected, tree.toArrayList());
    }

    /**
     * Test delete unsupported.
     */
    @Test(expected = UnsupportedOperationException.class)
    public void testDeleteUnsupported() {
        tree.delete("e");
    }

    /**
     * Test update unsupported.
     */
    @Test(expected = UnsupportedOperationException.class)
    public void testUpdateUnsupported() {
        tree.update();
    }
}
