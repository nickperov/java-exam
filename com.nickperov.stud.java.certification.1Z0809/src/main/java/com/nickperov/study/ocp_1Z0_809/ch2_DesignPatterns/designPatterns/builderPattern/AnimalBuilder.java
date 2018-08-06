package com.nickperov.study.ocp_1Z0_809.ch2_DesignPatterns.designPatterns.builderPattern;

import java.util.List;

import com.nickperov.study.ocp_1Z0_809.ch2_DesignPatterns.designPatterns.immutableObject.Animal;

/*
 * Builder pattern
 */

public class AnimalBuilder {
	
	private String species;
	private int age;
	private List<String> favoriteFoods;
	
	public AnimalBuilder setAge(int age) {
		this.age = age;
		return this;
	}
	
	public AnimalBuilder setSpecies(String species) {
		this.species = species;
		return this;
	}
	
	public AnimalBuilder setFavoriteFoods(List<String> favoriteFoods) {
		this.favoriteFoods = favoriteFoods;
		return this;
	}
	
	public Animal build() {
		return new Animal(species, age, favoriteFoods);
	}

}
