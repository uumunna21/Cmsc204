import static org.junit.Assert.*;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CourseDBManager_STUDENT_Test {
    private CourseDBManagerInterface dataMgr;

    @Before
    public void setUp() throws Exception {
        dataMgr = new CourseDBManager();
    }

    @After
    public void tearDown() throws Exception {
        dataMgr = null;
    }

    @Test
    public void testAddAndGetCourse() {
        dataMgr.add("CMSC210", 12345, 3, "HT201", "Dr. Test");
        CourseDBElement course = dataMgr.get(12345);
        assertNotNull(course);
        assertEquals("CMSC210", course.getID());
        assertEquals(3, course.getCredits());
        assertEquals("HT201", course.getRoomNum());
        assertEquals("Dr. Test", course.getInstructor());
    }

    @Test
    public void testShowAll() {
        dataMgr.add("CMSC210", 12345, 3, "HT201", "Dr. Test");
        dataMgr.add("CMSC220", 12346, 4, "HT202", "Prof. Java");
        ArrayList<String> courses = dataMgr.showAll();
        assertEquals(2, courses.size());
    }

    @Test
    public void testReadFile() {
        try {
            File tempFile = new File("studentTestFile.txt");
            PrintWriter writer = new PrintWriter(tempFile);
            writer.println("CMSC215 56789 3 SC300 Alice Wonderland");
            writer.println("CMSC216 56788 4 HT400 Bob Builder");
            writer.close();

            dataMgr.readFile(tempFile);

            assertEquals("CMSC215", dataMgr.get(56789).getID());
            assertEquals("CMSC216", dataMgr.get(56788).getID());

            tempFile.delete(); // Clean up
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }
    }
}
