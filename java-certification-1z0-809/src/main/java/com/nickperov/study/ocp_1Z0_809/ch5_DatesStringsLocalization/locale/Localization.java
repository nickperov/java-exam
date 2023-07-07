package com.nickperov.study.ocp_1Z0_809.ch5_DatesStringsLocalization.locale;

import java.util.Locale;

public class Localization {
	
	public static void main(String[] args) {
		
		System.out.println("================ Getting default locale =====================");
		
		Locale locale = Locale.getDefault();
		System.out.println(locale);
		
		System.out.println("================ Get or build locale =====================");
		
		System.out.println(Locale.GERMAN);
		System.out.println(Locale.GERMANY);
		
		System.out.println(new Locale("fr"));
		System.out.println(new Locale("hi", "IN"));
		
		Locale l1 = new Locale.Builder().setLanguage("en").setRegion("US").build();
		Locale l2 = new Locale.Builder().setRegion("US").setLanguage("en").build();

		System.out.println(l1 + " - " + l2);
		
		System.out.println("================ Changing default locale =====================");
		
		System.out.println(Locale.getDefault());
		Locale nLocale = new Locale("fr");
		Locale.setDefault(nLocale);
		System.out.println("New default locale: " + Locale.getDefault());

	}

}
