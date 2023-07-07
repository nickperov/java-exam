package com.nickperov.oca_1Z0_808.class_design;

public class MethodHidingTest {
	
	public static void main(String[] args) {
		
		MethodHidingParent001 parent = new MethodHidingParent001();
		MethodHidingChild001 child = new MethodHidingChild001();
		
		MethodHidingParent001 child2 = new MethodHidingChild001();
		
		parent.test();
		child.test();
		child2.test();
	}

}
