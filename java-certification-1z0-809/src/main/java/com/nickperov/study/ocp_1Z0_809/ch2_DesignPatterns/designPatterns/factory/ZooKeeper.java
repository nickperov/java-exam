package com.nickperov.study.ocp_1Z0_809.ch2_DesignPatterns.designPatterns.factory;

public class ZooKeeper {
	public static void main(String[] args) {
		final Food food = FoodFactory.getFood("polar bear");
		food.consumed();
	}
}
