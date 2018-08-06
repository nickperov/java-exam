package com.nickperov.study.ocp_1Z0_809.ch7_Concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class SynchronizingDataAccess {

	public static void main(String[] args) throws InterruptedException, CloneNotSupportedException {
		
		int numOfAttempts = 10;
		
		runManager("==== Asynchronous counter change ==== ", new SheepManager(), numOfAttempts);
		runManager("==== Atomic counter change ==== ", new SheepManagerAtomic(), numOfAttempts);
		runManager("==== Sync block counter change ==== ", new SheepManagerSync(), numOfAttempts);
	}
	
	private static void runManager(String message, SheepManager sm, Integer numOfAttempts) throws InterruptedException, CloneNotSupportedException {
		System.out.println(message);
		for (int i = 1; i <= numOfAttempts; i++) {
			System.out.print("Attemp " + i + ": ");
			SheepManager.manage((SheepManager) sm.clone());
			Thread.sleep(10);
			System.out.println();
		}
		
		Thread.sleep(100);
		System.out.println();
	}

	
	private static class SheepManager implements Cloneable{
		protected int sheepCount = 0;
		protected void incrementAndReport() {
			System.out.print((++sheepCount)+" ");
		}
		
		@Override
		public Object clone() throws CloneNotSupportedException {
			return super.clone();
		}
		
		protected static void manage(SheepManager manager) {
			ExecutorService service = null;
			try {
				service = Executors.newFixedThreadPool(20);
				for (int i = 0; i < 10; i++)
					service.submit(() -> manager.incrementAndReport());
				
			} finally {
				if (service != null) service.shutdown();
			}
		}
	}
	
	private static class SheepManagerAtomic extends SheepManager {
		private AtomicInteger sheepCount = new AtomicInteger(0);
		
		@Override
		public Object clone() throws CloneNotSupportedException {
			SheepManagerAtomic sm = (SheepManagerAtomic) super.clone();
			sm.sheepCount = new AtomicInteger(this.sheepCount.intValue());
			return sm;
		}
		
		@Override
		protected void incrementAndReport() {
			System.out.print((sheepCount.incrementAndGet())+" ");
		}
	}
	
	private static class SheepManagerSync extends SheepManager {
		@Override
		protected void incrementAndReport() {
			synchronized (this) {
				System.out.print((++sheepCount)+" ");
			}
			
		}
	}
}