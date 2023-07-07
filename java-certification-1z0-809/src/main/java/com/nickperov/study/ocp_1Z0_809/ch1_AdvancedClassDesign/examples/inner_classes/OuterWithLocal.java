package com.nickperov.study.ocp_1Z0_809.ch1_AdvancedClassDesign.examples.inner_classes;

public class OuterWithLocal {
	
	private int length = 5;
	public void calculate() {
		final int width = 20; // final or effectively final
		class Inner {
			public void multiply() {
				System.out.println(length * width);
			}
		}
		Inner inner = new Inner();
		inner.multiply();
	}
	
	public static void main(String[] args) {
		OuterWithLocal outer = new OuterWithLocal();
		outer.calculate();
	}
}
