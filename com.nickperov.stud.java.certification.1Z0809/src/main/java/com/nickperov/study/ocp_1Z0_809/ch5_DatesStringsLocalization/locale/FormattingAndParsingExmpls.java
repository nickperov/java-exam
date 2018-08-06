package com.nickperov.study.ocp_1Z0_809.ch5_DatesStringsLocalization.locale;

import java.text.NumberFormat;
import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class FormattingAndParsingExmpls {
	
	public static void main(String[] args) throws ParseException {
		formattingNumbers();
		
		formattingPrice();
		
		parsingNumbers();
		
		formattingTime();
		
		formattingDateTime();
	}
	
	private static void formattingNumbers() {
		
		int attendeesPerYear = 3_200_000;
		int attendeesPerMonth = attendeesPerYear / 12;
		
		NumberFormat defaultNF = NumberFormat.getInstance();
		
		System.out.println(defaultNF.format(attendeesPerMonth));
		
		NumberFormat usNF = NumberFormat.getInstance(Locale.US);
		
		System.out.println(usNF.format(attendeesPerMonth));
		
		NumberFormat gmNF = NumberFormat.getInstance(Locale.GERMAN);
		
		System.out.println(gmNF.format(attendeesPerMonth));
		
		NumberFormat cafrNF = NumberFormat.getInstance(Locale.CANADA_FRENCH);
		
		System.out.println(cafrNF.format(attendeesPerMonth));
	}
	
	private static void formattingPrice() {
		
		double price = 48;
		
		NumberFormat defCurrFormat = NumberFormat.getCurrencyInstance();
		
		System.out.println(defCurrFormat.format(price));
		
		NumberFormat gmCurrFormat = NumberFormat.getCurrencyInstance(Locale.GERMANY);
		
		System.out.println(gmCurrFormat.format(price));
	}
	
	private static void parsingNumbers() throws ParseException {
		
		String s = "48.45";
		
		NumberFormat us = NumberFormat.getInstance(Locale.US);
		
		NumberFormat fr = NumberFormat.getInstance(Locale.FRANCE);
		
		System.out.println(us.parse(s));
		System.out.println(fr.parse(s));
		
	}
	
	private static void formattingTime() { 
		LocalDateTime d = LocalDateTime.of(2015, 5, 10, 11, 22, 33);
		Period p = Period.of(1, 2, 3);
		d = d.minus(p);
		DateTimeFormatter f = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
		System.out.println(d.format(f));
		
		

	}
	
	private static void formattingDateTime() {
		LocalDateTime d = LocalDateTime.of(2015, 5, 10, 11, 22, 33);
		Period p = Period.ofDays(1).ofYears(2); // of 2 years
		d = d.minus(p);
		DateTimeFormatter f = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
		System.out.println(f.format(d));

	}
}
