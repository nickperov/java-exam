package com.nickperov.oca_1Z0_803.ch7_inheritance;

public class StudExamInheritance {
	
	public static void main(String[] args) {
		
	}
}

class Animal {
	
	int weight;
	int age;
	String hairColor;
	
	public void eat() { /* Eat */ }
	
	public void rest() { /* Rest */ }
	
	public void move(int direction) {
		
	}
}

class Dog extends Animal {
	public void bark() {
		/* Bark */
	}
	
	@Override
	public void move(int direction) {
		// TODO Auto-generated method stub
		super.move(direction);
	}
	
}

class Cat extends Animal {
	public void meow() {
		/* Meow */
	}
}

