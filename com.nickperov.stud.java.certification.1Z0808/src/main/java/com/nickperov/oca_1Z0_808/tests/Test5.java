package com.nickperov.oca_1Z0_808.tests;

import java.util.ArrayList;
import java.util.List;

public class Test5 {
	
	public static void main(String[] args) {
		testPrimitiveTypes();
		
		testWrapperTypes();
		
		listTest();
		
		testSubStatic(null);
	}

	private static void testPrimitiveTypes() {
		
		byte 	b = 0;
		short 	s = 0;
		int 	i = 0;
		char 	c = 0;
		
		if (b == s) {}
		if (b == i) {}
		if (b == c) {}
		if (i == c) {}
		if (s == c) {}
	}
	
	private static void testWrapperTypes() {
		
		Integer		i = 0;
		byte 		b = 0;
		short 		s = 0;
		char 		c = 0;
		
		if (b == s) {}
		if (b == i) {}
		if (b == c) {}
		if (i == c) {}
		if (s == c) {}
	}
	
	private static void testWrapperTypeConstr() {
		
		Integer		i = new Integer(0);
		Byte 		b1 = new Byte((byte)0);
		Byte 		b2 = new Byte("0");
		Byte 		b3 = Byte.valueOf((byte)0);
		Byte 		b4 = Byte.valueOf("0");
		Byte 		b5 = Byte.parseByte("0");
	}
	
	private static void listTest() {
		try {
	        List list = new ArrayList();
	        list.add("val1"); //1
	        list.add(0, "val1"); //2
	        list.add(1, "val2"); //2
	        list.add(4, "val3"); //3
	        System.out.println(list);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	private static void testSubStatic(String[] args){
	      System.out.println(Sub.ID);
	      new Sub();
	}
}

class Super { 
	static { System.out.print("In Super "); }
	static String ID = "QBANK";
}

class Sub extends Super{
   static { System.out.print("In Sub "); }
}
