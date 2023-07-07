package com.nickperov.study.ocp_1Z0_809.ch2_DesignPatterns.designInterface;

public class Eagle implements Fly {

	@Override
	public int getWingSpan() throws Exception {
		return 15;
	}
	
	@Override
	public void land() {
		System.out.println("Eagle is diving fast");
	}

}
