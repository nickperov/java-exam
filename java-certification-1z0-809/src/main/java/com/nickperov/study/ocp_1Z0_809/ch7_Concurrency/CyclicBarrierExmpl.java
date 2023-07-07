package com.nickperov.study.ocp_1Z0_809.ch7_Concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierExmpl {
	
	public static void main(String[] args) {
		//runTasksASync();
		
		runTasksSync();
	}

	@SuppressWarnings("unused")
	private static void runTasksASync() {
		// Without sync
		ExecutorService service = null;
		LionPenManager manager = new LionPenManager();
		try {
			service = Executors.newFixedThreadPool(4);
			for (int i = 0; i < 4; i++)
				service.submit(() -> manager.peformTask());
		} finally {
			if (service != null)
				service.shutdown();
		}
	}
	
	private static void runTasksSync() {
		// With sync
		ExecutorService service = null;
		LionPenManager manager = new LionPenManager();
		try {
			service = Executors.newFixedThreadPool(4);
			CyclicBarrier c1 = new CyclicBarrier(4);
			CyclicBarrier c2 = new CyclicBarrier(4, () -> System.out.println("*** Pen cleaned!"));
			for (int i = 0; i < 4; i++)
				service.submit(() -> manager.peformTask(c1, c2));
		} finally {
			if (service != null)
				service.shutdown();
		}
	}
	
	
	private static class LionPenManager {

		private void removeAnimals() {System.out.println("Removing animals");}
		private void cleanPen() {System.out.println("Cleaning the pen");}
		private void addAnimals() {System.out.println("Adding animals");}
		
		public void peformTask(CyclicBarrier c1, CyclicBarrier c2) {
			try {
				removeAnimals();
				c1.await();
				cleanPen();
				c2.await();
				addAnimals();
			} catch (InterruptedException | BrokenBarrierException e) {
				// Handle checked exceptions
			}
			
		}
		
		public void peformTask() {
			removeAnimals();
			cleanPen();
			addAnimals();
		}
	}
}