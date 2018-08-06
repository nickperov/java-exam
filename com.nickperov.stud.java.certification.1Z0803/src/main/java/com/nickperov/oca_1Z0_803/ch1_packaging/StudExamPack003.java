package com.nickperov.oca_1Z0_803.ch1_packaging;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

import objectexplorer.MemoryMeasurer;

import java.util.Map;
import java.util.HashMap;


import java.util.Date;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.Locale;
import java.util.Currency;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.Timer;

import java.io.InputStream;
import java.io.OutputStream;



/**
 * Task: JAVA UTILITIES CLASSES
 * Basic collections, memory tests - List, Map, Set, Queue.
 * Basic utility classes - Date, Calendar, TimeZone, Locale, Currency, Random, StringTokinizer, Timer.
 * Basic Input/Output API.
 */
public class StudExamPack003 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		arrayTest();
		
		/** List interface:
		 * ArrayList, LinkedList, Vector... Stack, AttributeList, CopyOnWriteArrayList, RoleList, RoleUnresolvedList
		 */
		listCollectionsTest();
		
		/** Map interface
		 *  HashMap, Hashtable, TreeMap, ConcurrentHashMap...
		 *  Attributes, AuthProvider, ConcurrentSkipListMap, EnumMap, IdentityHashMap, LinkedHashMap, PrinterStateReasons, Properties, Provider, RenderingHints, SimpleBindings, TabularDataSupport, UIDefaults, WeakHashMap
		 */
		// TODO
		mapCollectionsTest();
		
		// TODO Set
		
		// TODO Queue		
		
		testUtilityClasses();
		
		// TODO Test JAVA Input/Output API
		testInputOutputAPI();
		
		// TODO networking API
		
		// TODO AWT API
		
		// TODO Swing API
		
	}
	
	private static void arrayTest() {
		
		System.out.println( "=======================Array===========================" );
		
		/** Array of Integer (for memory test) */
		// Array (Integer) = 16 bytes header + 4 byte 1 entry (pointer to Integer or String or ...)
		// Total memory of array of 10 empty elements = 16 + 10 * 4(1 pointer to Integer) = 56 bytes
		System.out.println( "Array 01 (Integer) - 10 elements " );
		Integer[] intArray01 = new Integer[10];
		
		long memoryA01 = MemoryMeasurer.measureBytes( intArray01 );
		System.out.println( "Array 01 memory in bytes: " + memoryA01 );
		
		System.out.println( "Array 02 (Integer) - 100 elements" );
		Integer[] intArray02 = new Integer[100];
		
		long memoryA02 = MemoryMeasurer.measureBytes( intArray02 );
		System.out.println( "Array 02 memory in bytes: " + memoryA02 );
		
		System.out.println( "Array 03 (String) - 100 elements" );
		String[] stArray03 = new String[100];
		
		long memoryA03 = MemoryMeasurer.measureBytes( stArray03 );
		System.out.println( "Array 03 memory in bytes: " + memoryA03 );
	}
	
	private static void listCollectionsTest() {
		System.out.println( "=======================ArrayList========================" );
		
		/** Interface List */
		/** ArrayList */
		// Contains: Array - elementData � size
		//
		// Use array to store data
		//
		// Not synchronized
		//
		// Adding element to end, iteration - O (1)
		// Adding/removing element from beginning (from the middle) - O (N)
		// Accessing element by index - O (1)
		
		
		System.out.println( "ArrayList 01 (Object)" );
		// Array of Object
		@SuppressWarnings({ "unused", "rawtypes" })
		List arrListTest01 = new ArrayList<>();
		
		
		System.out.println( "ArrayList 02 (String)" );
		
		// Array of String
		@SuppressWarnings("rawtypes")
		List arrListTest02 = new ArrayList<String>();
		
		long memoryAL02 = MemoryMeasurer.measureBytes( arrListTest02 );
		System.out.println( "ArrayList 02 memory in bytes: " + memoryAL02 );
		
		System.out.println( "ArrayList 03 (Integer)" );
		
		// Array of integer
		// Default capacity = 10
		// NewCapacity = (oldCapacity * 3) / 2 + 1
		// Capacity gross: 10 -> 16 -> 25
		//
		// Total memory of empty arrayList = 40 (header) + 10 * 4(1 pointer) = 80 bytes
		//
		List<Integer> arrListTest03 = new ArrayList<Integer>();
		
		long memoryAL03 = MemoryMeasurer.measureBytes( arrListTest03 );
		System.out.println( "ArrayList 03 memory in bytes: " + memoryAL03 );
		
		
		System.out.println( "ArrayList 04 (Integer) - 100 elements" );
		
		// Initial capacity = 100
		// Capacity gross: 100 -> 151 -> 277 (278)
		List<Integer> arrListTest04 = new ArrayList<Integer>( 100 );
		
		long memoryAL04 = MemoryMeasurer.measureBytes( arrListTest04 );
		System.out.println( "ArrayList 04 memory in bytes: " + memoryAL04 );
		
		System.out.println( "ArrayList 05 (Integer) - 500 elements" );
		
		// Initial capacity = 500
		List<Integer> arrListTest05 = new ArrayList<Integer>( 500 );
		
		long memoryAL05 = MemoryMeasurer.measureBytes( arrListTest05 );
		System.out.println( "ArrayList 05 memory in bytes: " + memoryAL05 );
		
		
		System.out.println( "ArrayList 06 (Integer) - 1 element inicialized " );
		
		// Initial capacity = 1
		// Total memory = 40 (header) + 16 (1 Integer) = 56 bytes
		List<Integer> arrListTest06 = new ArrayList<Integer>( 1 );
		
		arrListTest06.add( new Integer(1) );
		
		long memoryAL06 = MemoryMeasurer.measureBytes( arrListTest06 );
		System.out.println( "ArrayList 06 memory in bytes: " + memoryAL06 );
		
		
		System.out.println( "=======================LinkedList=======================" );
		
		/** LinkedList */
		// Contains: header (empty element, pointer to first, pointer to last), 
		// 1 entry = element + pointer to previous + pointer to next
		// 
		// Not synchronized
		// 
		// Adding element to end, iteration - O (1)
		// Adding/removing element from beginning (from current entry) - O (1)
		// Accessing element by index - O (N)
		
		
		System.out.println( "LinkedList 01 (Objects)" );
		List<Object> lnkListTest01 = new LinkedList<Object>();
		
		long memoryLL01 = MemoryMeasurer.measureBytes( lnkListTest01 );
		System.out.println( "LinkedList 01 memory in bytes: " + memoryLL01 );
		
		System.out.println( "LinkedList 02 (Integer), 3 elements inizialized" );
		
		// Total memory = 24 (header) + 3 * 40 (1 Entry) = 144 bytes
		List<Integer> lnkListTest02 = new LinkedList<Integer>();
		
		lnkListTest02.add( new Integer( 1 ) );
		lnkListTest02.add( new Integer( 2 ) );
		lnkListTest02.add( new Integer( 3 ) );
		
		long memoryLL02= MemoryMeasurer.measureBytes( lnkListTest02 );
		System.out.println( "LinkedList 03 memory in bytes: " + memoryLL02 );
		
		
		System.out.println( "=======================Vector===========================" );
		
		/** Vector */
		// Contains: Array - elementData � size
		//
		// Use array to store data
		//
		// Synchronized
		//
		// Initial capacity = 10
		// Like ArrayList, but synchronized!!! 
		// Adding element to end, iteration - O (1)
		// Adding/removing element from beginning (from the middle) - O (N)
		// Accessing element by index - O (1)
		System.out.println( "Vector 01 (Object)" );
		@SuppressWarnings("rawtypes")
		List vectorTest01 = new Vector();
		
		long memoryV01= MemoryMeasurer.measureBytes( vectorTest01 );
		System.out.println( "Vector 01 memory in bytes: " + memoryV01 );
	}
	
	private static void mapCollectionsTest() {
		System.out.println( "=======================HashMap=========================" );
		
		//
		// Initial capacity = 16 elements
		// 
		Map<String, String> hashMapTest01 = new HashMap<String, String>();
		
		long memoryHM01= MemoryMeasurer.measureBytes( hashMapTest01 );
		System.out.println( "HashMap 01 memory in bytes: " + memoryHM01 );
		
	}
	
	private static void testUtilityClasses() {
		
		System.out.println( "=======================Date class=========================" );
		
		Date testDate = new Date();
		
		System.out.println ( "Date: " + testDate );
		
		System.out.println( "=======================Calendar class=========================" );
		
		Calendar testCalendar = Calendar.getInstance();
		
		System.out.println ( "Calendar date: " + testCalendar.getTime() );
		
		
		System.out.println( "=======================TimeZone class=========================" );
		
		TimeZone testTZ = testCalendar.getTimeZone();
		
		System.out.println ( "Time zone: " + testTZ.getDisplayName() );
		
		System.out.println( "=======================Locale class=========================" );
		
		Locale testLocale = new Locale( "en" );
		
		System.out.println ( "Locale: " + testLocale.getDisplayName() );
		
		System.out.println( "=======================Currency class=========================" );
		
		Currency testCurrency = Currency.getInstance( "USD" );
		
		System.out.println ( "Currency: " + testCurrency.getDisplayName() );
		
		System.out.println( "=======================Random class=========================" );
		
		Random testRandom = new Random();
		
		System.out.println ( "Random int value: " + testRandom.nextInt() );
		System.out.println ( "Random long value: " + testRandom.nextLong() );
		System.out.println ( "Random double value: " + testRandom.nextDouble() );
		System.out.println ( "Random boolean value: " + testRandom.nextBoolean() );
		
		System.out.println( "=======================StringTokenizer class===============" );
		
		String testString = "test string 1 2 3 4 5";
		StringTokenizer testStrTokenizer = new StringTokenizer( testString );
		
		System.out.println ( "StringTokenizer string: " + testString );
		System.out.println ( "StringTokenizer number of tokens: " + testStrTokenizer.countTokens() );
		
		System.out.println( "=======================Timer class=========================" );
		
		Timer testTimer = new Timer();
		
		System.out.println ( "Timer time: " + System.currentTimeMillis() );
		
		testTimer.cancel();
	}
	
	private static void testInputOutputAPI() {
		
		// TODO Test for Input/Output Streams
		
		InputStream testInputStream;
		
		OutputStream testOutputStream;

	}
}
