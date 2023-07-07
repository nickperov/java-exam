package com.nickperov.oca_1Z0_803.ch1_packaging;

//import static java.util.Locale.ITALY;
import static java.util.Locale.GERMANY;
//static import java.util.Locale.GERMANY;  <--- WRONG, import should be first

/**
 * 
 * Task: Static imports.
 */
public class StudExamPack001 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println( "Locale: " + java.util.Locale.ITALY );
		System.out.println( "Locale: " + GERMANY );
	}

}
