package com.nickperov.study.ocp_1Z0_809.ch3_GenericsAndCollections.generics;

public class Crate<T> {
	private T contents;
	
	public T emtyCrate() {
		return contents;
	}
	
	public void packCrate(T contents) {
		this.contents = contents;
	}
}