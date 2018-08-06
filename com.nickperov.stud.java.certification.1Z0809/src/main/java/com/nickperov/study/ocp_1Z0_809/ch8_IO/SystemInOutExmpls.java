package com.nickperov.study.ocp_1Z0_809.ch8_IO;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

public class SystemInOutExmpls {
	
	public static void main(String[] args) throws IOException {
	
		systemInSample();
		
		consoleSample();
	}
	
	private static void systemInSample() throws IOException {
		System.out.println("============= Try system sample input (old way) ===========");
		System.out.println("Print something...");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String userInput = reader.readLine();
		
		System.out.println("You entered the following: " + userInput);
	}
	
	
	private static void consoleSample() {
		System.out.println("============= Try console sample input (new way) ===========");
		System.out.println("Print something...");
		Console console = System.console();
		if (console != null) {
			String userInput = console.readLine();
			console.writer().println("You entered the following: " + userInput);
		}
	}
}
