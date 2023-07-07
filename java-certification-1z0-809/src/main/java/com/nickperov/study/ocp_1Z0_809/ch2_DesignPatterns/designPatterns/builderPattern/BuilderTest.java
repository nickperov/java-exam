package com.nickperov.study.ocp_1Z0_809.ch2_DesignPatterns.designPatterns.builderPattern;

import java.util.Arrays;

import com.nickperov.study.ocp_1Z0_809.ch2_DesignPatterns.designPatterns.immutableObject.Animal;

public class BuilderTest {
	
	public static void main(String[] args) {
		AnimalBuilder duckBuilder = new AnimalBuilder();
		
		duckBuilder.setAge(4).setFavoriteFoods(Arrays.asList("grass","fish")).setSpecies("duck");
		Animal duck = duckBuilder.build();
		
		Animal flamingo = new AnimalBuilder().setFavoriteFoods(Arrays.asList("algae", "insects")).setSpecies("flamingo").build();
	}
}