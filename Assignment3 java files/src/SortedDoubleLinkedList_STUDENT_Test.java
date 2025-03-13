import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class SortedDoubleLinkedList_STUDENT_Test {
    private SortedDoubleLinkedList<String> sortedList;
    private StringComparator comparator;

    @Before
    public void setUp() {
        comparator = new StringComparator();
        sortedList = new SortedDoubleLinkedList<>(comparator);
    }

    @After
    public void tearDown() {
        sortedList = null;
        comparator = null;
    }

    // Comparator class for Strings
    private class StringComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            return s1.compareTo(s2);
        }
    }
    
    @Test
    public void testAdd() {
        sortedList.add("Banana");
        sortedList.add("Apple");
        sortedList.add("Cherry");
        assertEquals("Apple", sortedList.getFirst());
        assertEquals("Cherry", sortedList.getLast());
    }
    
    @Test(expected = UnsupportedOperationException.class)
    public void testAddToFront() {
        sortedList.addToFront("Apple");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testAddToEnd() {
        sortedList.addToEnd("Apple");
    }

    @Test
    public void testRemoveElement() {
        sortedList.add("Apple");
        sortedList.add("Banana");
        sortedList.add("Cherry");
        sortedList.remove("Banana", comparator);
        assertEquals("Apple", sortedList.getFirst());
        assertEquals("Cherry", sortedList.getLast());
    }

    @Test
    public void testGetFirstAndLast() {
        sortedList.add("Apple");
        sortedList.add("Banana");
        assertEquals("Apple", sortedList.getFirst());
        assertEquals("Banana", sortedList.getLast());
    }

    @Test
    public void testListIterator() {
        sortedList.add("Apple");
        sortedList.add("Banana");
        sortedList.add("Cherry");
        ListIterator<String> iterator = sortedList.iterator();
        assertTrue(iterator.hasNext());
        assertEquals("Apple", iterator.next());
        assertEquals("Banana", iterator.next());
        assertEquals("Cherry", iterator.next());
        assertFalse(iterator.hasNext());
        assertTrue(iterator.hasPrevious());
        assertEquals("Cherry", iterator.previous());
    }

    @Test(expected = NoSuchElementException.class)
    public void testIteratorNoSuchElement() {
        ListIterator<String> iterator = sortedList.iterator();
        iterator.next();
    }

    @Test
    public void testGetSize() {
        assertEquals(0, sortedList.getSize());
        sortedList.add("Apple");
        assertEquals(1, sortedList.getSize());
        sortedList.add("Banana");
        assertEquals(2, sortedList.getSize());
    }

}