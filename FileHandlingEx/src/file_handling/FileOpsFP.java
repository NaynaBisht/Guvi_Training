package file_handling;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileOpsFP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "src/file_handling/Input.txt";

        try {
            long count = Files.lines(Paths.get(path))     
                    .flatMap(line -> java.util.Arrays.stream(line.split("\\s+")))  
                    .filter(word -> word.equalsIgnoreCase("india"))               
                    .count();                                                   

            System.out.println("Count of 'india': " + count);

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
	}
}
