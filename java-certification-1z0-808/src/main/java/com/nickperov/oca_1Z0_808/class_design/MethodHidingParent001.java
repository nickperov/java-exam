package com.nickperov.oca_1Z0_808.class_design;

public class MethodHidingParent001 {
	
	public static void printName() {
		System.out.println(MethodHidingParent001.class.getName());
	}
	
	public void test() {
		printName();
	}
}
