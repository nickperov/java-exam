package com.nickperov.study.ocp_1Z0_809.ch3_GenericsAndCollections.generics;

public class SizeLimitedCrate<T, U extends Comparable<U>> {
	
	private T contents;
	private U sizeLimit;
	
	public SizeLimitedCrate(T contents, U sizeLimit) {
		this.contents = contents;
		this.sizeLimit = sizeLimit;
	}
	
	public boolean packCrate(T contents, U contentsSize) {
		if (this.sizeLimit.compareTo(contentsSize) >= 0) { 
			this.contents = contents;
			return true;
		} else
			return false;
	}
	
	public T emptyCrate() {
		T cont = this.contents;
		this.contents = null;
		return cont;
	}
	
	public U getCrateSize() {
		return this.sizeLimit;
	}
}