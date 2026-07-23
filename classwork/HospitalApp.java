import java.util.*;

// Parent Class
class Patient {
    protected String patientName;
    protected int age;

    public Patient(String patientName, int age) {
        this.patientName = patientName;
        this.age = age;
        System.out.println("Patient Registered");
    }

    public void displayPatient() {
        System.out.println("\nPatient Name : " + patientName);
        System.out.println("Age : " + age);
    }
}

// Child Class
class InPatient extends Patient {
    protected int roomNumber;

    public InPatient(String patientName, int age, int roomNumber) {
        super(patientName, age);
        this.roomNumber = roomNumber;
        System.out.println("In-Patient Admitted");
    }

    public void displayRoom() {
        System.out.println("Room Number : " + roomNumber);
    }
}

// Grand Child Class
class SurgeryPatient extends InPatient {
    private String surgeryName;

    public SurgeryPatient(String patientName, int age, int roomNumber, String surgeryName) {
        super(patientName, age, roomNumber);
        this.surgeryName = surgeryName;
        System.out.println("Surgery Scheduled");
    }

    public void displaySurgery() {
        displayPatient();
        displayRoom();
        System.out.println("Surgery : " + surgeryName);
    }
}

public class HospitalApp {
    public static void main(String[] args) {

        SurgeryPatient patient = new SurgeryPatient(
                "Rahul", 35, 205, "Heart Surgery");

        patient.displaySurgery();
    }
}