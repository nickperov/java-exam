package com.nickperov.oca_1Z0_803.ch3.operators;

public class StudExamArithmeticOper001 {
	
	
	public static void main(String[] args) {		
		testArithmetics001();
		
		testArithmetics002();
	}
	
	
	private static void testArithmetics001() {
		
		System.out.println("====================== Arithmetics operators 001 ======================");
		
		byte resB = 4 * 15;
		short resS = 45 * 644;
		int resI = 2 + 3;
		float resF1 = 2 + 3.5f; // Invalid -> float resF = 2 + 3.5;
		
		float resF2 = 5 / 4;
		float resF3 = 5 / 4.1f;
		float resF4 = (float)(5 / 4.2d);
		
		double resD1 = 2 + 3.6;
		double resD2 = 2L + 3.6D;
		double resD3 = 2L + 3.6F;
		
		System.out.println(resB);
		System.out.println(resS);
		System.out.println(resI);
		System.out.println(resF1);
		System.out.println(resF2);
		System.out.println(resF3);
		System.out.println(resF4);
		System.out.println(resD1);
		System.out.println(resD2);
		System.out.println(resD3);
		
	}
	
	private static void testArithmetics002() {
		System.out.println("====================== Arithmetics operators 002 ======================");
		
		int a = 10;
		int b = 100;
		double c = (double) (a/b); 
		String str = String.format("%1.4f", c); 
		System.out.println(str);
		
		double d = a/b;
		str = String.format("%1.4f", d); 
		System.out.println(str);
		
		double f = (double)a/b;
		str = String.format("%1.4f", f); 
		System.out.println(str);
	}
}