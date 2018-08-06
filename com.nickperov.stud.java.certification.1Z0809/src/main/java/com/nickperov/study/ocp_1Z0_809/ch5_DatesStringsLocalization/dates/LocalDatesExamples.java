package com.nickperov.study.ocp_1Z0_809.ch5_DatesStringsLocalization.dates;

import java.time.DateTimeException;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.UnsupportedTemporalTypeException;
import java.util.Date;

public class LocalDatesExamples {

	
	public static void main(String[] args) {
		localizedDateExmpl();
		
		localTimeExmpl();
		
		findingZone();
		
		creatingDateTime();
		
		manipulatingDateTime();
		
		workingWithPeriods();
		
		workingWithDurations();
		
		workingWithInstants();
		
		daylightSavingTimeExmpl();
		
		instantTimeTest();
		
		comparingDurationAndPeriod();
	}
	
	private static void localizedDateExmpl() {
		LocalTime lTime = LocalTime.of(13, 20);
		LocalDate lDate = LocalDate.of(2016, Month.JANUARY, 18);
		
		LocalDateTime lDateTime = LocalDateTime.of(2016, Month.JANUARY, 18, 13, 20);
		
		ZoneId zone = ZoneId.of("US/Eastern");
		ZonedDateTime zDateTime = ZonedDateTime.of(lDateTime, zone);
		
		zDateTime = ZonedDateTime.of(lDate, lTime, zone);
		
		System.out.println(zDateTime);
		
		ZonedDateTime zDefDateTime = ZonedDateTime.of(lDateTime, ZoneId.systemDefault());
		
		System.out.println(zDefDateTime);
	}
	
	private static void localTimeExmpl() {
		LocalTime time1 = LocalTime.of(6, 15); // hour and minute 
		LocalTime time2 = LocalTime.of(6, 15, 30); // + seconds 
		LocalTime time3 = LocalTime.of(6, 15, 30, 200); // + nanoseconds
		
		System.out.println(time1);
		System.out.println(time2);
		System.out.println(time3);
	}
	
	private static void findingZone() {
		System.out.println("===========ZONES - America - US===========");
		
		ZoneId.getAvailableZoneIds().stream().filter(z -> z.contains("US") || z.contains("America")).sorted().forEach(System.out::println);
		
		System.out.println("===========ZONES - NZ===========");
		
		System.out.println(ZoneId.of("Pacific/Auckland"));
	}
	
	private static void creatingDateTime() {
		System.out.println(LocalDate.now());
		System.out.println(LocalTime.now());
		System.out.println(LocalDateTime.now());
		System.out.println(ZonedDateTime.now());
	}
	
	private static void manipulatingDateTime() {
		System.out.println("============== LocalDate manipulations");
		LocalDate date = LocalDate.of(2014, Month.JANUARY, 20);
		System.out.println(date);
		date = date.plusDays(2);
		System.out.println(date);
		date = date.plusWeeks(1);
		System.out.println(date);
		date = date.plusMonths(1);
		System.out.println(date);
		date = date.plusYears(5);
		System.out.println(date);
		
		System.out.println("============== LocalDateTime manipulations ====================");
		date = LocalDate.of(2020, Month.JANUARY, 20);
		LocalTime time = LocalTime.of(5, 15);
		LocalDateTime dateTime = LocalDateTime.of(date, time);
		System.out.println(dateTime);
		dateTime = dateTime.minusDays(1);
		System.out.println(dateTime);
		dateTime = dateTime.minusHours(10);
		System.out.println(dateTime);
		dateTime = dateTime.minusSeconds(30);
		System.out.println(dateTime);
	}
	
	private static void workingWithPeriods() {
		
		System.out.println("============== Working with periods ======================");
		
		LocalDate start = LocalDate.of(2015, Month.JANUARY, 1);
		LocalDate end = LocalDate.of(2015, Month.MARCH, 30);
		
		Period period = Period.ofMonths(1);
		
		LocalDate upTo = start;
		while(upTo.isBefore(end)) {
			System.out.println("give new toy: " + upTo);
			upTo = upTo.plus(period);
		}
		
		System.out.println("==================== Period examples ===================");
		
		Period annually = Period.ofYears(1); // every 1 year
		Period quarterly = Period.ofMonths(3); // every 3 months
		Period everyThreeWeeks = Period.ofWeeks(3); // every 3 weeks
		Period everyOtherDay = Period.ofDays(2); // every 2 days
		Period everyYearAndAWeek = Period.of(1, 0, 7); // every year and 7 days
		
		System.out.println(annually + " " + quarterly + " " + everyThreeWeeks + " " + everyOtherDay + " " + everyYearAndAWeek);
		
		LocalDate date = LocalDate.of(2015, 1, 20);
		LocalTime time = LocalTime.of(6, 15);
		LocalDateTime dateTime = LocalDateTime.of(date, time);
		
		Period mPeriod = Period.ofMonths(1);
		
		System.out.println(date.plus( mPeriod)); // 2015–02–20
		System.out.println(dateTime.plus(period)); // 2015–02–20T06:15
		try {
			System.out.println(time.plus(period)); // UnsupportedTemporalTypeException
		} catch (UnsupportedTemporalTypeException e) {
			System.out.println(e);
		}
	}
	
