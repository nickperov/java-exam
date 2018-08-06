package com.nickperov.study.ocp_1Z0_809.ch1_AdvancedClassDesign.examples.inner_classes;

public class OuterWithAnonymous {
	
	abstract class SaleTodayOnly { 
		abstract int dollarsOff();
	}
	
	interface Discount {
		int dollarsOff();
	}
	
	public int admission(int basePrice) {
		SaleTodayOnly sale = new SaleTodayOnly() {
			@Override
			int dollarsOff() {
				return 3;
			}
		};
		
		return basePrice - sale.dollarsOff();
	}
	
	public int pay() {
		return admission(5, new Discount() {
			
			@Override
			public int dollarsOff() {
				return 1;
			}
		});
	}
	
	public int admission(int basePrice, Discount discount) {
		return basePrice - discount.dollarsOff();
	}
	
}
