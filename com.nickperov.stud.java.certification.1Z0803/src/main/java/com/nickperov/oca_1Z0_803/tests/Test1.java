package com.nickperov.oca_1Z0_803.tests;

public class Test1 {
	public static void main(String[] args){
		AA a = new AA();
		BB b = new BB(); 
		
		a = (BB) (I) b;
		a = (AA)b;
		a = (BB)b;
		
		System.out.println("Ok");
		
	//	stringBilderTest1();
		
		B2.m(args);
		
		XXX x = new YYY();
		try {
			x.m();
		} catch (Exception e) {
			System.out.println("EXCEPTION !!!!");
		}
	}
	
	
	private static void stringBilderTest1() {
		
		StringBuilder b1 = new StringBuilder("snorkler");
		StringBuilder b2 = new StringBuilder("yoodler");
		
		b1.append(b2.substring(2, 5).toUpperCase());
		
		System.out.println(b1);
		System.out.println(b2);
		
		System.out.println("=============================");
		
		b1 = new StringBuilder("snorkler");
		b2 = new StringBuilder("yoodler");
		
		b2.insert(3, b1.append("a"));
		
		System.out.println(b1);
		System.out.println(b2);
		
		System.out.println("=============================");
		
		b1 = new StringBuilder("snorkler");
		b2 = new StringBuilder("yoodler");
		
		
		b1.replace(3, 4, b2.substring(4)).append(b2.append(false));
		
		System.out.println(b1);
		System.out.println(b2);
	}
	
}

interface I{
}

class AA implements I{
}

class BB extends AA {
}

class C extends BB {
}

class A1{
	   final int fi = 10;
	}

class B1 extends A1{
	int fi = 15;
	public static void m(String[] args){
		B1 b = new B1();
		b.fi = 20;
		System.out.println(b.fi);
		System.out.println(  (  (A1) b  ).fi  );
	}
}

class A2{
	A2() {  print();   }
	void print() { System.out.println("A"); }
}
class B2 extends A2 {
	int i =   4;
	public static void m(String[] args){
		A2 a = new B2();
		a.print();
	}
	void print() { System.out.println(i); }
}

class XXX {
	public void m() throws Exception {
		throw new Exception();
	}
}

class YYY extends XXX {
	public void m() {}
}


