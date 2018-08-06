package com.nickperov.study.ocp_1Z0_809.ch6_ExceptionsAndAssertions;

public class AssertionExmpls {
	public static void main(String[] args) {
		int numOfGuests = -5;
		assert numOfGuests > 0;
		System.out.println(numOfGuests);
	}
}
