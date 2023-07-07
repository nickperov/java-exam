package com.nickperov.study.ocp_1Z0_809.ch2_DesignPatterns.designPrinciples;

// Encapsulation example
public class Animal {
	
	private String species;
	private int age;
	
	public Animal(String species) {
		this.setSpecies(species);
	}
	
	public String getSpecies() {
		return this.species;
	}
	
	public void setSpecies(String species) {
		this.species = species;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public void setAge(int age) {
		if (age < 0) {
			throw new IllegalArgumentException("Age cannot be negative");
		}
		this.age = age;
	}
}