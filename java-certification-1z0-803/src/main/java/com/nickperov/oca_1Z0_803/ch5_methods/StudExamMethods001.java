package com.nickperov.oca_1Z0_803.ch5_methods;

public class StudExamMethods001 {
	

	/*
	 * legal main method declaration
	 * 
	 * public static void main(String[] args)
	 * public static void main(String... args)
	 * 
	 * 
	 * public static void main(String args) --- legal,  but is not a main method
	 * 
	 */
	
	public static void main(String[] args) {
	}
}


class MathTools {
	public int findLowerNumber(int number1, int number2) {
		int result;
		if (number1 > number2)
			result = number2;
		else
			result = number1;
			
		return result;
	}
	
	// Example of overloaded method
	public int findLowerNumber(int number1, int number2, int number3) {
		int res1 = findLowerNumber(number1, number2);
		int res2 = findLowerNumber(number2, number3);
		
		return findLowerNumber(res1, res2);
	}
	
	public int findLowerNumber(int number1, int number2, long number3) {
		// TODO Code
		
		return 0;
	}
}
