package com.nickperov.study.ocp_1Z0_809.ch2_DesignPatterns.designInterface;

public class Lion implements Run {

	@Override
	public boolean isQuadruped() {
		return true;
	}

	@Override
	public boolean canHuntWhileRunning() {
		return true;
	}

	@Override
	public double getMaxSpeed() {
		return 100;
	}
}