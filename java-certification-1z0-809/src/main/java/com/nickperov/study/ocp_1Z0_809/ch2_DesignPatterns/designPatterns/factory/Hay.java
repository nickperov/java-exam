package com.nickperov.study.ocp_1Z0_809.ch2_DesignPatterns.designPatterns.factory;

public class Hay extends Food {

	public Hay(int quantity) {
		super(quantity);
	}

	@Override
	public void consumed() {
		System.out.println("Hay eaten: " + getQuantity());
	}
}