package com.nickperov.study.ocp_1Z0_809.ch7_Concurrency;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Review questions
 *
 */

public class ReviewQuestions {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		q3();
		
		q10();
		
		q13();
		
		q14();
	}
	
	private static void q1() {
		Stream s = Stream.empty();
		Collection c = (Collection) Collections.emptyList();
		
		s.parallel();
		c.parallelStream();
	}
	
	private static void q3() throws InterruptedException, ExecutionException {
		
		//ExecutorService service = Executors.newSingleThreadScheduledExecutor();
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		service.scheduleWithFixedDelay(() -> {
			System.out.println("Open Zoo");
		//	return null;
		}, 0, 1, TimeUnit.MINUTES);
		
		Future<?> result = service.submit(() -> System.out.println("Wake staff"));
		System.out.println(result.get());
	}
	
	private static void q9() {
		//
	}
	
	private static void q10() {
		System.out.println(Arrays.asList("duck","checken","flamingo","pelican")
			.parallelStream().parallel()
			.reduce(0,
					//(c1, c2) -> c1.length() + c2.length(),
					(c1, c2) -> c1 + c2.length(),
					(s1, s2) -> s1 + s2));
	}
	
	private static void q13() {
		Stream <String> cats = Stream.of("leopard","lynx","ocelot","puma").parallel();
		Stream <String> bears = Stream.of("panda","grizzly","polar").parallel();
		ConcurrentMap<Boolean, List <String>> data = Stream.of(cats, bears).flatMap(s -> s) // flatMap = new non parallel stream
				.collect(Collectors.groupingByConcurrent(s -> !s.startsWith("p")));
		
		System.out.println(data.get(false). size() +" "+ data.get(true). size());
	}
	
	private static void q14() throws InterruptedException {
		BlockingDeque<Integer> deque = new LinkedBlockingDeque<>();
		deque.offer(103);
		deque.offerFirst(20, 1, TimeUnit.SECONDS);
		deque.offerLast(85, 7, TimeUnit.HOURS);
		System.out.print(deque.pollFirst(200, TimeUnit.NANOSECONDS));
		System.out.print(" "+ deque.pollLast(1, TimeUnit.MINUTES));
	}
	
	private static void q16() {
		
		
		
	}
	
}