package com.nickperov.study.ocp_1Z0_809.ch8_IO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Date;

import com.nickperov.study.ocp_1Z0_809.ch8_IO.SerializationExmpls.Animal;

public class PrintStrWrtExmpls {
	
	public static void main(String[] args) throws IOException {
		PrintStream out = System.out;
		
		out.println("Try PrintWriter");
		
		printWriterTest01();
		printWriterTest02();
	}
	
	private static void printWriterTest01() throws FileNotFoundException {
		try (PrintWriter out = new PrintWriter("src/resources/zoo" + new Date().getTime() + ".log") ){
			out.print(5); // PrintWriter method
			out.write(String.valueOf(5)); // Writer method
			out.print(2.0); // PrintWriter method
			out.write( String.valueOf(2.0)); // Writer method
			Animal animal = new Animal();
			out.print(animal); // PrintWriter method
			out.write(animal == null ? "null": animal.toString()); // Writer method	
		}
	}
	
	private static void printWriterTest02() throws IOException {
		File source = new File("src/resources/zoo_weather_" + new Date().getTime() + ".log");
		try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(source)))) {		
			out.print("Today's weather is: ");
			out.println("Sunny");
			out.print("Today's temperature at the zoo is: ");
			out.print(1/3.0);
			out.println('C');
			out.format("It has rained 10.12 inches this year");
			out.println();
			out.printf("It may rain 21.2 more inches this year");

		}
	}
}
