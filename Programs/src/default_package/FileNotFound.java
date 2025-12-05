package default_package;
import java.io.*;

public class FileNotFound {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
            FileReader file = new FileReader("nonexistent.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
	}

}
