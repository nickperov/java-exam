package com.nickperov.oca_1Z0_808.coreapi;

public class StringBuilderTest001 {

	public static void main(String[] args) {
		test001();
	}
	
	private static void test001() {
		// SetLength, length test;
		
		StringBuilder sb = new StringBuilder();		
		sb.setLength(10);
		sb.setLength(5);
		System.out.println(sb.length());
		
		sb.append("Test text");
		System.out.println(sb.length());
		System.out.println(sb);
		
		sb.setLength(6);
		System.out.println(sb.length());
		System.out.println(sb);
	}
}