	private static void workingWithDurations() {
		System.out.println("============== Working with durations ======================");
		
		LocalDate date = LocalDate.of(2015, 1, 20);
		LocalTime time = LocalTime.of(6, 15);
		LocalDateTime dateTime = LocalDateTime.of(date, time);
		
		Duration duration = Duration.ofHours(23);
		System.out.println(dateTime.plus(duration)); // 2015–01–21T05:15
		System.out.println(time.plus(duration)); // 05:15
		try {
			System.out.println(date.plus(duration)); // UnsupportedTemporalException
		} catch (UnsupportedTemporalTypeException e) {
			System.out.println(e);
		}
		
		System.out.println("==================== Duration examples ===================");
		
		Duration daily = Duration.ofDays(1);
		Duration hourly = Duration.ofHours(1);
		Duration everyMinute = Duration.ofMinutes(1);
		Duration everyTenSeconds = Duration.ofSeconds(10);
		Duration everyMilli = Duration.ofMillis(1);
		Duration everyNano = Duration.ofNanos(1);
		
		System.out.println(daily + " " + hourly + " " + everyMinute+ " " + everyTenSeconds + " " + everyMilli + " " + everyNano);
		
		System.out.println("============== using chronounits ======================");
		
		Duration everyHour = Duration.of(3600, ChronoUnit.SECONDS);
		
		System.out.println(everyHour);
		
		Duration everyDay = Duration.of(2, ChronoUnit.HALF_DAYS);
		
		System.out.println(everyDay);
		
		LocalTime one = LocalTime.of(5, 15);
		LocalTime two = LocalTime.of(6, 30);
		
		LocalDate lDate = LocalDate.of(2016, 1, 20);

		System.out.println(ChronoUnit.MINUTES.between(one, two));
		System.out.println(ChronoUnit.HOURS.between(one, two));
		
		try {
			System.out.println(ChronoUnit.DAYS.between(one, two));
		} catch (UnsupportedTemporalTypeException e) {
			System.out.println(e);
		}
		try {
			System.out.println(ChronoUnit.MINUTES.between(one, lDate));
		} catch (DateTimeException e) {
			System.out.println(e);
		}
	}
	
	private static void workingWithInstants() {
		System.out.println("============== Working with intants ======================");
		
		LocalDate date = LocalDate.of(2015, 5, 25);
		LocalTime time = LocalTime.of(11, 55);
		
		ZoneId zone = ZoneId.of("US/Eastern");
		ZonedDateTime zoneDateTime = ZonedDateTime.of(date,  time, zone);
		
		Instant instant = zoneDateTime.toInstant();
		
		System.out.println(zoneDateTime);
		System.out.println(instant);
		
		Date currDate = new Date();
		Instant currInstant = Instant.ofEpochMilli(currDate.getTime());
		System.out.println(currDate);
		System.out.println(currInstant);
		
		System.out.println("============== Intants math ======================");
		
		Instant nextDay = instant.plus(1, ChronoUnit.DAYS);
		System.out.println(nextDay); // 2015–05–26T15:55:00Z
		Instant nextHour = instant.plus(1, ChronoUnit.HOURS);
		System.out.println(nextHour); // 2015–05–25T16:55:00Z
		try {
			Instant nextWeek = instant.plus(1, ChronoUnit.WEEKS); // exception
			System.out.println(nextWeek);
		} catch (UnsupportedTemporalTypeException e) {
			System.out.println(e);
		}
	}
	
	private static void daylightSavingTimeExmpl() {
		System.out.println("============== DST ======================");
		
		LocalDate date = LocalDate.of(2016, Month.MARCH, 13);
		LocalTime time = LocalTime.of(1, 30);
		ZoneId zone = ZoneId.of("US/Eastern");
		ZonedDateTime dateTime = ZonedDateTime.of(date, time, zone);
		
		System.out.println(dateTime); // 2016–03–13T01:30–05:00[US/Eastern]
		dateTime = dateTime.plusHours(1);
		System.out.println(dateTime); // 2016–03–13T03:30–04:00[US/Eastern]
	}
	
	private static void instantTimeTest() {
		
		System.out.println("============== INSTANT ======================");
		
		LocalDateTime dateTime = LocalDateTime.now();
		ZoneId zoneId = ZoneId.systemDefault();
		ZonedDateTime zonedDateTime = ZonedDateTime.of(dateTime, zoneId);
		
		Instant instant1 = Instant.now();
		Instant instant2 = Instant.ofEpochSecond(0);
		Instant instant3 = zonedDateTime.toInstant();
		
		System.out.println(instant1);
		System.out.println(instant2);
		System.out.println(instant3);
	}
	
	private static void comparingDurationAndPeriod() {
		
		System.out.println("============== PERIODS AND DURATIONS ======================");
		
		String m1 = Duration.of(1, ChronoUnit.MINUTES).toString();
		String m2 = Duration.ofMinutes(1).toString();
		String s = Duration.of(60, ChronoUnit.SECONDS).toString();
		String d = Duration.ofDays(1).toString();
		String p = Period.ofDays(1).toString();
		System.out.println(m1 + "; " + m2 + "; " + s + "; " + d + "; " + p);
		System.out.println(m1 == m2);
		System.out.println(m1.equals(m2));
		System.out.println(m1.equals(s));
		System.out.println(d == p);
		System.out.println(d.equals(p));
	}
}