package com.nickperov.study.ocp_1Z0_809.ch3_GenericsAndCollections.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class MethodReferencesExamples {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		Comparator<Duck> byWeight = (d1, d2) -> DuckHelper.compareByWeight(d1, d2);
		
		Comparator<Duck> byWeightMR = DuckHelper::compareByWeight;
		
		// For static methods
		Consumer<List<Integer>> methodRef1 = Collections::sort;
		Consumer<List<Integer>> lambdaf1 = l -> Collections.sort(l);
		
		// For instance methods of a specific instance
		String str = "abc";
		Predicate<String> methodRef2 = str::startsWith;
		Predicate<String> lambda2 = p -> str.startsWith(p);
		
		// For instance methods without knowing particular instance
		Predicate<String> methodRef3 = String::isEmpty;
		Predicate<String> lambda3 = s -> s.isEmpty();
		
		// For constructor
		Supplier<ArrayList<String>> methodRef4 = ArrayList::new;
		Supplier<ArrayList<String>> lambda4 = () -> new ArrayList<>();
	}
}

class DuckHelper {
	
	public static int compareByWeight(Duck d1, Duck d2) {
		return d1.getWeight() - d2.getWeight();
	}
	
	public static int compareByName(Duck d1, Duck d2) {
		return d1.getName().compareTo(d2.getName());
	}
}