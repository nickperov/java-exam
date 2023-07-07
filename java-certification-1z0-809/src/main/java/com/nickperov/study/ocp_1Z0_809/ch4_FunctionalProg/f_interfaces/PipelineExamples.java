package com.nickperov.study.ocp_1Z0_809.ch4_FunctionalProg.f_interfaces;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class PipelineExamples {
	
	public static void main(String[] args) {
		runPipelineExmp1();
		
		runPipelineExmp2();
	}
	
	private static void runPipelineExmp1() {
		List<String> list = Arrays.asList("Toby", "Anna", "Leroy", "Alex", "Bob", "Nick", "John", "Bill", "Max");
		list.stream()
		.peek(n -> System.out.println("Peek 1: " + n))
		.filter(n -> n.length() == 4)
		.peek(n -> System.out.println("Peek 2:       " + n))
		.sorted()
		.peek(n -> System.out.println("Peek 3:             " + n))
		.limit(2)
		.forEach(System.out::println);
	}
	
	private static void runPipelineExmp2() {
		Stream.generate(() -> "Elsa").filter(n -> n.length() == 4)
			.limit(2)	
			.sorted()
			.forEach(System.out::println);
	}

}
