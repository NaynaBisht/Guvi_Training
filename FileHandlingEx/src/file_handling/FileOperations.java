package file_handling;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileOperations {
    public static void main(String[] args) {

        String filePath = "src/file_handling/Input.txt";
        int count = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                
                for (String word : words) {
                    if (word.equalsIgnoreCase("india")) {
                        count++;
                    }
                }
            }

            System.out.println("Count of 'india': " + count);

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
