package com.nickperov.oca_1Z0_808.class_design.child_parent;

public class ParentClassExample002 {

	private int value = 10;
	
	protected String name = "Bob";
	
	protected int getValue() {
		return value;
	}
	
	@SuppressWarnings("unused")
	private void privateTestMethod() {}
	void packagePrivateTestMethod() {}
	protected void protectedTestMethod() {}
	public void publicTestMethod() {}
}
