package com.nickperov.study.ocp_1Z0_809.ch7_Concurrency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParallelStreamsExmpls {
	
	public static void main(String[] args) {
		createParallelStreams();
		
		parallelStreamReduction();
		
		parallelStreamCollection();
		
		peformanceParallelStreams();
	}
	
	private static void createParallelStreams() {
		System.out.println("================ Parallel stream creation ================");
		
		// Serial stream (single thread)
		Stream<Integer> stream = Arrays.asList(1,2,3,4,5,6,7,8,8,10).stream();
		// Parallel stream (multi thread)
		Stream<Integer> parallel = stream.parallel();
				
		Stream<Integer> pStream = Arrays.asList(1,2,3,4,5,6,7,8,9,10).parallelStream();
		
		parallel.forEach(s -> System.out.print(s+" "));
		System.out.println();
		System.out.println("Ordered output");
		pStream.forEachOrdered(s -> System.out.print(s+" "));
	}
	
	private static class PerfomanceCalculator {
		private int processRecord(int input) {
			try {
				Thread.sleep(10);
			} catch(InterruptedException e) {}
			return input+1;
		}
		
		private void proceessAllData(List<Integer> data) {
			data.stream().map(a -> processRecord(a)).count();
		}
		
		private void proceessAllDataParallel(List<Integer> data) {
			data.parallelStream().map(a -> processRecord(a)).count();
		}
	}
	
	private static void peformanceParallelStreams() {
		System.out.println("================= Parallel streams performance inprovments =================");
		final PerfomanceCalculator calc = new PerfomanceCalculator();
		
		final List<Integer> data = new ArrayList<>();
		for (int i = 0; i < 1000; i++) data.add(i);
		
		peformeTasks(calc, data, ">>>>> Run in single stream mode <<<<<", false);
		
		peformeTasks(calc, data, ">>>>> Run in parallel stream mode <<<<<", true);
	}
	
	private static void peformeTasks(PerfomanceCalculator calc, List<Integer> data, String message, boolean isParallel) {
		System.out.println(message);
		long start, finish;
		double time;
		
		start = System.currentTimeMillis();
		if (isParallel)
			calc.proceessAllDataParallel(data);
		else
			calc.proceessAllData(data);
		finish = System.currentTimeMillis();
		
		time = (finish-start)/1000.0;
		
		System.out.println("Tasks completed in: " + time + " seconds");
	}
	
	
	private static void parallelStreamReduction() {
		System.out.println("================= Parallel streams reduction =================");
		
		System.out.println(Arrays.asList('w','o','l','f').stream().reduce("", (c,s1) -> c + s1, (s2,s3) -> s2 + s3));
		
		System.out.println(Arrays.asList('w','o','l','f').parallelStream().reduce("", (c,s1) -> c + s1, (s2,s3) -> s2 + s3));
		
		System.out.println(Arrays.asList(1,2,3,4,5,6).parallelStream().reduce(0,(a, b) -> (a-b))); // NOT AN ASSOCIATIVE ACCUMULATOR

		System.out.println(Arrays.asList("w","o","l","f").parallelStream().reduce("X", String::concat)); // Identity parameter problem
		
	}
	
	private static void parallelStreamCollection() {
		System.out.println("================= Parallel streams collection =================");
		
		Stream<String> ohMy = Stream.of("lions", "tigers", "bears").parallel();
		ConcurrentMap<Integer, String> map = ohMy
				.collect(Collectors.toConcurrentMap(String::length, k -> k, (s1, s2) -> s1 + "," + s2));
		
		System.out.println(map);
		System.out.println(map.getClass());
		
		ohMy = Stream.of("lions", "tigers", "bears").parallel();
		ConcurrentMap<Integer, List<String>> groupByMap = ohMy.collect(Collectors.groupingByConcurrent(String::length));
		System.out.println(groupByMap);

		
	}

}
