package com.nickperov.study.ocp_1Z0_809.ch3_GenericsAndCollections.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayAndArrayListExample {

	public static void main(String[] args) {
		exmplArrayListToArray();
		exmplArrayToArrayList();
		exmplSearchAndSort();
	}
	
	
	private static void exmplArrayListToArray() {
		List<String> list = new ArrayList<>();
		
		list.add("Fluffy");
		list.add("Webby");
		
		System.out.println("ArrayList");
		
		for (String listElement : list)
			System.out.print(listElement + " - ");
		
		System.out.println();
		
		System.out.println(list);
		
		String[] array = new String [list.size()];
		array[0] = list.get(1);
		array[1] = list.get(0);
		
		System.out.println("Array made from ArrayList");
		
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + " - ");	
	}
	
	private static void exmplArrayToArrayList() {
		String[] array = {"gerbil", "mouse"};
		List<String> list = Arrays.asList(array); // fixed size array-list
		
		System.out.println(list);
		
		list.set(1, "test");
		
		System.out.println(list);
		try {
			list.remove(1); // not supported
		} catch (UnsupportedOperationException e) {
			System.out.println(e);
		}
	}
	
	private static void exmplSearchAndSort() {
		
		int[] arrayOfNumbers = {6, 7, 3, 12, 9};
		Arrays.sort(arrayOfNumbers);
		
		System.out.println(Arrays.binarySearch(arrayOfNumbers, 9)); // 3
		System.out.println(Arrays.binarySearch(arrayOfNumbers, 11)); // -
		
		List<Integer> listOfNumbers = Arrays.asList(9, 5, 18, 24, 3, 1);
		Collections.sort(listOfNumbers);
		
		System.out.println(Collections.binarySearch(listOfNumbers, 5)); // 2
		System.out.println(Collections.binarySearch(listOfNumbers, 2)); // -2
		
	}
}