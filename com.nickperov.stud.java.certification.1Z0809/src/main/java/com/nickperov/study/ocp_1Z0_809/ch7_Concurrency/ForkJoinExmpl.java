package com.nickperov.study.ocp_1Z0_809.ch7_Concurrency;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

public class ForkJoinExmpl {
	
	public static void main(String[] args) {
		
		Double[] weights = new Double[10];
		
		ForkJoinTask<?> task = new WeightAnimalAction(weights, 0, weights.length);
		ForkJoinPool pool = new ForkJoinPool();
		pool.invoke(task);
		
		System.out.println();
		System.out.println("Weights: ");
		Arrays.asList(weights).stream().forEach(d -> System.out.print(d.intValue() + " "));
		
		
		ForkJoinTask<Double> taskSumm = new WeightAnimalTask(weights, 0, weights.length);
		pool = new ForkJoinPool();
		Double sum = pool.invoke(taskSumm);
		System.out.println("Sum: " + sum);
	}

	
	private static class WeightAnimalAction extends RecursiveAction {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = -1802074686751860121L;
		private int start;
		private int end;
		private Double[] weights;
		
		public WeightAnimalAction(Double[] weights, int start, int end) {
			this.start = start;
			this.end = end;
			this.weights = weights;
		}

		@Override
		protected void compute() {
			if (end - start <= 3)
				for(int i = start; i < end; i++) {
					weights[i] = (double)new Random().nextInt(100);
					System.out.println("Animal weighted: " + i);
				}
			else {
				int middle = start + ((end - start) / 2);
				System.out.println("[start = " + start + ", middle = " + middle + ", end = " + end + "]");
				invokeAll(new WeightAnimalAction(weights, start, middle), new WeightAnimalAction(weights, middle, end));
			}
		}		
	}
	
	private static class WeightAnimalTask extends RecursiveTask<Double> {

		/**
		 * 
		 */
		private static final long serialVersionUID = -8762775006960628518L;
		private int start;
		private int end;
		private Double[] weights;
		
		public WeightAnimalTask(Double[] weights, int start, int end) {
			this.start = start;
			this.end = end;
			this.weights = weights;
		}
		
		@Override
		protected Double compute() {
			if (end - start <= 3) {
				double sum = 0;
				for (int i = start; i < end; i++) {
					weights[i] = (double)new Random().nextInt(100);
					System.out.println("Animal weighted: " + i);
					sum += weights[i];
				}
				return sum;
			} else {
				int middle = start + ((end-start)/2);
				System.out.println("[start = " + start + ", middle = " + middle + ", end = " + end + "]");
				RecursiveTask<Double> otherTask = new WeightAnimalTask(weights, start, middle);
				otherTask.fork();
				return new WeightAnimalTask(weights, middle, end).compute() + otherTask.join();
			}
		}
	}
}
