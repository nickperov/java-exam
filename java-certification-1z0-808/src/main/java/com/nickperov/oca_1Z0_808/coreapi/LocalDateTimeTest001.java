package com.nickperov.oca_1Z0_808.coreapi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import javax.print.attribute.standard.DateTimeAtCompleted;

public class LocalDateTimeTest001 {
	
	public static void main(String[] args) {
		
		LocalTime time1 = LocalTime.of( 6, 15); // hour and minute 
		LocalTime time2 = LocalTime.of( 6, 15, 30); // + seconds 
		LocalTime time3 = LocalTime.of( 6, 15, 30, 200);
		
		System.out.println("Time1: " + time1);
		System.out.println("Time2: " + time2);
		System.out.println("Time3: " + time3);
		
		LocalDate date1 = LocalDate.of(1987, 5, 8);
		LocalDate date2 = LocalDate.of(1987, Month.MAY, 8);
		LocalDate date3 = LocalDate.now();
		LocalDate date4 = LocalDate.now(ZoneId.of("GMT"));
		
		
		System.out.println("Date1: " + date1);
		System.out.println("Date2: " + date2);
		System.out.println("Date3: " + date3);
		System.out.println("Date4: " + date4);
		
		LocalDateTime dateTime1 = LocalDateTime.of( 2015, Month.JANUARY, 20, 6, 15, 30);
		LocalDateTime dateTime2 = LocalDateTime.of( date1, time1);
		
		System.out.println("DateTime1: " + dateTime1);
		System.out.println("DateTime2: " + dateTime2);
		
		Period period = Period.ofDays(3);
		System.out.println("Date1 + period(3 days): " + date1.plus(period));

		LocalDate lastOfFeb = LocalDate.of(2016, 2, 29);
		
		System.out.println("Last day of Feb: " + lastOfFeb);
		
		Period annual = Period.ofYears(1);
		int i = 0;
		while (i++ < 4) {
			lastOfFeb = lastOfFeb.plus(annual);
			System.out.println("Last day of Feb + " + i + "Y: " + lastOfFeb);
			if (lastOfFeb.getDayOfMonth() != lastOfFeb.getMonth().length(lastOfFeb.isLeapYear()))
				System.out.println("Wrong!!!! Last day is: " + lastOfFeb.getMonth().length(lastOfFeb.isLeapYear()));
		}
		
		System.out.println("Formatted date: " + DateTimeFormatter.ISO_DATE_TIME.format(dateTime2));
		
		DateTimeFormatter shortDF = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
		System.out.println("Short formatted date: " + shortDF.format(dateTime2));
		
		DateTimeFormatter shortTF = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
		System.out.println("Short formatted time: " + shortTF.format(time3));
		
		
		DateTimeFormatter f = DateTimeFormatter.ofPattern(" MM dd yyyy"); 
		LocalDate date = LocalDate.parse(" 01 02 2015", f); 
		LocalTime time = LocalTime.parse("11:22"); 
		System.out.println(date); // 2015-01-02 
		System.out.println(time); // 11: 22
		
	}
}
