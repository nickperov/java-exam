package com.nickperov.study.ocp_1Z0_809.ch1_AdvancedClassDesign.examples.inheritance;

public class Lion extends Animal {
	
	public Lion(int idNumber, int age, String name) {
		this.idNumber = idNumber;
		this.age = age;
		this.name = name;
	}
	
	private int idNumber;
	private int age;
	private String name;

	@Override
	public void feed() {
		addMeat();
		System.out.println("Feed lion with meat");
	}
	
	private void addMeat() {
		System.out.println("Get meat");
	}
	
	@Override
	public String toString() {
		return "Lion, id: " + idNumber + "; age: " + age + "; name: " + name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Lion))
			return false;
		
		Lion otherLion = (Lion) obj;
		return this.idNumber == otherLion.idNumber;
	}
	
	public int hashCode() {
		return idNumber;
	}
}
