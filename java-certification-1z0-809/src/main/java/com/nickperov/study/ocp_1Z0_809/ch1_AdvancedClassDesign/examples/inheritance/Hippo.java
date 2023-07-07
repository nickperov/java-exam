package com.nickperov.study.ocp_1Z0_809.ch1_AdvancedClassDesign.examples.inheritance;

public class Hippo extends HeavyAnimal {
		
	private double weight;
	
	public Hippo(String name, double weight) {
		this.name = name; this.weight = weight;
	} 
	@Override
	public String toString() {
		return "Name: " + name + ", Weight: " + weight;
	}
	
	@Override
	public void feed() {
	}
}