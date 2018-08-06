package com.nickperov.study.ocp_1Z0_809.tests;

public class AdvancedClassDesign {
	
	public static void main(String[] args) {
		question01();
		
		question02();
	
		question05();
		
		question08();
		
		question13();
		
		question15();
	}
	
	interface Boiler {
	    public void boil();
	    public static void shutdown() {
	        System.out.println("shutting down");
	    }
	}
	
	interface Vaporizer extends Boiler {  //1
	    public default void vaporize(){
	        boil();
	        System.out.println("Vaporized!");
	    }
	}
	
	static class Reactor implements Vaporizer {
	    public void boil() {
	        System.out.println("Boiling...");
	    }
	}
	
	private static void question01() {
		Vaporizer v =  new Reactor();
        v.vaporize();
        // v.shutdown(); // static method access
        Boiler.shutdown();
	}
	
	interface Account{
		public default String getId() {
			return "0000";
		}
	}
	
	interface PremiumAccount extends Account{
		public String getId(); // redeclarated method
	}

	
	
	private static void question02() {
		class BankAccount implements Account { }
		
		class PremiumBankAccount implements PremiumAccount {

			@Override
			public String getId() {
				// TODO Auto-generated method stub
				return null;
			}
			
		}
	}
	
	private static void question05() {
		class TestOuter
		{
		   public void myOuterMethod()
		   {
		      this.new TestInner();
		      new TestInner();
		   }
		   class TestInner { }
		   
		   void test() {
		      TestOuter to = new TestOuter();
		      to.new TestInner();
		      new TestOuter().new TestInner();
		      // 2
		   }
		}
	}
	
	enum Card {
		HEART, CLUB, SPADE, DIAMOND; 
	}
	
	private static void question08() {
		for(Card c : Card.values()) System.out.print(c + " ");
	}
	
	enum Title
	{
	    MR("Mr. "), MRS("Mrs. "), MS("Ms. ");
	    private String title;
	    private Title(String s){
	    title = s;
	    }
	    public String format(String first, String last){
	    return title+" "+first+" "+last;
	    }
	}
	
	 enum Title2
	 {
		 DR;
		 private Title t = Title.MR; 
	 }

	 enum Title3
	 {
		 DR;
		 private Title t; 
	 }
	
	private static void question13() {
		
		 class TestClass {
			 void someMethod() {
				 System.out.println(Title.MR.format("Rob", "Miller"));
			 }
		 }
	}
	
	public enum Switch{ ON, OFF }
	
	private static void question15() {
		Switch s = Switch.OFF;
		
		if( s == Switch.OFF) { System.out.println("It is off!"); }
		
		if( s.equals(Switch.OFF)) { System.out.println("It is off!"); }
		
		switch(s) {
			case OFF: System.out.println("It is off!");
			break;
		}
		
		// invalid
		/*switch(s) {
			case Switch.OFF: System.out.println("It is off!");
			break;
		}
		*/
	}

	
}