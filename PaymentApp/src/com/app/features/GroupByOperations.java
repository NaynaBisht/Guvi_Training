package com.app.features;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class GroupByOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		var nameList = Arrays.asList("James", "Jony", "Rohan", "Roy");
		
		namelist.stream().map(name -> name.tpUpperCase()).forEach(System.out::println);
		
		Map<Integer, List<String>> filtermap = namelist.stream().collect(Collectors.groupingBy(s->s.indexOf(0)));
		
		Set<Integer> keyset = filtermap.keySet();
		
		System.out.println("size of keyset "+keyset.size());
		
		keyset.forEach(
				s-> {
					System.out.println("value of s" +s);
		});
		
	}

}
