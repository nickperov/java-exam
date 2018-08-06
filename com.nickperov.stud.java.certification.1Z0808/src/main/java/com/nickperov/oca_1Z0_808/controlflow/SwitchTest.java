package com.nickperov.oca_1Z0_808.controlflow;

public class SwitchTest {
	
	public static void main(String[] args) {
		testSimpleSwitch();
		
		testMixedSwitch();
		
		testMixedSwitch2();
	}
	
	private static void testSimpleSwitch() {
		System.out.println("=============Test simple switch============");
		
		int dayOfWeek = 5;
		switch (dayOfWeek) {
			default: System.out.println(" Weekday");
				break;
			case 0: System.out.println(" Sunday");
				break;
			case 6: System.out.println(" Saturday");
				break;
		} 
	}
	
	
	private static void testMixedSwitch() {
		System.out.println("=============Test mixed switch============");
		
		int dayOfWeek = 5;
		switch (dayOfWeek) {
			case 0: System.out.println(" Sunday");
				break;
			default: System.out.println(" Weekday");
			case 6: System.out.println(" Saturday");
		}
	}
	
	private static void testMixedSwitch2() {
		System.out.println("=============Test mixed switch2============");
		final int someDayNumber = 3; // should be final
		int dayOfWeek = 6;
		switch (dayOfWeek) {
			default: System.out.println(" Weekday");
			case 0: System.out.println(" Sunday");
				break;
			case 6: System.out.println(" Saturday");
			case someDayNumber:
				System.out.println("Some day");
		}
	}
}
