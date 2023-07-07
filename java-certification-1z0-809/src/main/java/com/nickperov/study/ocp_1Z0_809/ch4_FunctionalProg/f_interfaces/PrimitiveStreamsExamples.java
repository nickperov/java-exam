package com.nickperov.study.ocp_1Z0_809.ch4_FunctionalProg.f_interfaces;

import java.util.Random;
import java.util.function.LongSupplier;
import java.util.stream.DoubleStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class PrimitiveStreamsExamples {
	
	public static void main(String[] args) {
		intStreamExample();
		
		doubleStreamExample();
		
		longStreamExample();
	}
	
	private static void intStreamExample() {
		System.out.println("===IntStream===");
		
		Stream<Integer> stream = Stream.of(1, 2, 3);
		System.out.println(stream.mapToInt(x -> x).sum());
		
	}
	
	private static void doubleStreamExample() {
		System.out.println("===DoubleStream===");
		
		DoubleStream oneValue = DoubleStream.of(3.14);
		DoubleStream varargs = DoubleStream.of(1.0, 1.1, 1.2);
		
		oneValue.forEach(System.out::println);
		System.out.println();
		varargs.forEach(System.out::println);
		System.out.println();
		
		DoubleStream random = DoubleStream.generate(Math::random);
		DoubleStream fractions = DoubleStream.iterate(.5, d -> d / 2);
		
		random.limit(3).forEach(System.out::println);
		System.out.println();
		fractions.limit(3).forEach(System.out::println);
		System.out.println();
	}
	
	private static void longStreamExample() {
		System.out.println("===LongStream===");
		
		LongSupplier longSupplier = () -> new Random().nextLong();
		
		LongStream longStream = LongStream.generate(longSupplier);
		
		longStream.limit(10).filter(l -> l > 10l).forEach(System.out::println);
		
		
	}
}