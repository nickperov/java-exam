package com.nickperov.oca_1Z0_803.tests;

public class Test6 {
	public static void main(String[] args) {
		System.out.println(1 + 5 < 3 + 7);
		System.out.println( (2 + 2) >= 2 + 3);
		
		
		switch(5)
		{
			default :
		}
		
		
		int i = -129;
		while (i < 130) {
			System.out.println("I = " + i + "; " + testIntCache(String.valueOf(i)));
			i++;
		}

	}
	
	private static boolean testIntCache(String val) {
		Integer i = Integer.parseInt(val);
		Integer j = i;
		i--;
		i++;
		return (i==j);
	}

}
