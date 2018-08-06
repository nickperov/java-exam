package com.nickperov.oca_1Z0_808.lambda;

public class CheckIfHopper implements CheckTrait {

	@Override
	public boolean test(Animal a) {
		return a.canHop();
	}

}
