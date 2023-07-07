package com.nickperov.study.ocp_1Z0_809.ch2_DesignPatterns.designInterface;

public interface Run extends Walk {
	public abstract boolean canHuntWhileRunning();
	abstract double getMaxSpeed();
}
