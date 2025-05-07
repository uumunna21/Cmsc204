import static org.junit.Assert.*;
import java.util.Set;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class Graph_STUDENT_Test.
 */
public class Graph_STUDENT_Test {
    
    /** The graph. */
    private Graph graph;
    
    /** The t 4. */
    private Town t1, t2, t3, t4;

    /**
     * Sets the up.
     */
    @Before
    public void setUp() {
        graph = new Graph();
        t1 = new Town("Alpha");
        t2 = new Town("Beta");
        t3 = new Town("Gamma");
        t4 = new Town("Delta");

        graph.addVertex(t1);
        graph.addVertex(t2);
        graph.addVertex(t3);
        graph.addVertex(t4);

        graph.addEdge(t1, t2, 5, "Road1");
        graph.addEdge(t2, t3, 3, "Road2");
        graph.addEdge(t3, t4, 2, "Road3");
        graph.addEdge(t1, t4, 10, "Road4");
    }

    /**
     * Test add vertex.
     */
    @Test
    public void testAddVertex() {
        Town newTown = new Town("Echo");
        assertFalse(graph.containsVertex(newTown));
        graph.addVertex(newTown);
        assertTrue(graph.containsVertex(newTown));
    }
    
    /**
     * Test contains vertex.
     */
    @Test
    public void testContainsVertex() {
        Town oldTown = new Town("Hello");
        assertFalse(graph.containsVertex(oldTown));
        graph.addVertex(oldTown);
        assertTrue(graph.containsVertex(oldTown));
    }

    /**
     * Test remove vertex.
     */
    @Test
    public void testRemoveVertex() {
        assertTrue(graph.removeVertex(t4));
        assertFalse(graph.containsVertex(t4));
    }

    /**
     * Test add edge.
     */
    @Test
    public void testAddEdge() {
        Graph graph = new Graph();

        Town t1 = new Town("Alpha");
        Town t2 = new Town("Beta");

        graph.addVertex(t1);
        graph.addVertex(t2);

        graph.addEdge(t1, t2, 5, "Road1");

        Road edge = graph.getEdge(t1, t2);
        assertNotNull(edge);
        assertEquals("Road1", edge.getName());
        assertEquals(5, edge.getWeight());
        assertTrue(edge.contains(t1));
        assertTrue(edge.contains(t2));
    }

    
    /**
     * Test remove edge.
     */
    @Test
    public void testRemoveEdge() {
        Graph graph = new Graph();

        Town t1 = new Town("Alpha");
        Town t2 = new Town("Beta");

        graph.addVertex(t1);
        graph.addVertex(t2);
        graph.addEdge(t1, t2, 7, "AlphaBeta");

        // Verify the edge exists first
        assertNotNull(graph.getEdge(t1, t2));

        // Attempt to remove the edge
        Road removed = graph.removeEdge(t1, t2, 7, "AlphaBeta");
        assertNotNull(removed);
        assertEquals("AlphaBeta", removed.getName());

        // Confirm the edge is now gone
        assertNull(graph.getEdge(t1, t2));
    }


    /**
     * Test edge set.
     */
    @Test
    public void testEdgeSet() {
        Set<Road> edges = graph.edgeSet();
        assertEquals(4, edges.size());
    }

    /**
     * Test contains edge.
     */
    @Test
    public void testContainsEdge() {
        assertTrue(graph.containsEdge(t2, t3));
        assertFalse(graph.containsEdge(t1, t3));
    }

    /**
     * Test edges of.
     */
    @Test
    public void testEdgesOf() {
        Set<Road> edges = graph.edgesOf(t3);
        assertEquals(2, edges.size());
    }

//    @Test
//    public void testShortestPath() {
//        ArrayList<String> path = graph.shortestPath(t1, t4);
//        assertEquals("Alpha via Road1 to Beta 5 mi", path.get(0));
//        assertEquals("Beta via Road2 to Gamma 3 mi", path.get(1));
//        assertEquals("Gamma via Road3 to Delta 2 mi", path.get(2));
//    } 
    
    /**
 * Test shortest path.
 */
@Test
    public void testShortestPath() {
    	
    	Graph graph;
        Town a, b, c;
    	
    	graph = new Graph();
        a = new Town("A");
        b = new Town("B");
        c = new Town("C");
        graph.addVertex(a);
        graph.addVertex(b);
        graph.addVertex(c);
        graph.addEdge(a, b, 3, "AB");
        graph.addEdge(b, c, 4, "BC");
        assertEquals("A via AB to B 3 mi", graph.shortestPath(a, b).get(0));
    }
    
    /**
     * Test dijkstra shortest path.
     */
    @Test
    public void testDijkstraShortestPath() {
        Graph graph = new Graph();

        Town a = new Town("A");
        Town b = new Town("B");
        Town c = new Town("C");
        Town d = new Town("D");

        graph.addVertex(a);
        graph.addVertex(b);
        graph.addVertex(c);
        graph.addVertex(d);

        graph.addEdge(a, b, 2, "AB");
        graph.addEdge(b, c, 3, "BC");
        graph.addEdge(a, d, 10, "AD");
        graph.addEdge(c, d, 1, "CD");

        // Invoke dijkstraShortestPath
        graph.dijkstraShortestPath(a);

        // Now use shortestPath to confirm it calculated correctly
        ArrayList<String> path = graph.shortestPath(a, d);
        assertEquals(3, path.size());
        assertEquals("A via AB to B 2 mi", path.get(0));
        assertEquals("B via BC to C 3 mi", path.get(1));
        assertEquals("C via CD to D 1 mi", path.get(2));
    }

    /**
     * Test get edge.
     */
    @Test
    public void testGetEdge() {
        Graph graph = new Graph();

        Town t1 = new Town("Alpha");
        Town t2 = new Town("Beta");
        Town t3 = new Town("Gamma");

        graph.addVertex(t1);
        graph.addVertex(t2);
        graph.addVertex(t3);

        Road expectedRoad = graph.addEdge(t1, t2, 5, "AlphaBeta");

        Road retrieved = graph.getEdge(t1, t2);
        assertNotNull(retrieved);
        assertEquals(expectedRoad, retrieved);
        assertEquals("AlphaBeta", retrieved.getName());

        // Test for non-existent edge
        assertNull(graph.getEdge(t1, t3));
    }

}