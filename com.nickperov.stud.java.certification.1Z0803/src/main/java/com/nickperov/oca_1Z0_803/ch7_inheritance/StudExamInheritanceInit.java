package com.nickperov.oca_1Z0_803.ch7_inheritance;

public class StudExamInheritanceInit {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		SubClassB b = new SubClassB(); 
	}
}

class SuperClassA {
	
	{
		System.out.println("A non-static block");
	}
	
	static {
		System.out.println("A static block");
	}
	
	SuperClassA() {
		System.out.println("A Constructor");
	}
}

class SubClassB extends SuperClassA {
	
	{
		System.out.println("B non-static block");
	}
	
	static {
		System.out.println("B static block");
	}
	
	public SubClassB() {
		System.out.println("B Constructor");
	}
	
}