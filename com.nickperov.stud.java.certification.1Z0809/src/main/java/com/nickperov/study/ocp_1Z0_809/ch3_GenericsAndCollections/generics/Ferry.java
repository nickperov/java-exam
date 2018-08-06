package com.nickperov.study.ocp_1Z0_809.ch3_GenericsAndCollections.generics;

import java.util.ArrayList;
import java.util.List;

public class Ferry {
	
	public void loadTruck(Truck <? extends Product> truck ) {}

	public void unloadToDock(List<? extends Product> ferryTrucks, List<? super Product> dockTrucks) {
		for (Product product : ferryTrucks) {
			dockTrucks.add(product);
		}	
	}
}


class Product {
	
}

class Truck<T> {
	private List<T> products = new ArrayList<T>();
	
	public void add (T t) {
		products.add(t);
	}
	
	public List<T> getProducts() {
		return products;
	}
}