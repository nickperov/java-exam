package com.nickperov.study.ocp_1Z0_809.ch1_AdvancedClassDesign.examples.inheritance;

public class ZooDemonstrator {
	public static void main(String[] args) {
		checkInstanceOf();
		
		checkVirtualMethodInvokation();
		
		checkToString();
	}
	
	private static final void checkInstanceOf() {
		Hippo hippo = new Hippo("Big Hippo", 10000.0);
		System.out.println("Create new Hippo: " + hippo);
		
		System.out.println("is object: " + (hippo instanceof Object));
		System.out.println("is object: " + (hippo instanceof Animal));
		System.out.println("is object: " + (hippo instanceof HeavyAnimal));
		System.out.println("is object: " + (hippo instanceof Hippo));
	}
	
	private static final void checkVirtualMethodInvokation() {
		Lion lion = new Lion(10, 5, "Leo");
		feedAnimal(lion);
	}
	
	private static final void feedAnimal(Animal animal) {
		animal.feed();
	}
	
	private static final void checkToString() {
		Hippo h1 = new Hippo("Harry", 3100);
		System.out.println(h1); // Harry 
	}
	
	
	// TODO toString, hashCode, equals
	
}
