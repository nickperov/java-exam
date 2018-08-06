package com.nickperov.study.ocp_1Z0_809.ch2_DesignPatterns.designPatterns.factory;

public class Fish extends Food {

	public Fish(int quantity) {
		super(quantity);
	}

	@Override
	public void consumed() {
		System.out.println("Fish eaten: " + getQuantity());
	}
}