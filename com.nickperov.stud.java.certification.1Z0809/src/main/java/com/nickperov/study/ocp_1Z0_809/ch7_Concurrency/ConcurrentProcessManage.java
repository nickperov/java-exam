package com.nickperov.study.ocp_1Z0_809.ch7_Concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentProcessManage {

	public static void main(String[] args) {
		LionPenManager.excecuteTasks();
	}
	
	private static class LionPenManager {
		
		private void removeAnimals() { System.out.println("Removing animals"); }
		private void cleanPen() { System.out.println("Cleaning the pen"); }
		private void addAnimals() { System.out.println("Adding animals"); }
		
		private void performTask() {
			removeAnimals();
			cleanPen();
			addAnimals();
		}
		
		private static void excecuteTasks() {
			ExecutorService service = null;
			try {
				service = Executors.newFixedThreadPool(4);
				LionPenManager manager = new LionPenManager();
				
				for (int i = 0; i < 4; i++)
					service.submit(() -> manager.performTask());
			} finally {
				if (service != null) service.shutdown();
			}
		}
	}
	
}
