package com.nickperov.oca_1Z0_803.ch3.operators;

public class StudExamRelationOper001 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		testRelationOper01();
		
		System.out.println( "=================================" );
		
		testRelationOper02();
		
		System.out.println( "=================================" );
		
		testRelationOper03();
		
		System.out.println( "=================================" );
		
		testRelationOper04();

		
		System.out.println( "=================================" );
		
		testRelationOper05();
	}
	
	private static void testRelationOper01() {
		
		/** Less */
		boolean b1 = 1 < 2;
		boolean b2 = 3 < 2;
		
		System.out.println( "b1 = " + b1 + " ; " + "b2 = " + b2 );
		
		/** Greater */
		boolean b3 = 3 > 2;
		boolean b4 = 1 > 2;
		
		System.out.println( "b3 = " + b3 + " ; " + "b4 = " + b4 );
		
		/** Less or equal */
		boolean b5 = 2 <= 2;
		boolean b6 = 3 <= 2;
		
		System.out.println( "b5 = " + b5 + " ; " + "b6 = " + b6 );
		
		/** Greater or equal */
		boolean b7 = 3 >= 3;
		boolean b8 = 2 >= 3;
		
		System.out.println( "b7 = " + b7 + " ; " + "b8 = " + b8 );
	}
	
	private static void testRelationOper02() {
		
		boolean b1 = 'A'  < 'B'; // Character literals
		
		System.out.println( "b1 = " + b1 );
		
		boolean b2 = '\u0041'  < '\u0042'; // Unicode literals
		
		System.out.println( "b2 = " + b2 );
		
		boolean b3 = 0x0041  < 0x0042;
		
		System.out.println( "b3 = " + b3 ); // Hexadecimal literals (16x)
		
		boolean b4 = 65  < 66; //Integer literals that fit in a char
		
		System.out.println( "b4 = " + b4 ); // Hexadecimal literals
		
		boolean b5 = 0101  < 0102; // Octal literals (8x)
		
		System.out.println( "b5 = " + b5 );
		
		boolean b6 = '\101'  < '\102'; // Octal literals (8x)
		
		System.out.println( "b6 = " + b6 );
		
		boolean b7 = 'A'  < '\102'; // Character and octal literals
		
		System.out.println( "b7 = " + b7 );
		
	}
	
	private static void testRelationOper03() {
		
		// Floating point comparison
		
		boolean b1 = 9.00D < 9.50D; // Floating points with D postfixes
		
		System.out.println( "b1 = " + b1 );
		
		boolean b2 = 9.00d < 9.50d; // Floating points with d postfixes
		
		System.out.println( "b2 = " + b2 );
		
		boolean b3 = 9.00F < 9.50F; // Floating points with F postfixes
		
		System.out.println( "b3 = " + b3 );
		
		boolean b4 = 9.00f < 9.50f; // Floating points with f postfixes
		
		System.out.println( "b4 = " + b4 );
		
		boolean b5 = (double)9 < (double)10; // Integer with explicit casts
		
		System.out.println( "b5 = " + b5 ); 
		
		boolean b6 = (float)9 < (float)10; // Integer with explicit casts
		
		System.out.println( "b6 = " + b6 );
		
		boolean b7 = 9 < 10; // Integers
		
		System.out.println( "b7 = " + b7 );
		
		boolean b8 = 9d < 10f;
		
		System.out.println( "b8 = " + b8 );
		
		boolean b9 = (float)9 < 10;
		
		System.out.println( "b9 = " + b9 );
		
		boolean b10 = 9.20f == 9.20d; // Float and double
		
		System.out.println( "b10 = " + b10 );
	}

	
	private static void testRelationOper04() {
		// Equality operator
		
		int value = 12;
		// boolean comparison
		System.out.println( true == true);
		// character comparison
		System.out.println( 'a' != 'a' );
		// byte comparison
		System.out.println( (byte)value == (byte)value );
		// byte comparison
		System.out.println( (short)value != (short)value );
		// integer comparison
		System.out.println( value == value );
		// float comparison
		System.out.println( 12F == 12f );
		// double comparison
		System.out.println( 12D == 12d );
		
	}
	
	private static void testRelationOper05() {
		// Objects
		Object a = new Object();
		Object b = new Object();
		Object c = b;
		
		System.out.print( "Compare a and b: ");
		System.out.println( a == b );
		
		System.out.print( "Compare a and c: ");
		System.out.println( a == c );
		
		System.out.print( "Compare b and c: ");
		System.out.println( c == b);
		
		System.out.println( true & false );
		
	}
}
