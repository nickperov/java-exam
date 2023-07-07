package com.nickperov.study.ocp_1Z0_809.ch6_ExceptionsAndAssertions;

public class Auto implements AutoCloseable {
	
	int num;
	
	Auto(int num) {
		this.num = num;
	}

	@Override
	public void close() {
		System.out.println("Close: " + num);
	}
	
	public static void main(String[] args) {
		try (Auto a1 = new Auto(1); Auto a2 = new Auto(2)) {
			throw new RuntimeException();
		} catch(Exception e) {
			System.out.println("ex");
		} finally {
			System.out.println("finally");
		}
	}
}
