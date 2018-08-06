package com.nickperov.oca_1Z0_803.ch4.enumerations;

public class StudExamEnum001 {
	
	private enum Suit {CLUBS, DIAMONDS, HEARTS, SPADES};
	
	public static void main(String[] args) {
		testEnum001();
	}

	private static void testEnum001(){
		System.out.println("====================Enum test============================");
		Suit s1 = Suit.CLUBS;
		System.out.println(s1);
		
		Suit s2 =Suit.valueOf("HEARTS");
		System.out.println(s2);
		
		for (Suit s : Suit.values())
			System.out.println(s);
		
		
		
	}
}
