package com.nickperov.oca_1Z0_803.ch3.strings;

public class StudExamStringTest001 {
	
	public static void main(String[] args) {
		
		test1();
		test2();
	}
	
	private static void test1() {
		String quote1 = "Test text 0001";
		
		String quote2 = quote1;
		
		quote2 =  "Test text 0002";
		
		System.out.println( "Quate 1:" + quote1 );
		
		System.out.println( "Quate 2:" + quote2 );
	}
	
	private static void test2() {
		String quote = "Example text for substringing";
		System.out.println(quote.substring(0));
		
		System.out.println(quote.substring(1));
	}
	
}
