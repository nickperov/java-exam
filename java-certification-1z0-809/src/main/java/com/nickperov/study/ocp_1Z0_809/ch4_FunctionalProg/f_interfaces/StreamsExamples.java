package com.nickperov.study.ocp_1Z0_809.ch4_FunctionalProg.f_interfaces;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsExamples {
	
	public static void main(String[] args) {
		creatingStreamSource();
		
		terminalOperations();
		
		intermediateOperations();
	}
	
	private static void creatingStreamSource() {
		System.out.println("Creating Stream sources");
		
		Stream<String> empty = Stream.empty(); // count = 0
		Stream<Integer> singleElement = Stream.of(1); // count = 1
		Stream<Integer> fromArray = Stream.of(1,4,5,6); // count = 4
		
		System.out.println("emty: " + empty.count());
		System.out.println("singleElement: " + singleElement.count());
		System.out.println("fromArray: " + fromArray.count());
		
		// From list
		List<String> list = Arrays.asList("a", "b", "c");
		Stream<String> fromList = list.stream();
		Stream<String> fromListParallel = list.parallelStream();
		
		System.out.println("fromList: " + fromList.count());
		System.out.println("fromListParallel: " + fromListParallel.count());
		
		// Infinite streams
		Stream<Double> randoms = Stream.generate(Math::random);
		Stream<Integer> oddNumbers = Stream.iterate(1, x -> x + 4);
		System.out.println(randoms);
		System.out.println(oddNumbers);
		
		randoms.limit(10).map(x -> x + "; ").forEach(System.out::print);
	}
	
	private static void terminalOperations() {
		System.out.println("Stream terminal operations");
		
		// count
		Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
		System.out.println(s.count());
		
		// min - max
		s = Stream.of("monkey", "ape", "bonobo");
		Optional<String> min = s.min((s1, s2) -> s1.length() - s2.length());
		min.ifPresent(System.out::println);
		
		// findAny - findFirst
		s = Stream.of("monkey", "gorilla", "bonobo");
		Stream<String> infinite = Stream.generate(() -> "chimp");
		s.findAny().ifPresent(System.out::println);
		infinite.findAny().ifPresent(System.out::println);
		
		// allMatch - anyMatch - noneMatch
		List<String> list = Arrays.asList("monkey", "2", "chimp");
		infinite = Stream.generate(() -> "chimp");
		Predicate<String> pred = x -> Character.isLetter(x.charAt(0));
		
		System.out.println(list.stream().anyMatch(pred));
		System.out.println(list.stream().allMatch(pred));
		System.out.println(list.stream().noneMatch(pred));
		
		System.out.println(infinite.anyMatch(pred));
		
		// forEach
		s = Stream.of("Monkey", "Gorilla", "Bonobo");
		s.forEach(System.out::println);
		
		// reduce
		Stream<String> stream = Stream.of("w", "o", "l", "f");
		String word = stream.reduce("", (str, c) -> str + c);
		System.out.println(word);
		
		stream = Stream.of("w", "o", "l", "f");
		word = stream.reduce("", String::concat);
		System.out.println(word);
		
		Stream<Integer> numbers = Stream.of(3, 5, 6);
		System.out.println(numbers.reduce(1, (a, b) -> a*b));
		
		// collect
		stream = Stream.of("w", "o", "l", "f");
		word = stream.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
		System.out.println(word);
		
		stream = Stream.of("w", "o", "l", "f");
		TreeSet<String> treeSet = stream.collect(TreeSet::new, TreeSet::add, TreeSet::addAll);
		System.out.println(treeSet);
		
		stream = Stream.of("w", "o", "l", "f");
		Set<String> set = stream.collect(Collectors.toSet());
		System.out.println(set);
	}
	
	private static void intermediateOperations() {
		System.out.println("Stream intermediate operations");

		// filter 
		Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
		s.filter(str -> str.startsWith("m")).forEach(System.out::println);
		
		// distinct
		s = Stream.of("duck", "duck", "duck", "goose");
		s.distinct().forEach(System.out::print);
		
		System.out.println();
		
		// map
		s = Stream.of("monkey", "gorilla", "bonobo");
		s.map(String::length).forEach(System.out::print);
		
		System.out.println();
		
		// flatMap
		List<String> zero = Arrays.asList();
		List<String> one = Arrays.asList("Bonobo");
		List<String> two = Arrays.asList("Mama Gorilla", "Baby Gorilla");
		Stream<List<String>> animals = Stream.of(zero, one, two);
		
		animals.flatMap(l -> l.stream()).forEach(System.out::println);
		
		// sorted
		s = Stream.of("brown-", "bear-");
		s.sorted().forEach(System.out::print);
		
		System.out.println();
		
		s = Stream.of("brown-bear", "grizzly");
		s.sorted(Comparator.reverseOrder()).forEach(System.out::print);
		
		System.out.println();
		
		// peek
		s = Stream.of("black bear", "brown bear", "grizzly");
		long count = s.filter(str -> str.startsWith("g")).peek(System.out::print).count();
		System.out.println();
		System.out.println(count);
		
	}
}
