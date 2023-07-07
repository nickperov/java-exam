package com.nickperov.oca_1Z0_803.ch3.strings;

public class StudExamStringBuilderTest001 {
	
	private static StringBuilder b1, b2;
	
	public static void main(String[] args) {
		
		testStringBuilder001();
	}
	
	private static void initSB() {
		b1 = new StringBuilder("snorkler");
		b2 = new StringBuilder("yoodler");
	}
	
	private static void printSB() {
		System.out.println("b1: " + b1.toString());
		System.out.println("b2: " + b2.toString());
		initSB();
	}
	
	private static void testStringBuilder001() {
		System.out.println("=========================String Builder test 001================================");
		initSB();
		
		b1.append(b2.substring(2, 5).toUpperCase());
		printSB();
		
		b2.insert(3, b1.append("a"));
		printSB();
		
		b1.replace(3, 4, b2.substring(4)).append(b2.append(false));
		printSB();		
	}
	
}
