package com.nickperov.oca_1Z0_808.class_design.child;

import com.nickperov.oca_1Z0_808.class_design.parent.ParentClassExample001;
@SuppressWarnings("unused")
public class ChildClassExample001 extends ParentClassExample001 {
	
	public static void main(String[] args) {
		new ChildClassExample001().testValue();
	}
	
	
	private int value = 50;
	
	public void testValue() {
		int testValue = getValue(); // accessible 
		
		System.out.println(testValue);
		
		ParentClassExample001 parent = new ParentClassExample001();
		
		//parent.getValue(); // not accessible 
		
		System.out.println(name); // accessible 
		System.out.println(super.name);
		System.out.println(this.name);
	}
	
	//@Override --- shadowing (not overriding)
	private void privateTestMethod() {}
	//@Override --- shadowing (not overriding)
	void pakagePrivateTestMethod() {}
	@Override
	protected void protectedTestMethod() {}
	@Override
	public void publicTestMethod() {}
	
}
