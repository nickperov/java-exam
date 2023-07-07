package com.nickperov.study.ocp_1Z0_809.ch2_DesignPatterns.designPatterns.factory;

public abstract class Food {
	private int quantity;
	
	public Food(int quantity) {
		this.quantity = quantity;
	}
	public int getQuantity() {
		return this.quantity;
	}
	
	public abstract void consumed();
}