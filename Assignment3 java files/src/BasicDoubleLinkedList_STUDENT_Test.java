import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import java.util.*;


public class BasicDoubleLinkedList_STUDENT_Test {
	private BasicDoubleLinkedList<String> list;
	
	@Before
    public void setUp() {
        list = new BasicDoubleLinkedList<>();
    }

    @After
    public void tearDown() {
        list = null;
    }
    
    @Test
    public void testAddToEnd() {
        list.addToEnd("World");
        assertEquals("World", list.getLast());
    }

    @Test
    public void testAddToFront() {
        list.addToFront("Hello");
        assertEquals("Hello", list.getFirst());
    }
    
    @Test
    public void testRemoveElement() {
        list.addToEnd("Hello");
        list.addToEnd("World");
        list.remove("Hello", String::compareTo);
        assertEquals("World", list.getFirst());
    }
    
    @Test
    public void testGetFirstAndLast() {
        list.addToEnd("Hello");
        list.addToEnd("World");
        assertEquals("Hello", list.getFirst());
        assertEquals("World", list.getLast());
    }
    
    @Test
    public void testListIterator() {
        list.addToEnd("Hello");
        list.addToEnd("World");
        ListIterator<String> iterator = list.iterator();
        assertTrue(iterator.hasNext());
        assertEquals("Hello", iterator.next());
        assertEquals("World", iterator.next());
        assertTrue(iterator.hasPrevious());
    }
    

    @Test(expected = NoSuchElementException.class)
    public void testIteratorNoSuchElement() {
        ListIterator<String> iterator = list.iterator();
        iterator.next();
    }
    
    @Test
    public void testGetSize() {
        assertEquals(0, list.getSize());
        list.addToEnd("Hello");
        assertEquals(1, list.getSize());
        list.addToFront("World");
        assertEquals(2, list.getSize());
    }

}
