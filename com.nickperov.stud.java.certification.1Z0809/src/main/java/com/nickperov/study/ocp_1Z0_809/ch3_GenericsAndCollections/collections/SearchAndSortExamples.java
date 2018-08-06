package com.nickperov.study.ocp_1Z0_809.ch3_GenericsAndCollections.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SearchAndSortExamples {

	public static void main(String[] args) {
		
		
		sortUnComparable();
		
		searchWithComparator();
		
		sortedCollectionForUnComparable();
	}
	
	private static void searchWithComparator() {
		List <String> names = Arrays.asList("Fluffy", "Hoppy");
		Comparator <String> c = Comparator.reverseOrder();
		int index = Collections.binarySearch(names, "Hoppy", c);
		System.out.println(index); // wrong result
		
		Collections.sort(names, c);
		System.out.println(Collections.binarySearch(names, "Hoppy", c)); // good result
	}
	
	private static void sortedCollectionForUnComparable() {
		Set<Rabbit> rabbits = new TreeSet<>();
		try {
			rabbits.add(new Rabbit()); //Exception
		} catch(Exception e) {
			System.out.println(e);
		}
		
		Set<Rabbit> sortedRabbits = new TreeSet<>(Comparator.comparing(r -> r.id));
		sortedRabbits.add(new Rabbit()); // Ok
	}
	
	private static void sortUnComparable() {
		List<Rabbit> rabbits = new ArrayList<>();
		
		rabbits.add(new Rabbit());
		
		// Collections.sort(rabbits); // does not compile
		Comparator<Rabbit> rComparator = Comparator.comparing(r -> r.id);
		Collections.sort(rabbits, rComparator/*Comparator.comparing(r -> r.id)*/);
	}
	
}

class Rabbit {
	int id;
}