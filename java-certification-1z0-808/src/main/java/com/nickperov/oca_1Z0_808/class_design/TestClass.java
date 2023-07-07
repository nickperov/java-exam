package com.nickperov.oca_1Z0_808.class_design;

public class TestClass extends AbstractTestClass {

}


abstract class AbstractTestClass {
	
}

interface TestDesign {
	public void test();	
}


abstract interface TestExtDesign extends TestDesign {
	
	public void method();
	
	default public void templateMethod() {
		
	}
}

class Rodent { 
	protected static Integer chew() throws Exception {
		System.out.println("Rodent is chewing");
		return 1;
		}
	}
class Beaver extends Rodent {
	// Will not compile
	/*public Number chew() throws RuntimeException {
		System.out.println("Beaver is chewing on wood");
		return 2;
	}*/
	
	public static void main(String[] args) {
		try {
			Beaver.chew();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


