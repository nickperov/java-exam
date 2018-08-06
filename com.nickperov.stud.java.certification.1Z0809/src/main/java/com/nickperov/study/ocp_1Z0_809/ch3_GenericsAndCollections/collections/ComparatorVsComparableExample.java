package com.nickperov.study.ocp_1Z0_809.ch3_GenericsAndCollections.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorVsComparableExample {
	
	
	public static void main(String[] args) {
		
		comparableExamples();
		comparatorExamples();
	}
	
	private static void comparableExamples() {
		List<Duck> ducks = new ArrayList<>();
		
		ducks.add(new Duck("Quack", 3));
		ducks.add(new Duck("Puddles", 5));
		
		System.out.println(ducks);
		
		System.out.println("Make sort");
		Collections.sort(ducks);
		System.out.println(ducks);
		
		Animal a1 = new Animal(3);
		Animal a2 = new Animal(7);
		
		System.out.println(a1.compareTo(a2));
		System.out.println(a1.compareTo(a1));
		System.out.println(a2.compareTo(a1));
	}
	
	private static void comparatorExamples() {
		
		Comparator<Duck> byWeight = new Comparator<Duck>() {
			@Override
			public int compare(Duck d1, Duck d2) {
				return d1.getWeight() - d2.getWeight();
			}
		};
		
		Comparator<Duck> byName = (d1, d2) -> d1.getName().compareTo(d2.getName());
		Comparator<Duck> multipleFieldComparator = byName.thenComparing(byWeight);
		
		List<Duck> ducks = new ArrayList<>();
		
		ducks.add(new Duck("Quack", 7));
		ducks.add(new Duck("Big Duck", 12));
		
		System.out.println(ducks);
		
		System.out.println("Make sort");
		Collections.sort(ducks);
		
		System.out.println(ducks);
		
		System.out.println("Make sort by weight");
		Collections.sort(ducks, byWeight);
		
		System.out.println(ducks);
		
		System.out.println("Make sort by name and weight");
		Collections.sort(ducks, multipleFieldComparator);
		System.out.println(ducks);
	}
}

class Duck implements Comparable<Duck> {
	
	private String name;
	private int weight;
	
	public Duck(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}
	
	public String getName() {
		return name;
	}
	
	public int getWeight() {
		return weight;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	@Override
	public int compareTo(Duck o) {
		return name.compareTo(o.name);
	}
}

class Animal implements Comparable<Animal> {
	private int id;
	
	public Animal(int id) {
		this.id = id;
	}
	
	@Override
	public int compareTo(Animal a) {
		return id - a.id;
	}
}

class Product implements Comparable<Product> {
	
	int id;
	String name;
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Product))
			return false;
		
		Product other = (Product)obj;
		
		return this.id == other.id;
	}
	
	@Override
	public int compareTo(Product o) {
		return this.id - o.id;
	}
	
}

