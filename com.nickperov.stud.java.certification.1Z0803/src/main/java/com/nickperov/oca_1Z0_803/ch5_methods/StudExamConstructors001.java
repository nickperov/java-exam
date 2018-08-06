package com.nickperov.oca_1Z0_803.ch5_methods;

public class StudExamConstructors001 {
	
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		A a = new A(); // Default constructor added by compiler
		B b = new B(); // constructor taken no parameters
		C c = new C(1000); // not valid -> 		C c = new C(); (no default constructor)
		
		D d1 = new D();
		D d2 = new D(5000);
	}
	
}

class A {
	int i;	
}

class B {
	int i;
	
	public B() {
		i = 100;
	}
}

class C {
	int i;
	
	public C(int i) {
		this.i = i; // this keyword have to be used
	}
}


class D {
	int i;
	
	public D() {
		this(100); // valid only as the first line of constructor
	}
	
	public D(int i) {
		this.i = i;
	}
}


class G {
	int i;
	
	public G(int i) {
		this.i = i;
	}
	
	public int getI() {
		return i;
	}
}

class F extends G {

	int j;
	
	public F() {    // constructor have to be present
		super(100); // should contains super call
	}
	
	@SuppressWarnings("unused")
	public void testMethod() {
		this.getI();
		super.getI();
		
		int k = this.i;
		int l = this.j;
	}
}

class I extends F {
	// Constructor is not needed because F contains constructor with no parameters
	
	public void testMethod() {
	}
}