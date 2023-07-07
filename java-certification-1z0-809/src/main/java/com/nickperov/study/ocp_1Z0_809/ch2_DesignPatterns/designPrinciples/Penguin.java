package com.nickperov.study.ocp_1Z0_809.ch2_DesignPatterns.designPrinciples;

/*
 * Example of composing objects
 * reuse of functionality of other classes
 */

public class Penguin {
	
	private final Flippers flippers;
	private final WebbedFeet webbedFeet;
	
	public Penguin() {
		this.flippers = new Flippers();
		this.webbedFeet = new WebbedFeet();
	}
	
	public void flap() {
		this.flippers.flap();
	}
	
	public void kick() {
		this.webbedFeet.kick();
	}
}