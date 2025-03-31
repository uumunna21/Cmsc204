// CourseDBManager.java
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseDBManager implements CourseDBManagerInterface {
    private CourseDBStructure cds;

    public CourseDBManager() {
        cds = new CourseDBStructure(100); // default size
    }

    @Override
    public void add(String id, int crn, int credits, String roomNum, String instructor) {
        CourseDBElement element = new CourseDBElement(id, crn, credits, roomNum, instructor);
        cds.add(element);
    }

    @Override
    public CourseDBElement get(int crn) {
        try {
            return cds.get(crn);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void readFile(File input) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(input);
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            Scanner lineScan = new Scanner(line);
            String id = lineScan.next();
            int crn = lineScan.nextInt();
            int credits = lineScan.nextInt();
            String roomNum = lineScan.next();
            String instructor = "";
            while (lineScan.hasNext()) {
                instructor += lineScan.next() + " ";
            }
            instructor = instructor.trim();
            add(id, crn, credits, roomNum, instructor);
            lineScan.close();
        }
        fileScanner.close();
    }

    @Override
    public ArrayList<String> showAll() {
        return cds.showAll();
    }
}