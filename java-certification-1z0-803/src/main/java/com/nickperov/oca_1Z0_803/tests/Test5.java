package com.nickperov.oca_1Z0_803.tests;

public class Test5 {

	public static void main(String[] args) {
		JustLooping.start();
		
		TestClass1.test();
		
		TestClass3.test();
		
		SportsCar.test();
	}
	
	
	// variable j shadowed by variable declared in the loop
	static class JustLooping {
		private int j;   // instance var
		void showJ() {
			while(j<=5){
				for(int j=1; j <= 5;){ // var in loop
					System.out.print(j+" ");
					j++;
				}
				j++;
			}
		}
		public static void start() {
			new JustLooping().showJ();
		}
	}
	
	@SuppressWarnings("unused")
	static class JustScope {
		private int i;
		{
			int i; // valid inside the scope 
		}
	}
	
	static class TestClass1 {
		public static void test() {
			System.out.println();
			int i = 0;
			for (i=1 ;  i<5  ; i++) continue;  //(1)
			System.out.println("I: " + i);
			for (i=0 ;       ; i++) break;       //(2)
			System.out.println("I: " + i);
			for (    ; i<5?false:true ;    );     //(3)
		}
	}
	
	static class A {
		public int i = 10;
		private int j = 20;
	}
	
	static class B extends A {
		private int i = 30;
		public int k = 40;
	}
	
	static class C extends B{ }
	
	static class TestClass2 {
		public static void test() {
			C c = new C();
			//System.out.println(c.i); // i is not available 
			//System.out.println(c.j); 
			System.out.println(c.k);
		}
	}
	
	static class TestClass3 {
		public static void test() {
			short s = 9;
			// Short k = new Short(9); invalid
			Short k = new Short((short)9);
			Long l = new Long(11); // valid integer -> long
			// Byte b = new Byte(s); invalid
			Byte b = new Byte((byte) s); // cast short -> byte
			
			Integer i = Integer.valueOf(s); System.out.println(s == i);
		}
	}
	
	static class Car{
		   public int gearRatio = 8;
		   public String accelerate() {  return "Accelerate : Car";  }
		}
	static class SportsCar extends Car{
		   public int gearRatio = 9;
		   public String accelerate() {  return  "Accelerate : SportsCar";  }
		   public static void test(){
		      Car c = new SportsCar();
		      System.out.println( c.gearRatio+"  "+c.accelerate() );
		   }
		}
}
