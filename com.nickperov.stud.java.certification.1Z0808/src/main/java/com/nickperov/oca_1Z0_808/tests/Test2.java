package com.nickperov.oca_1Z0_808.tests;

import java.io.*;

public class Test2 {
	

	class A{
		public double m1(int a){
			return a*10/4-30;
		}
	}
	class A2 extends A{
		public double m1(int a){
			return a*10/4.0;
		}
	}
	
	public static void main(String[] args) {
		Test.test(new String[]{"close"});
		Test.test(new String[]{"", "someone"});
	}
}

class Test {
	static void test(String[] args) {
		if (args[0].equals("open"))
			if (args[1].equals("someone"))
				System.out.println("Hello!");
			else System.out.println("Go away "+ args[1]);
	}
}



class A{
	public static void main() throws IOException{ 
		for(;;){
			if(Math.random()<.05) break;
		}
	}
	
}

