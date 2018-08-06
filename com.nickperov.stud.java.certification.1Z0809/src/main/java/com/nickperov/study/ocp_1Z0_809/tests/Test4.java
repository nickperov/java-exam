package com.nickperov.study.ocp_1Z0_809.tests;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.TreeSet;

public class Test4 {
	
	public static void main(String[] args) {
		question26();
		
		question47();
		
		question51();
	}
	
	
	private static void question26() {
		Instant start = Instant.parse("2015-06-25T16:13:30.00z");
		start.plus(10, ChronoUnit.HOURS);
		System.out.println(start);

		Duration timeToCook = Duration.ofHours(1);
		Instant readyTime = start.plus(timeToCook);
		System.out.println(readyTime);
		
		Period p = Period.ofDays(2);
		Instant pTime = start.plus(p);
		System.out.println(pTime);
		

		LocalDateTime ltd = LocalDateTime.ofInstant(readyTime, ZoneId.of("GMT+2"));
		System.out.println(ltd);
		
		ZonedDateTime zdt = ZonedDateTime.ofLocal(ltd, ZoneId.of("GMT-5"), null);
		
		System.out.println(zdt);
	}
	
	private static void question47() {
		boolean enabled = false;
	    assert enabled = true;
	    try {
	    	if( !enabled ) throw new RuntimeException("Assertions should be enabled");
	    } catch(Error err) {
	    	System.out.println(err.getMessage());
	    }
	}
	
	private static void question51() {
        TreeSet<Integer> s = new TreeSet<Integer>();
        TreeSet<Integer> subs = new TreeSet<Integer>();

        for(int i = 324; i<=328; i++)
        {
            s.add(i);
        }
        //subs = (TreeSet) s.subSet(326, true, 328, true);
        subs = (TreeSet) s.subSet(326, true, 329, true);
        try {
        	subs.add(329);
        } catch(IllegalArgumentException e) {
        	System.out.println(e.getMessage());
        }
        
        System.out.println(s+" "+subs);
	}
	
	private static void question56() {
		
	}

}
