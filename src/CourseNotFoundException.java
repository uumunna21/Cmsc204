import java.io.IOException;

/**
 * Custom exception to handle cases where a course cannot be found
 * or the file cannot be read.
 */
public class CourseNotFoundException extends IOException {

    public CourseNotFoundException() {
        super("Course not found in the database.");
    }

    public CourseNotFoundException(String message) {
        super(message);
    }
}
