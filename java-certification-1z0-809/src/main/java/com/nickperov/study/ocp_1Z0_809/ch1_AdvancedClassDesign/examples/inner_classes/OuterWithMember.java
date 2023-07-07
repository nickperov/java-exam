package com.nickperov.study.ocp_1Z0_809.ch1_AdvancedClassDesign.examples.inner_classes;

public class OuterWithMember {
	
	private String greating = "Hi";
	
	protected class Inner {
		public int repeat = 3;
		public void go() {
			for (int i = 0; i < repeat; i++) {
				System.out.println(greating);
			}
		}
	}
	
	public void callInner() {
		Inner inner = new Inner();
		inner.go();
	}
	
	public static void main(String[] args) {
		OuterWithMember outer = new OuterWithMember();
		outer.callInner();
		
		Inner inner = outer.new Inner();
		inner.go();
	}

}
