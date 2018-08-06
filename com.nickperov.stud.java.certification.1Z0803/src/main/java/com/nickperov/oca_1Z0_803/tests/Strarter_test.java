package com.nickperov.oca_1Z0_803.tests;

public class Strarter_test {
	public static void main(String[] args){

		// Calculator.m(args);
		
		// TestClass.m(args);
		
		//testArrayCopy();
		
		//TestClass2 t = new TestClass3();
		
		testIncrement();
	}
	
	private static void testArrayCopy() {
		int[] scores = { 1, 2, 3, 4, 5, 6};
		System.arraycopy(scores, 2, scores, 3, 2);
		for(int i :  scores) System.out.print(i);
	}
	
	private static void method1(int i){
		int j = (i*30 - 2)/100;
		
		POINT1 : for(;j<10; j++){
			boolean flag  = false;
			while(!flag){
				if(Math.random()>0.5) break POINT1;
			}
		}
		while(j>0){
			System.out.println(j--);
			//     if(j == 4) break POINT1;  <-- label in the worn cycle
		}
	}
	
	private static void testIncrement() {
		int i = 1;
		  int j = i++;
		  if( (i==++j) | (i++ == j) ){
		    i+=j;
		  }
		  System.out.println(i);
	}
	
}

abstract class Calculator{
	   abstract void calculate();
	   public static void m(String[] args){
	      System.out.println("calculating");
	      Calculator x = null;
	      x.calculate();
	   }
}

class TestClass1{
	  public void testRefs(String str, StringBuilder sb){
	    str = str + sb.toString();
	    sb.append(str);
	    str = null;
	    sb = null;
	  }
	  public static void m(String[] args){
	    String s = "aaa";
	    StringBuilder sb = new StringBuilder("bbb");
	    new TestClass1().testRefs(s, sb);
	    System.out.println("s="+s+" sb="+sb);
	  }
}


abstract class TestClass2{
	public void m1() {};
	public abstract void m2();
}

class TestClass3 extends TestClass2{
	public void m1() {};
	public void m2() {};
}

class TestClass4{
	public static void main(String[] args){
		int[] arr = { 1, 2, 3, 4, 5, 6 };
		int counter = 0;
		for (int value : arr) {
			if (counter >= 5) {
				break;
			} else {
				continue;
			}
			/*if (value > 4) {    /// Not accessible code
				arr[counter] = value + 1;
			}
			counter++;*/
			}
		System.out.println(arr[counter]);
		} 
	}

class A{
    public static void sM1() {  System.out.println("In base static"); }
}
class B extends A{
	 public static void sM1() {  System.out.println("In sub static"); }
	 //public  void sM1() {  System.out.println("In sub non-static"); }
}