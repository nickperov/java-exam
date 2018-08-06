package com.nickperov.study.ocp_1Z0_809.ch8_IO;

import java.io.Console;
import java.util.Arrays;

public class PasswordCompareSample {
	public static void main(String[] args) {
		Console console = System.console();
		if (console == null) {
			throw new RuntimeException("Console not available");
		} else {
			char[] password = console.readPassword("Enter your password: ");
			console.format("Re-enter your password: ");
			console.flush();
			char[] verify = console.readPassword();
			boolean match = Arrays.equals(password, verify);
			
			// Immediately clear password from memory
			for (int i = 0; i < password.length; i++)
				password[i]='x';
			for (int i = 0; i < verify.length; i++)
				verify[i]='x';
			
			console.format("Your password was " + (match ? "correct" : "incorrect"));
		}
	}
}
