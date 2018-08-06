package com.nickperov.study.ocp_1Z0_809.ch4_FunctionalProg.f_interfaces;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;


public class FuncInterfacesExamples {

	public static void main(String[] args) {
		supplierExample();
		
		consumerExample();
		
		predicateExample();
		
		functionExample();
		
		operatorExample();
	}
	
	private static void supplierExample() {
		
		System.out.println("Supplier examples:");
		
		Supplier<LocalDate> sd1 = LocalDate::now;
		Supplier<LocalDate> sd2 = () -> LocalDate.now();
		
		System.out.println(sd1.get());
		System.out.println(sd2.get());
		
		Supplier<StringBuilder> sStr1 = StringBuilder::new;
		Supplier<StringBuilder> sStr2 = () -> new StringBuilder();
		
		System.out.println(sStr1.get());
		System.out.println(sStr2.get());
		
		Supplier<ArrayList<String>> sArr1 = ArrayList<String>::new;
		ArrayList<String> a1 = sArr1.get();
		System.out.println(a1);
		
	}
	
	private static void consumerExample() {
		System.out.println("Consumer examples:");
		
		Consumer<String> c1 = System.out::println;
		Consumer<String> c2 = s -> System.out.println(s);
		
		c1.accept("Annie");
		c2.accept("Annie");
		
		Map<String, Integer> map = new HashMap<>();
		BiConsumer<String, Integer> b1 = map::put;
		BiConsumer<String, Integer> b2 = (k, v) -> map.put(k, v);
		
		
		b1.accept("chicken", 7);
		b2.accept("chick", 1);
		
		System.out.println(map);
		
		System.out.println("====ConsumerParam====");
		
		ConsumerParam cp1 = new ConsumerParam("Param1");
		ConsumerParam cp2 = new ConsumerParam("Param2");
		
		Consumer<ConsumerParam> ccp1 = ConsumerParam::print;
		BiConsumer<ConsumerParam,ConsumerParam> ccp2 = ConsumerParam::print;
		
		ccp1.accept(cp1);
		ccp2.accept(cp1, cp2);
	}
	
	private static void predicateExample() {
		System.out.println("Predicate examples:");
		
		Predicate<String> p1 = String::isEmpty;
		Predicate<String> p2 = x -> x.isEmpty();
		
		System.out.println(p1.test(""));
		System.out.println(p2.test(""));
		
		BiPredicate<String, String> b1 = String::startsWith;
		BiPredicate<String, String> b2 = (s1, s2) -> s1.startsWith(s2);
		
		System.out.println(b1.test("chicken", "chick"));
		System.out.println(b2.test("chicken", "chick"));
	}
	
	private static void functionExample() {
		System.out.println("Function examples:");
		
		Function<String, Integer> f1 = String::length;
		Function<String, Integer> f2 = x -> x.length();
		
		System.out.println(f1.apply("cluck"));
		System.out.println(f2.apply("cluck"));
		
		BiFunction<String, String, String> b1 = String::concat;
		BiFunction<String, String, String> b2 = (string, toAdd) -> string.concat(toAdd);
		
		System.out.println(b1.apply("baby", "chick"));
		System.out.println(b2.apply("baby", "chick"));
	}
	
	private static void operatorExample() {
		System.out.println("Operator examples:");
		
		UnaryOperator<String> u1 = String::toUpperCase;
		UnaryOperator<String> u2 = s -> s.toUpperCase();
		
		System.out.println(u1.apply("chirp"));
		System.out.println(u2.apply("chirp"));
		
		BinaryOperator<String> b1 = String::concat;
		BinaryOperator<String> b2 = (string, toAdd) -> string.concat(toAdd);
		
		System.out.println(b1.apply("baby", "chick"));
		System.out.println(b2.apply("baby", "chick"));
		
	}
}

class ConsumerParam {
	
	ConsumerParam(String str) {
		this.str = str;
	}
	
	String str;
	
	/*
	 * Only one:
	 * 	--- void print()
	 * or
	 *  --- static void print(ConsumerParam p2)
	 */
	
	/*void print() {
		System.out.println(str);
	}*/
	
	static void print(ConsumerParam p2) {
		System.out.println(p2.str);
	}
	
	static void print(ConsumerParam p1, ConsumerParam p2) {
		System.out.println(p1.str + p2.str);
	}
}

@FunctionalInterface
interface FuncIntExample001 {
	public void testMethod();
}


@FunctionalInterface
interface FuncIntExample002 {
	public void testMethod() throws IOException; // It is OK to throw checked exception
}
