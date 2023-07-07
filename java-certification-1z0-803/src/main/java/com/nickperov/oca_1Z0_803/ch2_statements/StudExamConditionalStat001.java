package com.nickperov.oca_1Z0_803.ch2_statements;
import java.util.Random;


public class StudExamConditionalStat001 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		testIf001();
		
		testSwitch001();

		testSwitch002();
		
		testSwitch003();
		
		testLabeledLoop001();
		
		testLabeledLoop002();
		
		testLabeledLoop003();
		
		testIfEqual();
		
		testForLoop001();
		
		testForLoop002();
		
		testForLoop003();
		
		testForLoop004();
		
		testForLoop005();
		
		testForLoop006();
		
		testForLoop007();
	}
	
	
	private static void testIf001() {
		System.out.println("================================================testIf001================================================");
		
		
		if (true); 
		
		{
			;
		};
	}
	
	private static void testSwitch001() {
		
		System.out.println("================================================testSwitch001================================================");
		
		//Switch statement evaluates String (new in Java 7)
		String value;
		
		value = "test1";
		
		switch (value) {
		default:
			break;   /// Default could be in the beginning 
		case "test":
			System.out.println( value + "000" );
			break;
		case "test1":
			System.out.println( value + "001" );
			break;
		case "test2":
			System.out.println( value + "002" );
			break;
		
		}
	}
	
	private static void testSwitch002() {
		
		System.out.println("================================================testSwitch002================================================");
		
		//Switch statement evaluates random
		
		String randomFish;
		Random randomObject = new Random();
		int randomNumber = randomObject.nextInt(4);
		
		switch ( randomNumber ) {
			case 0:
				randomFish = "Blue fish";
				break;
			case 1:
				randomFish = "Red Drum";
				break;
			case 2:
				randomFish = "Striped bass";
				break;
			default:
				randomFish = "Unknoun fish";
				break;
		}
		
		System.out.println( "FISH TYPE: " + randomFish );
		
	}
	
	private static void testSwitch003() {
		
		System.out.println("================================================testSwitch003================================================");
		
		switch(5){
		default: System.out.print(0);
		case 1: System.out.print(1); break;
		case 4: System.out.print(4);
		case 2: System.out.print(2);
		}
	}
	
	
	
	private static void testLabeledLoop001() {
		
		System.out.println("================================================testLabeledLoop001================================================");
		
		// Break point
		myBreakLabel:
		while (true) {
			System.out.println( "While loop 1" );
			
			
			while (true) {
				System.out.println( "While loop 2" );				
				while (true) {
					System.out.println( "While loop 3" );
					break myBreakLabel;
				}
			}
		}
	}
	
	private static void testLabeledLoop002() {
		
		System.out.println("================================================testLabeledLoop002================================================");
		
		
		while (true) {			
			System.out.println( "While loop 1" );
			// Continue point
			myContinueLabel:
			while (true) {
				System.out.println( "While loop 2" );
				while (true) {
					System.out.println( "While loop 3" );
					if (new Random().nextBoolean())
						continue myContinueLabel;
					else
						break;
					
					// Nothing after continue
					// System.out.println("Print smthing");
				}
				break;
			}	
			break;
			// Nothing after break
			// System.out.println("Print smthing");
			
		}
	}
	
	private static void testLabeledLoop003() {
		
		System.out.println("================================================testLabeledLoop003================================================");
		
		char[] arrExample = {'a','x','a','a'};
		for(int idx = 0; idx<arrExample.length; idx++){
		    if(arrExample[idx] == 'x')
		        continue;

		    System.out.println(arrExample[idx]);
		}
	}

	private static void testForLoop001() {
		
		System.out.println("================================================testForLoop001================================================");
		
		for (;;) {
		    System.out.println("Iteration");
		    break;
		}
	}
	
	private static void testForLoop002() {
		
		System.out.println("================================================testForLoop002================================================");
		
		for (;true;) {
		    System.out.println("Iteration");
		    break;
		}
	}
	
	private static void testForLoop003() {
		
		System.out.println("================================================testForLoop003================================================");
		
		@SuppressWarnings("unused")
		boolean a;
		for (;a = true;) {
		    System.out.println("Iteration");
		    break;
		}
	}
	
	private static void testForLoop004() {
		System.out.println("================================================testForLoop004================================================");
		
		@SuppressWarnings("unused")
		boolean a;
		for (;a = false;) {
		    System.out.println("Iteration");
		    break;
		}
	}
	
	private static void testForLoop005() {
		
		System.out.println("================================================testForLoop005================================================");
		
		int i = 0;
		for (i++;i <5;i--) {
		    System.out.println("Iteration " + i);
		    if (i < -10)
		    	break;
		}
	}
	
	private static void testForLoop006() {
		
		System.out.println("================================================testForLoop006================================================");
		
		boolean array[] = {true, true, false};
		int i = 0;
		for (;array[i];++i) {
		    System.out.println("Iteration " + i + " array value: " + array[i]);
		}
	}
	
	private static void testForLoop007() {
		
		System.out.println("================================================testForLoop007================================================");
		
		
		System.out.println("For ++i");
		for (int i = 0;i < 5;++i) System.out.print(i + " ");
		
		System.out.println("\nFor i++");
		for (int i = 0;i < 5;i++) System.out.print(i + " ");
	}
	
	private static void testIfEqual() {
		
		System.out.println("================================================testIfEqual================================================");
		
		Character test = 'I';
		if ( test.equals( null ) ) {
			System.out.println( "Success1" );
		} else {
			System.out.println( "Success2" );
		}
	}
	
	@SuppressWarnings("unused")
	private static void testCodeBlock() {
		
		{{}}; // Valid block
		
		label1: {} // Valid block
		
		label2: { break label2; }  // Valid block
		
		//label3: { continue label3; }  // Invalid (continue can not be used outside the loop) 
		
	}
}
