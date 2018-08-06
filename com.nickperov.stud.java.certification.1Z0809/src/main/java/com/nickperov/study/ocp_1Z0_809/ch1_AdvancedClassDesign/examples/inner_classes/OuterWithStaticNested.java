package com.nickperov.study.ocp_1Z0_809.ch1_AdvancedClassDesign.examples.inner_classes;

public class OuterWithStaticNested {
	static class Nested {
		private int price = 6;
	}
	
	public static void main(String[] args) {
		Nested nested = new Nested();
		System.out.println(nested.price);
	}
}
