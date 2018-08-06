package com.nickperov.oca_1Z0_808.tests;

public class FoundationTest {
	
	public static void main(String[] args) throws Exception{
		
		// Check Integer MIN Value
		int a = Integer.MIN_VALUE;
		int b = -a;
		System.out.println( a+ "   "+b);
		
		// Check float -> int conversion 
		int i = 1234567890;
		float f = i;
		System.out.println(i);
		System.out.println(f);
		System.out.println(i - (int)f);
	}
}