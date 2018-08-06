package com.nickperov.study.ocp_1Z0_809.ch2_DesignPatterns.functionalInterface;

import java.util.function.Predicate;

public class FindMatchingAminals {
	
	private static void print(Animal animal, CheckTrait trait) {
		if (trait.test(animal))
			System.out.println(animal);
	}
	
	private static void printWithPredicate(Animal animal, Predicate <Animal> trait) {
		if (trait.test(animal)) System.out.println(animal);
	}
	
	public static void main(String[] args) {
		print(new Animal("fish", false, true), a -> a.canHop());
		print(new Animal("kangaroo", true, false), (Animal a) -> { return a.canHop(); });
		
		printWithPredicate(new Animal("lion", true, false), a -> a.canHop());
		
		/*
		 * Lambda examples
		 * a -> a.canHop();
		 * (Animal a) -> a.canHop();
		 * (Animal a) -> { return a.canHop(); };
		 */
		
	}

}
