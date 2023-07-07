package com.nickperov.oca_1Z0_808.lambda;

public class Animal {
	
	private final String species;
	private final boolean canHop;
	private final boolean canSwim;
	
	public Animal(String speciesName, boolean hopper, boolean swimmer) {
		this.species = speciesName;
		this.canHop = hopper;
		this.canSwim = swimmer;
	}
	
	public boolean canHop() { return canHop; }
	public boolean canSwim() { return canSwim; }
	@Override
	public String toString() { return species; }
}
