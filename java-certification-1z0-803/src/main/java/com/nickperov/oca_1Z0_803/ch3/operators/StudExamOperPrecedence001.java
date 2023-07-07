package com.nickperov.oca_1Z0_803.ch3.operators;

import java.util.Arrays;

public class StudExamOperPrecedence001 {
	
	public static void main(String[] args) {
		testOperPrecedence001();
		testOperPrecedence002();
		testOperPrecedence003();
		testOperPrecedence004();
		testOperPrecedence005();
		testOperPrecedence006();
		testOperPrecedence007();
		testOperPrecedence008();
		testOperPrecedence009();
		testOperPrecedence010();
		testOperPrecedence011();
		testOperPrecedence012();
		testOperPrecedence013();
		testOperPrecedence014();
		testOperPrecedence015();
		testOperPrecedence016();
		testOperPrecedence017();
		testOperPrecedence018();
		testOperPrecedence019();
		testOperPrecedence020();
		testOperPrecedence021();
	}

	/**Arithmetic operators precedence test 1 */
	private static void testOperPrecedence001() {
		System.out.println("Test 1: int k = 1; k += (k = 4) * (k + 2)");
		/*
		 * 1 += (k = 4) * (k + 2)
		 * 1 += 4 * (4 + 2)
		 * 1 += 4 * 6
		 * 25 
		 */
		int k = 1;
		k += (k = 4) * (k + 2);
		System.out.println("k = " + k);
	}
	
	private static void testOperPrecedence002() {
		System.out.println("Test 2: int k = 2; k = k++ * k");
		/*
		 * (k = k++) * k
		 * (k = 2++) * k
		 * 3 * 2
		 * 6
		 */
		int k = 2; 
		k = k++ * k;
		
		System.out.println("k = " + k);
	}
	
	private static void testOperPrecedence003() {
		System.out.println("Test 3: int k = 2; k = ++k * k");
		int k = 2; 
		k = ++k * k;
		/*
		 * (k = ++2) * k
		 * 3 * 3
		 * 9
		 */
		System.out.println("k = " + k);
	}
	
	private static void testOperPrecedence004() {
		System.out.println("Test 4: int k = 2; k = (k = k++) * k");
		int k = 2; 
		k = (k = k++) * k;
		/*
		 * (k = (k = 2++)) * k
		 * (k = 2) * k
		 * 2 * 2
		 * 4
		 */
		System.out.println("k = " + k);
	}
	
	private static void testOperPrecedence005() {
		System.out.println("Test 5: int k = 2; k = k * (k = k++)");
		int k = 2; 
		k = k * (k = k++);
		/*
		 * k * (k = (k = 2++))
		 * k * (k = 2)
		 * 2 * 2
		 * 4
		 */
		
		System.out.println("k = " + k);
	}
	
	private static void testOperPrecedence006() {
		System.out.println("Test 6: int k = 5; k = ++k * k--");
		int k = 5; 
		k = ++k * k--;
		/*
		 * (k = ++5) * k--
		 * 6 * (k = 6--)
		 * 6 * 6
		 * 36
		 */		
		System.out.println("k = " + k);
	}
	
	private static void testOperPrecedence007() {
		System.out.println("Test 7: int k = 5; k = k-- * ++k");
		int k = 5; 
		k = k-- * ++k;
		/*
		 * (k = 5--) * ++k
		 * 5 * (k = ++4)
		 * 25
		 */		
		System.out.println("k = " + k);
	}
	
	private static void testOperPrecedence008() {
		System.out.println("Test 8: int k = 5; k = k * ++k");
		int k = 5; 
		k = k * ++k;
		/*
		 * 5 * (k = ++5)
		 * 5 * 6
		 * 30
		 */
		System.out.println("k = " + k);
	}
	
	private static void testOperPrecedence009() {
		int x = 5;
		int y = 10;
		int z = ++x * y--;
		/*
		 * ++5 * 10--
		 * 6 * 10
		 * 60
		 * x = 6
		 * y = 9
		 * 
		 */
		System.out.println("z = " + z);
	}
	
	/** String concatenation vs arithmetic addition */
	private static void testOperPrecedence010() {
		System.out.println("1 + 2 = " + 1 + 2);
		System.out.println("1 + 2 = " + (1 + 2));	
	}
	
	private static void testOperPrecedence011() {
		System.out.println("Test 11: int k = 5; k = --k + k++");
		int k = 5; 
		k = --k + k++;
		/*
		 * 4 + 4++
		 * 8
		 * 
		 */
		System.out.println("k = " + k);
	}
	
	private static void testOperPrecedence012() {
		System.out.println("Test 12: int k = 1; k = ++k + k++");
		int k = 1; 
		k = ++k + k++;
		/*
		 * 2 + k++; / k = 2
		 * 2 + 2; / k = 3
		 * 4
		 */
		System.out.println("k = " + k);
	}
	
	private static void testOperPrecedence013() {
		System.out.println("Test 13: int k = 1; k = k++ + ++k");
		int k = 1; 
		k = k++ + ++k;
		/*
		 * 1 + ++k; / k = 2
		 * 1 + 3; / k = 3
		 * 4
		 */
		System.out.println("k = " + k);
	}
	
	private static void testOperPrecedence014() {
		System.out.println("Test 14: int k = 1; k = k++ * ++k");
		int k = 1; 
		k = k++ * ++k;
		/*
		 * 1 * ++k; / k = 2
		 * 1 * 3; / k = 3
		 * 3
		 */
		System.out.println("k = " + k);
	}
	
	private static void testOperPrecedence015() {
		System.out.println("Test 15: int k = 1; k = ++k * k++");
		int k = 1; 
		k = ++k * k++;
		/*
		 * 2 * k++; / k = 2
		 * 2 * 2; / k = 3
		 * 2
		 */
		System.out.println("k = " + k);
	}

	private static void testOperPrecedence016() {
		System.out.println("Test 15: int k = 1; k += k++ + ++k");
		int k = 1; 
		k += k++ + ++k;
		/*
		 * k = 1 + (1 + ++k); k = 2
		 * k = 1 + (1 + 3); k = 3
		 * k = 5
		 */
		System.out.println("k = " + k);
	}
	
	private static void testOperPrecedence017() {
		System.out.println("Test 15: int k = 1; k += ++k + k++");
		int k = 1; 
		k += ++k + k++;
		/*
		 * k = 1 + 2 + k++; k = 2
		 * k = 1 + 2 + 2; k = 3
		 * k = 5
		 */
		System.out.println("k = " + k);
	}
	
	private static void testOperPrecedence018() {
		int []a = {5,5}; 
		int b = 1; 
		a[b] = b = 0; 
		System.out.println(Arrays.toString(a));
	}
	
	private static void testOperPrecedence019() {
		int []a = {5,5}; 
		int b = 1; 
		a[b++] = b;
		System.out.println(Arrays.toString(a));
	}
	
	private static void testOperPrecedence020() {
		int []a = {5,5}; 
		int b = 1; 
		a[b = 0] = ++b;
		System.out.println(Arrays.toString(a));
	}
	
	private static void testOperPrecedence021() {
		int i = 4;
		int ia[][][] = new int[i][i = 3][i];
		System.out.println(ia.length + ", " + ia[0].length+", "+ ia[0][0].length);
	}
}