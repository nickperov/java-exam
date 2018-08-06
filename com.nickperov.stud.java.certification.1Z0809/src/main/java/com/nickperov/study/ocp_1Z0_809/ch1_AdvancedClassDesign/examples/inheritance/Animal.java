package com.nickperov.study.ocp_1Z0_809.ch1_AdvancedClassDesign.examples.inheritance;

public abstract class Animal {
	
	String name = "???";
	public void printName() { 
		System.out.println( name); 
	}
	
	public abstract void feed();
}