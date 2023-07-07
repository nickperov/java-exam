package com.nickperov.oca_1Z0_803.ch7_inheritance;

public class StudExamFieldInheritance {
	
	public static void main(String[] args){
		testStaticFieldInheritance01();
		testStaticFieldInheritance02();
		
		testFieldInheritance01();
	}
	
	
	private static void testStaticFieldInheritance01() {
		System.out.println(SubBank.ID); // Will print QBANK (no call for Sub class)
	}
	
	private static void testStaticFieldInheritance02() {
		System.out.println(SubBank.ID); // Will print QBANK (no call for Sub class)
		new SubBank();
		System.out.println(SubBank.ID); // updated ID value -> Sub QBANK
	}
	
	
	private static void testFieldInheritance01() {
		
		System.out.println("Super index: " + new SuperStorage().index);
		
		System.out.println("Sub index: " + new SubStorage().index);
		
		System.out.println("Sub index, after cast: " + ((SuperStorage)new SubStorage()).index); // Value from super class -> 1
		
	}
	
	@SuppressWarnings({ "unused", "static-access" })
	private static void testFieldInheritance02() {
		Sample s = new Sample();
		int j = s.thevalue;       // Field defined in interface is implicitly static and final
		int k = IInt.thevalue;    
	}
}

/**
 * Example of static field inheritance
 *
 */

class SuperBank { 
	static String ID = "QBANK"; 
}

class SubBank extends SuperBank {
   static {
	   System.out.print("In Sub");
	   ID = "Sub QBANK";
   }
}

/**
 * Example of field inheritance
 *
 */

class SuperStorage {
	final int index = 1;
}

class SubStorage extends SuperStorage {
	final int index = 100; // Field shadowing
}

/**
 * Example of field inheritance with interface
 *
 */

class Sample implements IInt {
}

interface IInt{
	int thevalue = 0;
}