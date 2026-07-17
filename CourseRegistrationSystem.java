import java.util.ArrayList;

class Course {

    // Encapsulation
    private String courseCode;
    private String courseName;
    private int courseCredits;

    // Constructor
    public Course(String courseCode, String courseName, int courseCredits) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.courseCredits = courseCredits;
    }

    // Getters
    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCourseCredits() {
        return courseCredits;
    }

    // Setters
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCourseCredits(int courseCredits) {
        this.courseCredits = courseCredits;
    }

    // Display Course Details
    public void displayCourse() {
        System.out.println("----------------------------");
        System.out.println("Course Code    : " + courseCode);
        System.out.println("Course Name    : " + courseName);
        System.out.println("Course Credits : " + courseCredits);
    }
}

public class CourseRegistrationSystem {

    // ArrayList to store courses
    private ArrayList<Course> courses = new ArrayList<>();

    // Add Course
    public void addCourse(Course course) {
        courses.add(course);
        System.out.println(course.getCourseName() + " added successfully.");
    }

    // Remove Course
    public void removeCourse(String courseCode) {

        for (int i = 0; i < courses.size(); i++) {

            if (courses.get(i).getCourseCode().equalsIgnoreCase(courseCode)) {

                System.out.println(courses.get(i).getCourseName() + " removed successfully.");

                courses.remove(i);
                return;
            }
        }

        System.out.println("Course not found.");
    }

    // Find Course
    public void findCourse(String courseCode) {

        for (Course c : courses) {

            if (c.getCourseCode().equalsIgnoreCase(courseCode)) {

                System.out.println("\nCourse Found");
                c.displayCourse();
                return;
            }
        }

        System.out.println("Course not found.");
    }

    // Show All Courses
    public void showCourses() {

        System.out.println("\n===== Registered Courses =====");

        if (courses.isEmpty()) {
            System.out.println("No courses registered.");
            return;
        }

        for (Course c : courses) {
            c.displayCourse();
        }
    }

    // Calculate Total Credits
    public void calculateTotalCredits() {

        int totalCredits = 0;

        for (Course c : courses) {
            totalCredits += c.getCourseCredits();
        }

        System.out.println("\nTotal Credits = " + totalCredits);
    }

    // Main Method
    public static void main(String[] args) {

        CourseRegistrationSystem system = new CourseRegistrationSystem();

        // Creating Course Objects
        Course c1 = new Course("CS101", "Java Programming", 4);
        Course c2 = new Course("CS102", "Python Programming", 3);
        Course c3 = new Course("CS103", "Database Management", 4);
        Course c4 = new Course("CS104", "Web Development", 3);

        // Add Courses
        system.addCourse(c1);
        system.addCourse(c2);
        system.addCourse(c3);

        // Show Courses
        system.showCourses();

        // Add New Course
        System.out.println("\nAdding a New Course...");
        system.addCourse(c4);

        // Show Courses Again
        system.showCourses();

        // Find Course
        System.out.println("\nSearching for Course CS102");
        system.findCourse("CS102");

        // Remove Course
        System.out.println("\nRemoving Course CS101");
        system.removeCourse("CS101");

        // Show Remaining Courses
        system.showCourses();

        // Calculate Total Credits
        system.calculateTotalCredits();
    }
}