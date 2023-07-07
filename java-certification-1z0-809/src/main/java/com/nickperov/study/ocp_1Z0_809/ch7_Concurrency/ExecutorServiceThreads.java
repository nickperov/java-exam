package com.nickperov.study.ocp_1Z0_809.ch7_Concurrency;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.IntStream;

public class ExecutorServiceThreads {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		getProcessorsNumber();
		
		runSingleThreadExecutor();
		
		getFutureResults();
		
		getFutureCallResults();
		
		getFutureResultsMultipleTasks();
		
		waitMultipleTasks();
		
		runScheduledSingleThreadExecutor();
		
		runScheduledWithDelay();
		
		runTasksWithThreadPool();
	}
	
	private static void getProcessorsNumber() {
		System.out.println("============================= Get number of available processors =================================");
		System.out.println("Processors: " + Runtime.getRuntime().availableProcessors());
	}
	
	
	private static void runSingleThreadExecutor() {
		System.out.println("============================= Run single-thread executor =================================");
		
		ExecutorService service = null;
		try {
			service = Executors.newSingleThreadExecutor();
			System.out.println("Begin");
			service.execute(() -> System.out.println("Prinitng zoo inventory"));
			service.execute(() -> {
				for (int i = 0; i < 3; i++)
					System.out.println("Printing record: " + i);
			});
			service.execute(() -> System.out.println("Prinitng zoo inventory"));
			System.out.println("End");
		} finally {
			if (service != null)
				service.shutdown();
				//service.shutdownNow();
		}
	}
	
	private static void getFutureResults() throws InterruptedException, ExecutionException {
		System.out.println("============================= Check future execution results =================================");
		ExecutorService service = null;
		try {
			service = Executors.newSingleThreadExecutor();
			System.out.println("Begin");
			Future<?> resut = service.submit(() -> {
				for (int i = 0; i < 10; i++)
					System.out.println("Printing record: " + i);
			});
			resut.get(10, TimeUnit.SECONDS);
			System.out.println("Reached");
		} catch(TimeoutException e) { 
			System.out.println("Not reached in time");
		} finally {
			if (service != null)
				service.shutdown();
				//service.shutdownNow();
		}
	}
	
	private static void getFutureCallResults() throws InterruptedException, ExecutionException {
		System.out.println("============================= Check future execution results of Callable task =================================");
		ExecutorService service = null;
		try {
			service = Executors.newSingleThreadExecutor();
			Future<Integer> result = service.submit(() -> 30+11);
			System.out.println(result.get());
		} finally {
			if (service != null)
				service.shutdown();
		}
	}
	
	private static void getFutureResultsMultipleTasks() throws InterruptedException, ExecutionException {
		System.out.println("============================= Get future results of multiple tasks =================================");
		ExecutorService service = null;
		try {
			System.out.println("Begin");
			service = Executors.newSingleThreadExecutor();
			Collection<Callable<Integer>> tasks = new ArrayList<>();
			tasks.add(() -> 30 + 465);
			tasks.add(() -> {
				int k = 2;
				int p = 1;
				while (k < 1000000000) {
					int t = k;
					k = p + t;
					p = t;
				}
				return k;
			});
			tasks.add(() -> {
				return 1;
			});
			List<Future<Integer>> results = service.invokeAll(tasks);
			results.stream().forEach(future -> {
				try {
					System.out.println("Result: " + future.get());
				} catch (Exception e) {
					e.printStackTrace();
				}  	
			});
			System.out.println("Reached");
		} finally {
			if (service != null)
				service.shutdown();
		}
	}
	
	private static void waitMultipleTasks() throws InterruptedException {
		System.out.println("============================= Wait for execution of multiple tasks =================================");
		ExecutorService service = null;
		try {
			service = Executors.newSingleThreadExecutor();
			// Submit all tasks
			service.submit(() -> 30+11);
			service.submit(() -> {for (int i = 0; i < 5; i++) System.out.println("test: " + i);});
			service.submit(() -> 567*45678);
		} finally {
			if (service != null) service.shutdown();
		}
		
		if (service != null) {
			service.awaitTermination(1, TimeUnit.NANOSECONDS);
			if (service.isTerminated())
				System.out.println("All tasks terminated");
			else
				System.out.println("At least one task is still running");
		}
	}
	
	private static void runScheduledSingleThreadExecutor() throws InterruptedException, ExecutionException, TimeoutException {
		System.out.println("============================= Run scheduled single-thread executor =================================");
		ScheduledExecutorService service = null;
		try {
			service = Executors.newSingleThreadScheduledExecutor();
			System.out.println("Begin");
			
			Runnable task1 = () -> System.out.println("Hello zoo");
			Callable<String> task2 = () -> "Monkey";
			
			ScheduledFuture<?> result1 = service.schedule(task1, 10, TimeUnit.MILLISECONDS);
			ScheduledFuture<String> result2 = service.schedule(task2, 10, TimeUnit.MILLISECONDS);
			
			result1.get(100, TimeUnit.MILLISECONDS);
			result2.get(100, TimeUnit.MILLISECONDS);
			
			System.out.println("End");
		} finally {
			if (service != null)
				service.shutdown();
		}
	}
	
	private static void runScheduledWithDelay() throws InterruptedException {
		System.out.println("============================= Run scheduled task with delay =================================");
		ScheduledExecutorService service = null;
		try {
			service = Executors.newSingleThreadScheduledExecutor();
			System.out.println("Begin");
			
			Runnable task = () -> System.out.println("Scheduled task, current time: " + System.currentTimeMillis());
			
			service.scheduleWithFixedDelay(task, 100, 300, TimeUnit.MILLISECONDS);
			
			System.out.println("End");
		} finally {
			Thread.sleep(2000);
			if (service != null) {
				System.out.println("Service shutdown");
				service.shutdown();
			}
		}
	}
	
	private static void runTasksWithThreadPool() throws InterruptedException {
		System.out.println("============================= Run tasks with thread pool =================================");
		
		final int[] array = {18932,32883,9832,998723,998732,98823,98342,123,45283,3980021,983454782};
		
		ExecutorService service = null;
		try {
			service = Executors.newCachedThreadPool();
			System.out.println("Begin");
			
			Callable<Number> task1 = () -> { IntStream.of(array).sorted().forEach(System.out::println); return 0; };
			Callable<Number> task2 = () -> IntStream.of(array).sum();
			Callable<Number> task3 = () -> IntStream.of(array).average().orElse(Double.NaN);
			Callable<Number> task4 = () -> IntStream.of(array).max().orElse(0);
			Callable<Number> task5 = () -> IntStream.of(array).min().orElse(0);
			
			Collection<Callable<Number>> tasks = new ArrayList<>();
			
			tasks.add(task1);
			tasks.add(task2);
			tasks.add(task3);
			tasks.add(task4);
			tasks.add(task5);
			
			service.invokeAll(tasks);
			
			System.out.println("End");
		} finally {
			if (service != null) service.shutdown();
		}
	}
}
