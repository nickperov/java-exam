package com.nickperov.study.ocp_1Z0_809.ch2_DesignPatterns.designPatterns.singleton;

public class LlamaTrainer {
	
	public boolean feedLlamas(int numberOfLlamas) {
		int amountNeedded = 5 * numberOfLlamas;
		HayStorage hayStorage = HayStorage.getInstance();
		
		if (hayStorage.getHayQuantity() < amountNeedded) {
			hayStorage.addHay(amountNeedded + 10);
		}
		
		boolean fed = hayStorage.removeHay(amountNeedded);
		if (fed) System.out.println("Llamas have beed fed");
		return fed;
	}
}
