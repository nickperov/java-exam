package com.nickperov.oca_1Z0_803.ch4.wrappers;

public class StudExamWrappers001 {
	
	
	public static void main(String[] args) {
		testPrimitiveWrapper();
	}

	private static void testPrimitiveWrapper() {
		System.out.println("================================Test basic primitive wrappers================================");
		// Inboxing example
		
		Byte b = 125;
		Short s = 27895;
		Integer i = 1268975;
		Long l = 345l; // not possible to make implicit cast int -> Long
		Float f = 7.5567f;
		Double d = 5.689;
		Boolean boo = true; //not possible to cast int to boolean
		
		Object[] oArray = new Object[] {b,s,i,f,d,l,boo};
		for (Object o : oArray)
			System.out.println(o);
	}
}
