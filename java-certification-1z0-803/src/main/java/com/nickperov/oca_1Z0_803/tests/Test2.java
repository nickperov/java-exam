package com.nickperov.oca_1Z0_803.tests;

public class Test2 {
	
	public static void main(String[] args) {
		
	}
	
}

class T1 {
	public int i;
}

class T2 extends T1 {
	private int i;
}

class ChangeTest {

	private int myValue = 0;
    
    public void showOne(int myValue){
        myValue = myValue;
        System.out.println(this.myValue);
    }
    
    public void showTwo(int myValue){
        this.myValue = myValue;
        System.out.println(this.myValue);
    }    
    public static void main(String[] args) {
        ChangeTest ct = new ChangeTest();
        ct.showOne(100);
        ct.showTwo(200);
    }
}


class TC extends java.util.ArrayList{
   public TC(){
      super(100);
      System.out.println("TC created");
   }
}
/*class TestClass extends TC{
   public TestClass(){
      System.out.println("TestClass created");
   }
   public static void main(String[] args){ new TestClass(); }
}
*/
interface AI {
}

interface BI {}

interface II extends AI, BI {	
}