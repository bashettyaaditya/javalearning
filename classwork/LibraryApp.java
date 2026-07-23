import java.util.*;

// Parent Class
class LibraryMember {
    protected String memberName;
    protected int memberId;

    public LibraryMember(String memberName, int memberId) {
        this.memberName = memberName;
        this.memberId = memberId;
        System.out.println("Library Membership Created");
    }

    public void displayMember() {
        System.out.println("\nMember Name : " + memberName);
        System.out.println("Member ID : " + memberId);
    }
}

// Child Class 1
class StudentMember extends LibraryMember {

    private int booksIssued;

    public StudentMember(String memberName, int memberId, int booksIssued) {
        super(memberName, memberId);
        this.booksIssued = booksIssued;
    }

    public void displayStudent() {
        displayMember();
        System.out.println("Books Issued : " + booksIssued);
    }
}

// Child Class 2
class FacultyMember extends LibraryMember {

    private String department;

    public FacultyMember(String memberName, int memberId, String department) {
        super(memberName, memberId);
        this.department = department;
    }

    public void displayFaculty() {
        displayMember();
        System.out.println("Department : " + department);
    }
}

public class LibraryApp {
    public static void main(String[] args) {

        StudentMember s = new StudentMember("Kiran", 101, 4);
        s.displayStudent();

        System.out.println();

        FacultyMember f = new FacultyMember("Dr. Rao", 201, "Computer Science");
        f.displayFaculty();
    }
}