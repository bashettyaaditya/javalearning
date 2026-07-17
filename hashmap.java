import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class hashmap {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        HashMap<String, Integer> wordCount = new HashMap<>();

        System.out.println("Enter a sentence:");
        String input = sc.nextLine();

        String[] words = input.split(" ");

        for (String word : words) {

            if (wordCount.containsKey(word)) {
                wordCount.put(word, wordCount.get(word) + 1);
            } else {
                wordCount.put(word, 1);
            }

        }

        System.out.println("\nWord Frequencies:");

        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        sc.close();
    }
}