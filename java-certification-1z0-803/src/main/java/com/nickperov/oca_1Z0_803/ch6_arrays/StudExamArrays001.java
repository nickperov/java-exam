package com.nickperov.oca_1Z0_803.ch6_arrays;
import java.util.ArrayList;
import java.util.Arrays;

public class StudExamArrays001 {
	
	private static final String[] cities = new String[] {"Moscow", "New York", "London", "Paris", "Berlin", "Amsterdam", "Roma", "Madrid", "Barselona", "Auckland", "Tokyo", "Los-Angeles", "Zurich", "San Francisco"};
	
	public static void main(String[] args) {
		testArrayDeclaration();
		
		testArrayCopy();
		
		testArraysClass();
		
		testMultiDimmensionArray001();
		
		testMultiDimmensionArray002();
		
		testArrayList();
	}
	
	private static void testArrayDeclaration() {
		
		System.out.println("================================================Array declaration test========================================================");
		
		//String[] clockTypes = new String[3]; // Brackets after type
		String[] clockTypes = new String[]{"Wrist watch", "Desk clock", "Wall clock"};
		
		int alarms[] = new int[5]; // Brackets after varaiable name
		
		System.out.println(clockTypes[2]);
		System.out.println("Num of alarms: " + alarms.length);
		
		Object[] objA1 = {new Object(), new Object()};
		System.out.println("Obj array size: " + objA1.length);
		
		Object[] objA2 = {new Object[3], new Object[2]};
		System.out.println("Obj array size: " + objA2.length);
	}
	
	private static void testArrayCopy() {
		System.out.println("================================================Array copy test========================================================");
		
		String[] citiesCopy = new String[10];
		
		System.out.println("Sourse array:");
		traceArray(cities);
		
		System.out.println("Copy 5, 0 -> 0:");
		System.arraycopy(cities, 0, citiesCopy, 0, 5);
		traceArray(citiesCopy);
		

		System.out.println("Copy again first 5 to the end, 0 -> 5:");
		System.arraycopy(cities, 0, citiesCopy, 5, 5);
		traceArray(citiesCopy);
		
		System.out.println("Reset array");
		resetArray(citiesCopy);
		traceArray(citiesCopy);
		
		
		System.out.println("Copy last 6 in the middle, 5 -> 2:");
		System.arraycopy(cities, 5, citiesCopy, 2, 6);
		traceArray(citiesCopy);
		
		System.out.println("Copy 2 last within the same array, 6 -> 8");
		System.arraycopy(citiesCopy, 6, citiesCopy, 8, 2);
		traceArray(citiesCopy);
	}
	
	
	private static void testArraysClass() {
		System.out.println("================================================Arrays class methods test========================================================");
		
		traceArray(cities);
		
		System.out.println("Make sort");
		Arrays.sort(cities);
		traceArray(cities);
		
		System.out.println("Binary search");
		int index = Arrays.binarySearch(cities, "Roma");
		System.out.println("found index = " + index);
		
		System.out.println("Coppy of range from array");
		String[] citiesCopy = Arrays.copyOfRange(cities, 2, 6);
		traceArray(citiesCopy);
		
		System.out.println("Fill the copy of array with some value");
		Arrays.fill(citiesCopy, 2, 4, "Empty city");
		traceArray(citiesCopy);
	}
	
	private static void testMultiDimmensionArray001() {

		System.out.println("================================================Multi dimension array test 001========================================================");
		
		char [][] ticTacToeBoard = new char[3][3];
		
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 3; x++)
				ticTacToeBoard[x][y] = '-';
		}
		
		ticTacToeBoard[0][0] = 'X';
		ticTacToeBoard[1][1] = '0';
		ticTacToeBoard[0][2] = 'X';
		
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 3; x++)
				System.out.print(ticTacToeBoard[x][y] + " ");
			
			System.out.println();
		}
		
	}
	
	private static void testMultiDimmensionArray002() {
		System.out.println("================================================Multi dimension array test 002========================================================");
		
		// Initialization example
		int [][][] array3D = new int [3] [] [];
		array3D[0] = new int [5][];
		array3D[1] = new int [3][];
		
		array3D[0][0] = new int[7];
		array3D[0][1] = new int[4];
		array3D[1][0] = new int[5];
		
		System.out.println("Dimension x: " + array3D.length);
		for (int i = 0; i < array3D.length; i++) {
			System.out.println("Dimension y: " + (array3D[i] != null ? array3D[i].length : "0"));
			for (int k = 0; array3D[i] != null && k < array3D[i].length; k++)
				System.out.println("Dimension z: " + (array3D[i][k] != null ? array3D[i][k].length : "0"));	
		}
	}
	
	private static void testArrayList() {
		System.out.println("================================================ArrayList test========================================================");
		ArrayList<Float> temperature = new ArrayList<>();
		
		temperature.add(28.4f);
		temperature.add(27.3f);
		temperature.add(22.5f);
		temperature.add(25.7f);
		temperature.add(24.2f);
		temperature.add(23.9f);
		temperature.add(25.8f);
		
		Float avg = 0f;
		for (Float f : temperature)
			avg += f;
		
		avg /= temperature.size();
		
		System.out.println("Average temp. " + avg);
		
		ArrayList<int[]> listOfArrays = new ArrayList<>(); // ArrayList could store arrays
		listOfArrays.add(new int[4]);
	}
	
	private static void resetArray(Object [] array) {
		for (int i = 0; i < array.length; i++)
			array[i] = null;
	}
	
	private static void traceArray(Object [] array) {
		for (Object o : array)
			System.out.print(o + " ");
		
		System.out.println();
		System.out.println();
	}
}
