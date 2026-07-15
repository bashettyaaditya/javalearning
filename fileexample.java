import java.io.File;
import java.io.FileReader;

public class fileexample {
    public static void main(String[] args) {
        try {
            File file = new File("student.txt");
            FileReader reader = new FileReader(file);
            System.out.println("File Opened Successfully");
        } catch (Exception e) {
            System.out.println("File not found.");
        }
    }
}