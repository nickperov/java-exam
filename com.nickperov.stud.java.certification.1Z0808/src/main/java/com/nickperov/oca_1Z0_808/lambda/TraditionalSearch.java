package com.nickperov.oca_1Z0_808.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class TraditionalSearch {
	
	public static void main(String[] args) {
		List<Animal> animals = new ArrayList<Animal>();
		animals.add(new Animal("fish", false, true));
		animals.add(new Animal("kangaroo", true, false));
		animals.add(new Animal("rabbit", true, false));
		animals.add(new Animal("turtle", false, true));
		
		print(animals, new CheckIfHopper());
		
		print(animals, p -> p.canHop());
		print(animals, p -> p.canSwim());
		
		printByPredicate(animals, p -> !p.canSwim());
	}
	
	private static void print(List<Animal> animals, CheckTrait checker) {
		for (Animal animal : animals) {
			if (checker.test(animal))
				System.out.print(animal + " ");
			
		}
		System.out.println();
	}

	private static void printByPredicate(List<Animal> animals, Predicate<Animal> predicate) {
		for (Animal animal : animals) {
			if (predicate.test(animal))
				System.out.print(animal + " ");
			
		}
		System.out.println();
	}
}
