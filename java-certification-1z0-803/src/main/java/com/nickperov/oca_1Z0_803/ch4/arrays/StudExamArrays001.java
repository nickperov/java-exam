package com.nickperov.oca_1Z0_803.ch4.arrays;

public class StudExamArrays001 {
	
	public static void main(String[] args) {
		arrayDeclarationTest();
	}

	private static void arrayDeclarationTest() {
		System.out.println("===============================Array declaration test====================================");
		
		int[] array1 = new int[3];
		int[] array2 = new int[]{1,2,3,4};
		int array3[] = new int[7];
		
		System.out.println("array1 length: " + array1.length + "; array2 length: " + array2.length + "; array3 length: " + array3.length ); 
				
		int[] array4[] = new int[3][5];
		int[][] array5 = new int[3][5];
		int array6[][] = new int[3][5];
		
		System.out.println("array4 length: " + array4.length + "; array5 length: " + array5.length + "; array6 length: " + array6.length );
	}
}
