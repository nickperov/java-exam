package com.nickperov.study.ocp_1Z0_809.ch3_GenericsAndCollections.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericTester<N> {
	
	N number;
	N[] arrayOfNumbers;
	
	public static void main(String[] args) {
		
		wildCardTest();
		
		upperBoundWildCardExmpls();
		
		lowerBoundWildCardExmpls();
	}
	
	@SuppressWarnings("unused")
	private static void upperBoundWildCardExmpls() {
		// List<Number> listN =  new ArrayList<Integer>(); // not compiled
		List<? extends Number> listN = new ArrayList<Integer>();

		total(listN);
		
		class Bird {}
		class Sparrow extends Bird {}
		
		List<? extends Bird> birds = new ArrayList<Bird>();
		List<? extends Bird> sparrows = new ArrayList<Sparrow>();
		
		// Not compiled:
		//birds.add(new Sparrow());
		//birds.add(new Bird());
		if (!birds.isEmpty()) {
			Bird bird = birds.get(0);
			Sparrow sparrow = (Sparrow)birds.get(0);
			System.out.println(bird);
			System.out.println(sparrow);
		}
		
		List<? extends A> aList = new ArrayList<A>();
		if (!aList.isEmpty()) {
			A a = aList.get(0);
			B b = (B) aList.get(0);
			C c = (C) aList.get(0);
		}
		
		List<? extends B> bList = new ArrayList<B>();
		if (!bList.isEmpty()) {
			A a = bList.get(0);
			B b = bList.get(0);
			C c = (C) bList.get(0);
		}
	}
	
	@SuppressWarnings("unused")
	private static void lowerBoundWildCardExmpls() {
		
		addSound(new ArrayList<String>());
		addSound(new ArrayList<Object>());
		
		
		// C -> B -> A
		addAElement(new ArrayList<Object>());
		List<A> listOfA = new ArrayList<A>();
		addAElement(listOfA);
		System.out.println(listOfA);
		
		addBElement(new ArrayList<Object>());
		addBElement(new ArrayList<A>());
		addBElement(new ArrayList<B>());
		
		addCElement(new ArrayList<Object>());
		addCElement(new ArrayList<A>());
		addCElement(new ArrayList<B>());
		addCElement(new ArrayList<C>());
		
		List<? super B> bList = new ArrayList<A>();
		if (!bList.isEmpty()) {
			A a = (A) bList.get(0);
			B b = (B) bList.get(0);
			
			//bList.add(new A()); // not compiled
			bList.add(new B());
			bList.add(new C());
		}
	}
	
	private static void addSound(List<? super String> list) {
		list.add("quack");
	}
	
	private static void addAElement(List<? super A> list) {
		list.add(new A());
		list.add(new B());
		list.add(new C());
	}
	
	private static void addBElement(List<? super B> list) {
		list.add(new B());
		list.add(new C());
	}
	
	private static void addCElement(List<? super C> list) {
		list.add(new C());
	}
	
	static class A {}
	static class B extends A {}
	static class C extends B {}
	
	private static long total(List<? extends Number> list) {
		long count = 0;
		for (Number number : list)
			count += number.longValue();
		
		return count;
	}
	
	private static void wildCardTest() {
		List<String> keywords = new ArrayList<>();
		keywords.add("java");
		printList(keywords);
	}
	
	private static void printList(List<?> list) {
		for (Object o : list)
			System.out.println(o);
	}
	
	public void storingArrayVsArrayList() {
		// List<Object> list = new ArrayList<String>(); // not compiled
		
		// Compiled, but runtime exception thrown
		Integer[] numbers = { new Integer( 42)};
		Object[] objects = numbers;
		objects[0] = "forty two";
	}
	
	public <T> void genericVoidMethod(T t) {
	}
	
	public <T> T genericReturnMethod(T t) {
		return t;
	}
	
	public <T extends A> T method3(List<? extends T> list) {
		return list.get(0);
	}
}
