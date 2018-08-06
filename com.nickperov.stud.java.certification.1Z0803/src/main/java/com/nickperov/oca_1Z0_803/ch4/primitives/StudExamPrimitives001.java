package com.nickperov.oca_1Z0_803.ch4.primitives;


public class StudExamPrimitives001 {
	
	public static void main(String[] args) {
		
		testPrimitiveDeclaration();
		
		testBooleanPrimitive();
		
		testBytePrimitive();
		
		testShortPrimitive();
		
		testCharPrimitive();
		
		testIntPrimitive();
		
		testLongPrimitive();
		
		testFloatPrimitive();
		
		testDoublePrimitive();
		
		testPrimitives001();
	}
	
	@SuppressWarnings("unused")
	private static void testPrimitiveDeclaration() {
		System.out.println("======================================Primitive declaration=======================================");
		
		int k;
		int l,f,g;
		long h = 0, d = 8, p;
		
	}
	
	private static void testBooleanPrimitive() {
		
		System.out.println("======================================Test boolean=======================================");
		
		boolean b1 = true;
		boolean b2 = false; // Not possible to cast any other primitive to boolean
		
		System.out.println(b1 + ";" + b2);
	}
	
	private static void testBytePrimitive() {
		
		System.out.println("======================================Test byte=======================================");
		
		byte b1 = 127;
		byte b2 = -128;
		
		int i = 500;
		byte b3 = (byte) i;
		
		byte b4 = 072; // octal
		byte b5 = 0b0100; // binary
		
		byte[] bArray = new byte[] {b1,b2,b3,b4,b5};
		
		for (byte b : bArray)
			System.out.println(b);
	}
	
	private static void testShortPrimitive() {
		
		System.out.println("======================================Test short=======================================");
		
		short s1 = 3045; 
		short s2 = 32767; //max
		short s3 = -32760; //min
		
		int i = 5780;
		
		short s4 = (short) i; // cast int -> short
		short s5 = 056; //octal
		short s6 = (short) '\uffff'; // cast char -> shot
		short s7 = 'F'; // no cast is needed (F < 32767)
		
		short[] sArray = new short[] {s1,s2,s3,s4,s5,s6,s7};
		for (short s : sArray)
			System.out.println(s);
		
	}
	
	private static void testCharPrimitive() {
		System.out.println("======================================Test char=======================================");
		
		char c1 = 'S';
		char c2 = '\u0000'; //min character
		char c3 = '\uffff'; //max character
		char c4 = '\u0068';
		
		char c5 = 1889; // int -> to char
		char c6 = 0x0065; // hexadecimal 
		
		char c7 = '\''; // special character
		char c8 = 121;
		char c9 = (char)131193;
		char c10 = 0;
		char c11 = 65535; //interval 0 - 65535 
		
		char c12 = 05473; //octal
		char c13 = 0b0100010; // bitwise
		
		byte b = 120;
		char c14 = (char) b; // need cast
		
		int i1 = 1000;
		char c15 = (char) i1; // need cast
		
		char [] cArray = new char[] {c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15};
		
		for (char c : cArray)
			System.out.println(c);
	}
	
	private static void testIntPrimitive() {
		System.out.println("======================================Test int=======================================");
		
		int i1 = 0;
		int i2 = 0b01000; // binary form
		int i3 = 0x435; //hexadecimal
		
		byte b = 90;
		int i4 = b; // automatic conversion from byte to int
		
		long l = 5000;
		int i5 = (int)l;
		
		int i6 = 07; //octal
		
		int[] iArray = new int[]{i1,i2,i3,i4,i5,i6}; 
		
		for (int i : iArray)
			System.out.println(i);
	}
	
	private static void testLongPrimitive() {
		System.out.println("======================================Test long=======================================");
		
		// Automatic conver5sion int -> long
		long l1 = 0b01000; 
		long l2 = 0x43;
		long l3 = 4678;
		
		long l4 = 'D'; // automatic char (int) -> long conversion
		long l5 = (long) 5.5; // cast from double -> long
		
		// long literals
		long l6 = 10001L;
		long l7 = 11111l;
		
		long l8 = 0xa56b78L; // hexadecimal + L literal
		
		long l9 = 0b010111000L; // binary + L literal
		
		long[] lArray = new long[] {l1,l2,l3,l4,l5,l6,l7,l8,l9};		
		for (long l : lArray)
			System.out.println(l);
	}
	
	private static void testFloatPrimitive() {
		System.out.println("======================================Test float=======================================");
		
		float f1 = 234f;
		
		float f2 = 1003929302l; // automatic conversion from long to float
		
		float f3 = 55.5F;
		
		float f4 = (float) 222.55; // double -> float cast
		
		float f5 = 0b0100101; // binary
		
		float f6 = 0xb10000; // hexadecimal
		
		float f7 = 03456; // ocatal 
		
		float[] fArray = new float[]{f1,f2,f3,f4,f5,f6,f7};
		
		for (float f : fArray)
			System.out.println(f);
	}
	
	private static void testDoublePrimitive() {
		System.out.println("======================================Test double=======================================");
		
		double d1 = 0.4;
		
		double d2 = 0.4f; // float to double don't need cast
		
		double[] dArray = new double[]{d1,d2};
		
		for (double d : dArray)
			System.out.println(d);
	}
	
	@SuppressWarnings("unused")
	private static void testPrimitives001() {
		System.out.println("======================================Test primitives 001=======================================");
		
		byte b = 1;
		char c = 1;
		short s = 1;
		int i = 1;
		
		// s = b * b; invalid; byte * byte = integer
		s *= b; // short * byte = short;
		i = b + b;
		// c = c + b; invalid char + byte = integer;
		s += i;
	}
}
