package com.nickperov.study.ocp_1Z0_809.ch4_FunctionalProg.f_interfaces;

import java.util.OptionalLong;
import java.util.function.Predicate;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ReviewQuestions {

	public static void main(String[] args) {
	//	q1();
		
	//	q2();
		
	//	q3();
		
		q9();
	}
	
	private static void q1() {
		Stream<String> stream = Stream.iterate("", (s) -> s + "1");
		System.out.println(stream.limit(2).map(x -> x + "2"));
	}
	
	private static void q2() {
		Predicate<? super String> predicate = s -> s.startsWith("g");
		Stream<String> stream1 = Stream.generate(() -> "growl! ");
		Stream<String> stream2 = Stream.generate(() -> "growl! ");
		
		boolean b1 = stream1.anyMatch(predicate);
		boolean b2 = stream2.allMatch(predicate);
		
		System.out.println(b1 + " " + b2);
	}
	
	private static void q3() {
		Predicate <? super String > predicate = s -> s.length() > 3;
		Stream <String> stream = Stream.iterate("-", (s) -> s + s);
		
		boolean b1 = stream.noneMatch(predicate);
		boolean b2 = stream.anyMatch(predicate);
		
		System.out.println(b1 + " " + b2);
	}
	
	private static void q9() {
		LongStream ls = LongStream.of(1, 2, 3);
		
		OptionalLong opt = ls.map(n -> n * 10).filter(n -> n < 5).findFirst();

		opt.getAsLong(); // no get method
		
	}
	
	private static void q14() {
		Stream<Integer> s = Stream.of(1);
		
		IntStream is = s.mapToInt(x -> x);
		
		DoubleStream ds = s.mapToDouble(x -> x);
		
		//Stream<Integer> s2 = ds.mapToInt(x -> x);
		IntStream s2 = ds.mapToInt(x -> new Double(x).intValue());
		
		
		s2.forEach(System.out::print);

		
	}
	
}
