package com.nickperov.study.ocp_1Z0_809.ch3_GenericsAndCollections.collections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import java.util.Vector;
import java.util.function.BiFunction;

public class CollectionTests {
	
	public static void main(String[] args) {
		
		testCollectionInterface();
		
		testListInterface();
		
		testSetInterface();
		
		testNavigableSetInterface();
		
		testQueueInterface();
		
		testMapInterface();
		
		testNewAPIs();
	}

	private static void testCollectionInterface() {
		
		Collection<String> birdsList = new ArrayList<>();
		Collection<String> birdsSet = new HashSet<>();
		
		// Method add
		System.out.println("Birds list: ");
		System.out.println("Add sparrow" + birdsList.add("Sparrow"));
		System.out.println("Add hawk" + birdsList.add("Hawk"));
		System.out.println("Add pigeon" + birdsList.add("Pigeon"));
		System.out.println("Add eagle" + birdsList.add("Eagle"));
		System.out.println("Add eagle" + birdsList.add("Eagle"));
		
		System.out.println(birdsList);
		
		System.out.println("Birds set: ");
		System.out.println("Add pigeon" + birdsSet.add("Pigeon"));
		System.out.println("Add eagle" + birdsSet.add("Eagle"));
		System.out.println("Add eagle" + birdsSet.add("Eagle"));
		
		System.out.println(birdsSet);
		
		// Method remove
		System.out.println("Remove cardinal -> " + birdsList.remove("Cardinal"));
		System.out.println("Remove pigeon -> " + birdsList.remove("Pigeon"));
		System.out.println("Remove eagle -> " + birdsList.remove("Eagle"));
		
		System.out.println(birdsList);
		
		// Methods isEmpty and size
		System.out.println("Is birds list empty -> " + birdsList.isEmpty());
		System.out.println("Birds list size -> " + birdsList.size());
		
		System.out.println("Is birds set empty -> " + birdsSet.isEmpty());
		System.out.println("Birds set size -> " + birdsSet.size());

		// Method clear		
		System.out.println("Clear birds set");
		birdsSet.clear();
		System.out.println(birdsSet);
		System.out.println("Is birds set empty -> " + birdsSet.isEmpty());
		
		// Method contains	
		System.out.println("Birds list contains hawk -> " + birdsList.contains("Hawk"));
		System.out.println("Birds list contains seagull -> " + birdsList.contains("Seagull"));
	}
	
	private static void testListInterface() {
		
		List<String> arrayList = new ArrayList<>();
		arrayList.add("SD");
		arrayList.add(0, "NY");
		System.out.println(arrayList);
		
		arrayList.add("LA");
		arrayList.add("CH");
		arrayList.add("LA");
		System.out.println(arrayList);
		
		System.out.println("Index of LA -> " + arrayList.indexOf("LA"));
		System.out.println("Index of Last LA -> " + arrayList.lastIndexOf("LA"));

		// Looping the list
		for (String str : arrayList)
			System.out.println(str);
		
		Iterator<String> it = arrayList.iterator();
		while(it.hasNext())
			System.out.println(it.next());
		
		List<String> linkedist = new LinkedList<>();
		List<String> vecor = new Vector<>();
		List<String> stack = new Stack<>();
		
		System.out.println(linkedist);
		System.out.println(vecor);
		System.out.println(stack);
	}
	
	
	private static void testSetInterface() {
		Set <Integer> hasSet = new HashSet<>();
		System.out.println("Add 66 :" + hasSet.add(66)); // true
		System.out.println("Add 10 :" + hasSet.add(10)); // true
		System.out.println("Add 66 :" + hasSet.add(66)); // false
		System.out.println("Add 8 :" + hasSet.add(8)); // true
		
		for (Integer integer: hasSet) System.out.print( integer + ","); // 66,8,10,
		
		Set <Integer> treeSet = new TreeSet<>();
		System.out.println("Add 66 :" + treeSet.add(66)); // true
		System.out.println("Add 10 :" + treeSet.add(10)); // true
		System.out.println("Add 66 :" + treeSet.add(66)); // false
		System.out.println("Add 8 :" + treeSet.add(8)); // true
		
		for (Integer integer: treeSet) System.out.print(integer + ","); // 8,10,66
	}
	
	private static void testNavigableSetInterface() {
		
		NavigableSet <Integer> set = new TreeSet<>();
		for (int i = 1; i <= 20; i++)
			set.add(i);
		System.out.println();
		System.out.println("Set: " + set);
		
		System.out.println(set.lower(10)); // 9
		System.out.println(set.floor(10)); // 10
		System.out.println(set.ceiling(20)); // 20
		System.out.println(set.higher(20)); // null
		
		System.out.println("Pool first: " + set.pollFirst());
		System.out.println("Pool last: " + set.pollLast());
	}
	
	private static void testQueueInterface() {
		
		Queue <Integer> queue = new ArrayDeque<>();
		System.out.println(queue.offer(10));// true
		System.out.println(queue.offer(4)); // true
		
		System.out.println(queue);
		
		System.out.println(queue.peek()); // 10
		System.out.println(queue.poll()); // 10
		System.out.println(queue.poll()); // 4
		System.out.println(queue.peek()); // null
		
		
		ArrayDeque <Integer> stack = new ArrayDeque <>();
		stack.push(10);
		stack.push(4);
		
		System.out.println(stack);
		System.out.println(stack.peek()); // 4
		
		System.out.println(stack.poll()); // 4
		System.out.println(stack.poll()); // 10
		System.out.println(stack.peek()); // null
	}
	
	private static void testMapInterface() {
		
		Map<String, String> hashMap = new HashMap<>();
		hashMap.put("koala","bamboo");
		hashMap.put("lion","meat");
		hashMap.put("gitaffe", "leaf");
		
		for (String animal : hashMap.keySet())
			System.out.print(animal + ", ");
			
		System.out.println();
		
		for (String animal : hashMap.keySet())
			System.out.println("Food for " + animal + " : " + hashMap.get(animal));
		
		
		Map<String, String> treeMap = new HashMap<>();
		treeMap.put("koala","bamboo");
		treeMap.put("lion","meat");
		treeMap.put("gitaffe", "leaf");
		
		for (String animal : treeMap.keySet())
			System.out.print(animal + ", ");
		
		System.out.println();
	}
	
	private static void testNewAPIs() {
		
		// Removing conditionaly
		List<String> names = new ArrayList<>();
		names.add("Ann");
		names.add("Bob");
		names.add("John");
		names.add("Alan");
		names.add("Ted");
		
		System.out.println(names);
		names.removeIf(n -> n.startsWith("A"));
		System.out.println(names);
		
		// Update all elements
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		System.out.println("Before update: " + list);
		list.replaceAll(x -> x*2);
		System.out.println("After update: " + list);
		
		// Looping
		List<String> cats = Arrays.asList("Annie", "Ripley");
		cats.forEach(System.out::println);
		
		// Map new methods
		
		BiFunction<String, String, String> mapper = (v1, v2) -> v1.length() > v2.length() ? v1 : v2;
		
		Map<String, String> favorites = new HashMap<>();
		favorites.put("Jenny", "Bus Tour");
		favorites.put("Tom", "Tram");
		
		String jenny = favorites.merge("Jenny", "Skyrive", mapper);
		String tom = favorites.merge("Tom", "Skyrive", mapper);
		
		System.out.println(favorites);
		System.out.println(jenny);
		System.out.println(tom);
	}
}