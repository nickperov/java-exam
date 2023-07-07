package com.nickperov.study.ocp_1Z0_809.ch4_FunctionalProg.f_interfaces;

import java.util.NoSuchElementException;
import java.util.Optional;

public class OptionalExamples {
	public static void main(String[] args) {
		optionalExample();
		
		optionalGetExample();
	}
	
	private static void optionalExample() {
		System.out.println("Optional examples:");
		
		Optional<Double> av1 = average(2,5,78);
		System.out.println(av1);
		
		Optional<Double> av2 = average();
		System.out.println(av2);
		av2.ifPresent(System.out::println);
		
		Optional <Double> opt = average(90, 100);
		if (opt.isPresent())
			System.out.println(opt.get()); // 95.0

	}
	
	private static void optionalGetExample() {
		System.out.println("Optional Get/IfPresent/orElse examples:");
		
		Optional<Double> emptyOpt = average();
		try {
			System.out.println(emptyOpt.get());
		} catch (NoSuchElementException e) {
			System.out.println(e);
		}
		
		System.out.println(emptyOpt.orElse(Double.NaN));
		System.out.println(emptyOpt.orElseGet(() -> Math.random()));
		
		try {
			System.out.println(emptyOpt.orElseThrow(() -> new IllegalStateException()));
		} catch (IllegalStateException e) {
			System.out.println(e);
		}
	}
	
	
	
	private static Optional<Double> average(int... scores) {
		if (scores.length == 0)
			return Optional.empty();
		
		int sum = 0;
		for (int score: scores)
			sum += score;
		
		return Optional.of((double) sum / scores.length);
	}
}
