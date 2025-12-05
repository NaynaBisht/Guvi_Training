package default_package;

import java.io.*;

public class IOException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
            FileReader file = new FileReader("example.txt");
            int ch;
            while ((ch = file.read()) != -1) {
                System.out.print((char) ch);
            }
            file.close();
        } catch (IOException e) {
            System.out.println("An I/O error occurred: " + e.getMessage());
        }
	}

}
