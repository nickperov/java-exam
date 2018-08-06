package com.nickperov.study.ocp_1Z0_809.ch9_NIO;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathFileTest {
	
	private static void printPathInformation(Path path) {
		System.out.println("Filename is: " + path.getFileName());
		System.out.println("Root is: " + path.getRoot());
		
		Path currentParent = path;
		while ((currentParent = currentParent.getParent()) != null) {
			System.out.println("Current parent is: " + currentParent);
		}
	}
	
	public static void main(String[] args) {
		printPathInformation(Paths.get("/zoo/armadillo/shels.txt"));
		System.out.println();
		printPathInformation(Paths.get("armadillo/shels.txt"));
	}
}