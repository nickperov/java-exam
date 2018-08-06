package com.nickperov.oca_1Z0_803.ch5_methods;

public class StudExamVariables001 {
	
	int i; // instance varibale
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
	
		// Local variables
		int i = 1; // local method variable
		
		{
			int k = 0; // local in the block of code
			
		}
		
		i++;
		
		StudExamVariables001 stVar = new StudExamVariables001();
		stVar.i++;
		
		stVar.testInstanceVar001();
		stVar.testInstanceVar002();
		stVar.testInstanceVar003(50);
		// k++; could not be used outside the block
	}
	
	private void testInstanceVar001() {
		i++;
		
		System.out.println(i);
	}
	
	private void testInstanceVar002() {
		int i = 0; 
		
		i++;
		this.i = i; // in case of local var with the same name declared within the method use -> this.
		
		System.out.println(this.i);
	}
	
	private void testInstanceVar003(int i) {
		i++;
		this.i = i; // in case of method parameter with the same name declared within the method use -> this.
		
		System.out.println(this.i);
	}
	
}
