package com.nickperov.oca_1Z0_808.class_design.parent;

public class ParentClassExample001 {

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
