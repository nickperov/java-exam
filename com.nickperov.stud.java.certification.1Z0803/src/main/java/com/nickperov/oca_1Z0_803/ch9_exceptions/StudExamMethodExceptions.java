package com.nickperov.oca_1Z0_803.ch9_exceptions;

public class StudExamMethodExceptions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	

}

// Example of checked exception
class RecordException extends Exception {
	public RecordException() {
		
	}
	
	public RecordException(String s) {
		super(s);
	}
}


class TestClass {
	public static void methodX() throws Exception {
		throw new AssertionError();
	}
	
	public static void main(String[] args) {
		try{
			methodX();
		} catch(Exception e) {
			System.out.println("EXCEPTION");
		}
	}
}