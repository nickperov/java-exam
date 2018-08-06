package com.nickperov.oca_1Z0_803.ch7_inheritance;

public class StudExamMethodOverriding001 {
	
	public static void main(String[] args) {
		testMethodOverriding01();
		testMethodOverriding02();
	}

	@SuppressWarnings("static-access")
	private static void testMethodOverriding01() {
		SuperClass 	c1 = new SuperClass();
		SuperClass 	c2 = new SubClass();
		SubClass 	c3 = new SubClass();
		
		System.out.println("=======================================Test instance method=======================================");
		
		c1.method();
		c2.method();
		c3.method();
		((SuperClass)c3).method();
		
		// Static method
		System.out.println("=======================================Test static method=======================================");
		
		c1.printClassName();
		c2.printClassName();
		c3.printClassName();
		((SuperClass)c3).printClassName();
	}
	
	private static void testMethodOverriding02() {
		// Method execution in constructor
		System.out.println("=======================================Test method ovveriding 2=======================================");
		BB.test();
	}
}

class A {}
class B extends A {}

class SuperClass {
	
	static void printClassName() {
		System.out.println("Super class");
	}
	
	void method() {
		System.out.println("Super class");
	}
	
	public SuperClass testWithParameter(A a) throws Exception {
		return this;
	}
}

class SubClass extends SuperClass {
	static void printClassName() {
		System.out.println("Sub class");
	}
	
	void method() {
		System.out.println("Sub class");
	}
	
	@Override
	public SubClass testWithParameter(A a) { // Do not need to throw the exception
		// May return SubClass -> as sub class of original class 
		return this;
	}
}


class AA {
   AA() {  print();   }
   void print() { System.out.println("AA"); }
}
class BB extends AA {
   int i =   4;
   
   public static void test(){
	  AA a = new BB();
      a.print();
   }
   void print() { System.out.println(i); }
}


class Super {
	protected void m1() {}
}

class Sub extends Super {
	
	@Override
	public void m1() {  // protected or public 
		// Some code
	}
	
}