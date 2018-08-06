package com.nickperov.study.ocp_1Z0_809.ch7_Concurrency;

public class ThreadConcurrencyExmpls {
	
	
	@SuppressWarnings("unused")
	public static void main(String[] args) throws InterruptedException {
	
		// Examples of runnable
		Runnable r1 = () -> {};
		Runnable r2 = () -> {return;};
		Runnable r3 = () -> {System.out.println("");};
		
		// Runnable r4 = () -> ""; Runnable can not return a value
		
		examplesOfThreadTask();
		
		multipleThreadTask();
		
		customThreadExmpl();
		
		checkThreadResults();
		
		multiThreadCalc();
	}
	
	
	private static void examplesOfThreadTask() {
		System.out.println("==================================== Examples of separate thread task =================================");
		
		// Run in separate thread by using Runnable
		new Thread(new PrintData()).start();
		
		// Run in separate thread by using Thread
		new ReadInventoryThread().start();
	}
	
	private static void multipleThreadTask() throws InterruptedException {
		System.out.println("==================================== Examples of multiple thread tasks =================================");
		
		System.out.println("Begin");
		(new ReadInventoryThread()).start();
		(new Thread(new PrintData())).start();
		(new ReadInventoryThread()).start();
		System.out.println("End");
		
		Thread.sleep(100);
	}
	
	private static void customThreadExmpl() throws InterruptedException {
		System.out.println("==================================== Examples of customized thread =================================");
		System.out.println("Begin");
		Thread readInv = new ReadInventoryThread();
		readInv.setPriority(10); // Set high priority
		readInv.start();
		System.out.println("End");
		Thread.sleep(100);
	}
	
	private static void checkThreadResults() throws InterruptedException {
		System.out.println("==================================== Check results of separate thread calculation =================================");
		new Thread(() -> {
			for (int i = 0; i < 5000; i++)
				ThreadResults.counter++;
		}).start();
		
		while(ThreadResults.counter < 5000) {
			System.out.println("Not reached yet");
			Thread.sleep(100);
		}
		
		System.out.println("Reached!");
	}
	
	private static void multiThreadCalc() {
		System.out.println("==================================== Calculation in separate thread =================================");
		try {
			double[] scores = {1,2,3,5,3,7};
			CalculateAverages calcAvg = new CalculateAverages(scores);
			new Thread(calcAvg).start();
			Thread.sleep(100);
			System.out.println("Result: " + calcAvg.getResult());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private static class ThreadResults {
		private static int counter;
	}
	
	private static class CalculateAverages implements Runnable {
		private double[] scores;
		private double res;
		
		public CalculateAverages(double[] scores) {
			this.scores = scores;
		}
		
		public double getResult() {
			return this.res;
		}
		
		@Override
		public void run() {
			double summ = 0;
			for (double s : scores)
				summ += s;
			res = summ/scores.length;
		}
	}
	
	private static class PrintData implements Runnable {

		@Override
		public void run() {
			for (int i=0; i <3; i++)
				System.out.println("Printing record: " + i);
		}
	}
	
	private static class ReadInventoryThread extends Thread {
		
		@Override
		public void run() {
			System.out.println("Printing zool inventory");
		}
	}
}
