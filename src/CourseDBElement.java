import java.io.Serializable;

public class CourseDBElement implements Comparable<CourseDBElement>, Serializable {
    private String id;
    private int crn;
    private int credits;
    private String roomNum;
    private String instructor;

    // Default constructor
    public CourseDBElement() {
        this("", 0, 0, "", "");
    }

    // Full constructor
    public CourseDBElement(String id, int crn, int credits, String roomNum, String instructor) {
        this.id = id;
        this.crn = crn;
        this.credits = credits;
        this.roomNum = roomNum;
        this.instructor = instructor;
    }

    // Getters and setters
    public String getID() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }

    public int getCRN() {
        return crn;
    }

    public void setCRN(int crn) {
        this.crn = crn;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    // For comparing CourseDBElement objects based on CRN
    @Override
    public int compareTo(CourseDBElement other) {
        return Integer.compare(this.crn, other.crn);
    }

    // Use CRN for hashCode
    @Override
    public int hashCode() {
        return Integer.toString(crn).hashCode();
    }

    // Equality based on CRN
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CourseDBElement) {
            CourseDBElement other = (CourseDBElement) obj;
            return this.crn == other.crn;
        }
        return false;
    }

    // String representation
    @Override
    public String toString() {
        return "Course:" + id + " CRN:" + crn + " Credits:" + credits +
               " Instructor:" + instructor + " Room:" + roomNum;
    }
}
