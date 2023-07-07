package com.nickperov.study.ocp_1Z0_809.ch2_DesignPatterns.designPatterns.singleton;

/*
 * Example of singleton (static block initialization)
 */
public class StaffRegister {
	
	private static final StaffRegister instance;
	
	static {
		instance = new StaffRegister();
	}
	
	private StaffRegister() {}

	public static StaffRegister getInstance() {
		return instance;
	}
}