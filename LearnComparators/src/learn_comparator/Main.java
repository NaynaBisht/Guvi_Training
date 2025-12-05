package learn_comparator;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Student> students = new ArrayList<>();
		
		students.add(new Student(101, "Zoya", 22));
		students.add(new Student(105, "Ankit", 21));
		students.add(new Student(102, "Priya", 22));
		
		System.out.println("Unsorted List: " + students);
		
		Collections.sort(students, new SortByName());
		
		System.out.println("Sorted by Name: " + students);

	}

}
