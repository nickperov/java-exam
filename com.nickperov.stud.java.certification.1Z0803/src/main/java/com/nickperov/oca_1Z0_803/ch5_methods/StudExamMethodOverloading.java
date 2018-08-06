package com.nickperov.oca_1Z0_803.ch5_methods;

public class StudExamMethodOverloading {
    public static void main(String[] args){
        
    	// Try methods with primitive - wrappers arguments
    	Integer a = 4; new TestPrimitivesArgsClass01().probe(a); //5
        int b = 4; new TestPrimitivesArgsClass01().probe(b); //6 
        
        
        // Try method with Exception object arguments
        TestExceptionArgsClass tc = new TestExceptionArgsClass();
        tc.method(null);
    	
        // Try var-args
        TestVarargs tv  = new TestVarargs();
        tv.test1(10, 20);
        tv.test1();
        // Invalid
        //tv.test1(1000);
        //tv.test1(10,10,10,40);
        
        // Test primitives arguments (legacy of boxing-unboxing) widening is preferred
    	Integer a2 = 4; new TestPrimitivesArgsClass02().probe(a2); //5
        int b2 = 4; new TestPrimitivesArgsClass02().probe(b2); //6  int -> (widen) to long (not boxing to Integer!!!!!)
    }
}

class MethodOverloadClass1 {
	void perform_work(int time){ } 
	int perform_work(int time, int speed){
		return time*speed;
	} 
}

class MethodOverloadClass2 {
	// Incorrect overloading
	/*
	 * void perform_work(int time){} 
	 * 
	 * int perform_work(int speed){return speed ;}
	 * 
	 * */ 
}

class MethodOverloadClass3 {
	
	/*
	 * Different method names (case sensitive) not overloading
	 * 
	 */
	
	void perform_work(int time){ }
	void Perform_work(int time){ }
}

class TestPrimitivesArgsClass01 {
    void probe(int... x) { System.out.println("In ..."); }  //1
    
    void probe(Integer x) { System.out.println("In Integer"); } //2
    
    void probe(long x) { System.out.println("In long"); } //3 
    
    void probe(Long x) { System.out.println("In LONG"); } //4
}

class TestPrimitivesArgsClass02 {
    void probe(Integer x) { System.out.println("In Integer"); } //2
    
    void probe(long x) { System.out.println("In long"); } //3 
}

class TestExceptionArgsClass {
	public void method(Object o){
		System.out.println("Object Version");
	}
	public void method(java.io.FileNotFoundException s){
		System.out.println("java.io.FileNotFoundException Version");
	}
	
	public void method(java.io.IOException s){
		System.out.println("IOException Version");
	}
}

class TestVarargs {
	public void test1(int i, int... j){ System.out.println("1"); }
	public void test1(int... i ){ System.out.println("2"); }
	public void test1(int i, int j){ System.out.println("3"); }
}