package com.nickperov.oca_1Z0_803.ch3.operators;

import java.util.Arrays;

public class StudExamAssignmentOper001 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		testAssignment001();
		testAssignment002();
	}
	
	private static void testAssignment001() {
		
		byte a;
		
		a = 10;
		
		System.out.print( a  + " + 3 = " );
		System.out.println( a += 3 );
		
		a = 15;
		System.out.print( a  + " - 3  = " );
		System.out.println( a -= 3 );
		
		a = 20;
		System.out.print( a  + " * 3  = " );
		System.out.println( a *= 3 );
		
		a = 25;
		System.out.print( a  + " / 3 = " );
		System.out.println( a /= 3 );
		
		// Reminder of division
		a = 30;
		System.out.print( "Reminder (" + a  + " / 3 ) = " );
		System.out.println( a %= 3 );
		
		// Outside the exam
		//Bitwise AND (AND)
		a = 35;
		System.out.print( a  + " & 3 = " );
		System.out.println( a &= 3 );
		
		//Bitwise exclusive  OR (XOR)
		a = 40;
		System.out.print( a  + "  = " );
		System.out.println( a ^= 3 );
		
		//Bitwise inclusive OR (OR)
		a = 45;
		System.out.print( a  + "  = " );
		System.out.println( a |= 3 );
		
		//Signed left shift
		a = 50;
		System.out.print( a  + "  = " );
		System.out.println( a <<= 3 );
		
		//Signed right shift
		a = 55;
		System.out.print( a  + "  = " );
		System.out.println( a >>= 3 );
		
		//Unsigned right shift
		a = 60;
		System.out.print( a  + "  = " );
		System.out.println( a >>>= 3 );
		
	}
	
	private static void testAssignment002() {
		//Signed left shift
		int a = 33;
		
		System.out.println(Integer.toBinaryString(a));
		
		System.out.print( a  + "  <<= " );
		System.out.println( a <<= 200 );
		
		System.out.println(Integer.toBinaryString(a));
	}
}