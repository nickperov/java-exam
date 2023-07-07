package com.nickperov.study.ocp_1Z0_809.ch2_DesignPatterns.designPatterns.factory;

public class Pellets extends Food {

	public Pellets(int quantity) {
		super(quantity);
	}

	@Override
	public void consumed() {
		System.out.println("Pellets eaten: " + getQuantity());
	}
}