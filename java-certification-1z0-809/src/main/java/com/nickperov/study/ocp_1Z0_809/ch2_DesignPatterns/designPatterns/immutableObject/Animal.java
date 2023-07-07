package com.nickperov.study.ocp_1Z0_809.ch2_DesignPatterns.designPatterns.immutableObject;

import java.util.ArrayList;
import java.util.List;

/*
 * Immutable class example
 */
public final class Animal {
	
	private final String species;
	private final int age;
	
	private final List<String> favoriteFoods;
	
	public Animal(String species, int age, List<String> favoriteFoods) {
		this.species = species;
		this.age = age;
		if (favoriteFoods == null)
			throw new RuntimeException("favoriteFoods is required");
		this.favoriteFoods = new ArrayList<String>(favoriteFoods); // Copy object!!!
	}
	
	// Make class mutable
	/*public List<String> getFavoriteFoods() {
		return favoriteFoods;
	}*/
	//Collections.unmodifiableCollection(favoriteFoods); can be used
	
	public String getSpecies(){
		return species;
	}
	
	public int getAge() {
		return age;
	}
	
	public int getFavoriteFoodsCount() {
		return favoriteFoods.size();
	}
	
	public String getFavoriteFood(int index) {
		return favoriteFoods.get(index);
	}

}
