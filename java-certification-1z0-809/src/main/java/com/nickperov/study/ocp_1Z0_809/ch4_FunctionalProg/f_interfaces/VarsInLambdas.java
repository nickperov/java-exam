package com.nickperov.study.ocp_1Z0_809.ch4_FunctionalProg.f_interfaces;

import java.util.function.Function;
import java.util.stream.IntStream;

public class VarsInLambdas {

	static interface CalcLambda {
		int calculate(int i);
	}	
	static Integer b = 10;
	public static void main(String[] args) {
		Integer c = 1;
		Function<Integer, Integer> lambda = a -> a + b + c + 1;
		
		IntStream.of(1,1,1,1,1,1).forEach(i -> {
			b++;
			System.out.println(lambda.apply(i));	
		});
	}
	
	
	private void lambdaMethod(int intParam, CalcLambda lambda) {
		
		intParam = intParam + 1;
		
		lambda.calculate(intParam);
		
	}
	
}


// Functional interface
interface Gorilla { String move(); }
interface Gorilla2 { String move(String param); }

class GorillaFamily {
	String walk = "walk";
	
	void everyonePlay(boolean baby, String test) {
		String approach = "amble"; // should be effectively final 
		// approach = "run";
		
		play(() -> walk);
		play(() -> baby ? "hitch a ride" : "run");
		play(() -> approach);
		
		play((a) -> a + test, "str");
	}
	
	void play(Gorilla g) {
		System.out.println(g.move());
	}
	
	void play(Gorilla2 g, String str) {
		System.out.println(g.move(str));
	}
	
}