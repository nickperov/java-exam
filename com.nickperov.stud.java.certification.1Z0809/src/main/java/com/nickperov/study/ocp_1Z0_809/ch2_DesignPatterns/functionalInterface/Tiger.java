package com.nickperov.study.ocp_1Z0_809.ch2_DesignPatterns.functionalInterface;

public class Tiger implements Sprint {

	@Override
	public void sprint(Animal animal) {
		System.out.println("Animal is sprinting fast! " + animal.toString());
	}

}
