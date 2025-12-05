package streams_java;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class EvenNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Before Streams
		List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
		List<Integer> squaredEvens = new ArrayList<>();

		for (Integer n : numbers) {
		    if (n % 2 == 0) { // 1. If the number is even...
		        squaredEvens.add(n * n); // 2. ...square it and add to the new list
		    }
		}

		// squaredEvens now contains [4, 16, 36]
		System.out.println(squaredEvens);
		
		
//		After Streams
		List<Integer> nums = List.of(1, 2, 3, 4, 5, 6);

		List<Integer> squaredEven = nums.stream() // 1. Start the assembly line
		    .filter(n -> n % 2 == 0)     // 2. Station: Keep only even numbers
		    .map(n -> n * n)             // 3. Station: Transform (square) them
		    .collect(Collectors.toList()); // 4. Station: Collect them into a new list

		// squaredEvens now contains [4, 16, 36]
		System.out.println(squaredEven);
		
//		Filter example
		// Keep names that start with "A"
		List<String> names = List.of("Arya", "Sansa", "Bran", "ARYA", "Jon");
		List<String> aNames = names.stream()
		    .filter(name -> name.startsWith("A"))
		    .collect(Collectors.toList());

		System.out.println(aNames);
		
		
//		map example
		// Get the length of each name
		List<Integer> lengths = names.stream()
		    .map(name -> name.length()) // or .map(String::length)
		    .collect(Collectors.toList());

		// Convert all names to lowercase
		List<String> lowerCaseNames = names.stream()
		    .map(name -> name.toLowerCase()) // or .map(String::toLowerCase)
		    .collect(Collectors.toList());
		
//		distinct 
		List<String> uniqueNames = names.stream()
		    .distinct()
		    .collect(Collectors.toList());

		List<String> uniqueLowerCase = names.stream()
		    .map(String::toLowerCase) // -> ["arya", "sansa", "bran", "arya", "jon"]
		    .distinct()               // -> ["arya", "sansa", "bran", "jon"]
		    .collect(Collectors.toList());
		
		
//		sorting
		List<String> sortedNames = names.stream()
			    .sorted()
			    .collect(Collectors.toList());
		
//		forEach
		names.stream()
	    .filter(name -> name.length() == 3)
	    .forEach(name -> System.out.println(name));
	}

}
