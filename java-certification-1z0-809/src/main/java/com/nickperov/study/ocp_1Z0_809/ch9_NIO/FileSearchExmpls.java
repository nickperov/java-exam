package com.nickperov.study.ocp_1Z0_809.ch9_NIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

public class FileSearchExmpls {
	
	public static void main(String[] args) throws IOException {
		walkingDirectory();
		
		fileSearch();
		
		listingDirContents();
	}
	
	private static void walkingDirectory() throws IOException {
		System.out.println("========================= Walking directory =========================");
		
		Path path = Paths.get(".");
		System.out.println("Explore: " + path.toAbsolutePath());
		System.out.println("Look for Exmpls.java");
		// Depth-first strategy
		Files.walk(path).filter(p -> p.toString().endsWith(".java") && p.toString().contains("Exmpls")).forEach(System.out::println);
	}
	
	private static void fileSearch() throws IOException {
		System.out.println("========================= File search =========================");
		
		Path path = Paths.get(".");
		long dateFilter = 1420070400000l;

		System.out.println("Explore: " + path.toAbsolutePath());
		System.out.println("Look for Examples.java with last modification date > " + new Date(1420070400000l));
		// Depth-first strategy
		Files.find(path, 10, (p, a) -> p.toString().endsWith(".java") && p.toString().contains("Examples")
				&& a.lastModifiedTime().toMillis() > dateFilter).forEach(System.out::println);
	}
	
	private static void listingDirContents() throws IOException {
		System.out.println("========================= Listing directory contents =========================");
		Path path = Paths.get(".");
		System.out.println("Listing dir: " + path.toAbsolutePath());
		Files.list(path).forEach(System.out::println);
	}
}