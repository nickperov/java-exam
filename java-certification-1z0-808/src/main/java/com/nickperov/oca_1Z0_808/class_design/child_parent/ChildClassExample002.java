package com.nickperov.oca_1Z0_808.class_design.child_parent;

@SuppressWarnings("unused")
public class ChildClassExample002 extends ParentClassExample002 {
	
	public static void main(String[] args) {
		new ChildClassExample002().testValue();
	}
	
	
	private int value = 50;
	
	public void testValue() {
		int testValue = getValue(); // accessible 
		
		System.out.println(testValue);
		
		ParentClassExample002 parent = new ParentClassExample002();
		
		//parent.getValue(); // not accessible 
		
		System.out.println(name); // accessible 
		System.out.println(super.name);
		System.out.println(this.name);
	}
	
	//@Override --- shadowing (not overriding)
	private void privateTestMethod() {}
	
	@Override 
	void packagePrivateTestMethod() {} // same package 
	@Override
	protected void protectedTestMethod() {}
	@Override
	public void publicTestMethod() {}
	
}
