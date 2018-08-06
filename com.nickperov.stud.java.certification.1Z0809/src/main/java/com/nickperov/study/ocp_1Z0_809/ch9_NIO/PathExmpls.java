package com.nickperov.study.ocp_1Z0_809.ch9_NIO;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathExmpls {
	
	public static void main(String[] args) throws URISyntaxException {
		
		pathExampls001();
		
		pathExampls002();
		
		viewingThePath();
		
		relative2Absolute();
		
		pathFromSubPath();
		
		relativizePath();
		
		resolvePath();
		
		normalizePath();
		
		checkFileExistence();
		
		workingWithRelaPath();
	}
	
	
	private static void pathExampls001() {
		System.out.println("============================= Create path by string =============================");
		
		Path path1 = Paths.get("pandas/cuddly.png"); // relative
		
		Path path2 = Paths.get("c:\\zooinfo\\November\\employees.txt"); // Absolute Windows
		
		Path path3 = Paths.get("/home/zoodirector"); // Absolute Linux, MAC
		
		Path path4 = Paths.get("/", "home", "zooinfo");
		
		
		System.out.println(path1.toString());
		System.out.println(path2.toString());
		System.out.println(path3.toString());
		System.out.println(path4.toString());
	}
	
	private static void pathExampls002() throws URISyntaxException {
		System.out.println("============================= Create path by URI =============================");
		
		Path path = Paths.get(new URI("file:///c:/zoo-info/November/employees.txt"));
		
		System.out.println(path);
	}
	
	private static void viewingThePath() {
		System.out.println("============================= Viewing path =============================");
		
		Path path = Paths.get("/land/hippo/harry.happy");
		System.out.println("Path: " + path);
		System.out.println("Root: " + path.getRoot());
		
		for (int i = 0; i < path.getNameCount(); i++) {
			System.out.println("Element " + i + " is: " + path.getName(i));
		}
	}
	
	private static void relative2Absolute() {
		System.out.println("============================= Relative to absolute path =============================");
		
		Path path1 = Paths.get("c:\\birds\\egret.txt");
		System.out.println("Path1 is Absolute? " + path1.isAbsolute());
		System.out.println("Absolute Path1: " + path1.toAbsolutePath());
		
		Path path2 = Paths.get("birds/condor.txt");
		System.out.println("Path2 is Absolute? " + path2.isAbsolute());
		System.out.println("Absolute Path2: " + path2.toAbsolutePath());
	}
	
	private static void pathFromSubPath() {
		
		System.out.println("============================= Path from subpath =============================");
		
		Path path = Paths.get("/mammal/carnivore/racoon.image");
		System.out.println("PAth is: " + path);
		
		System.out.println("Subpath from 0 to 3 is: " + path.subpath(0, 3));
		System.out.println("Subpath from 1 to 3 is: " + path.subpath(1, 3));
		System.out.println("Subpath from 1 to 2 is: " + path.subpath(1, 2));
	}
	
	private static void relativizePath() {
		
		System.out.println("============================= Relativize path =============================");
		
		Path path1 = Paths.get("fish.txt");
		Path path2 = Paths.get("birds.txt");
		
		System.out.println(path1.relativize(path2));
		System.out.println(path2.relativize(path1));
	}
	
	private static void resolvePath() {
		
		System.out.println("============================= Resolve path =============================");
		
		Path path1 = Paths.get("/cats/../panther");
		Path path2 = Paths.get("food");
		
		System.out.println(path1.resolve(path2));
		
		Path path3 = Paths.get("/turkey/food");
		Path path4 = Paths.get("/tiger/cage");
		
		System.out.println(path3.resolve(path4));
	}
	
	private static void normalizePath() {
		System.out.println("============================= Normalize path =============================");
		
		Path path1 = Paths.get("E:\\data");
		Path path2 = Paths.get("E:\\user\\home");
		
		System.out.println("Path1: " + path1 + "; Path2: " + path2);
		
		Path relativePath = path1.relativize(path2);
		System.out.println("Relative path 2 -> 1: " + relativePath);		
		System.out.println("Path 1 + relative: " + path1.resolve(relativePath));
		System.out.println("Normilize path: " + path1.resolve(relativePath).normalize());
	}
	
	private static void workingWithRelaPath() {
		System.out.println("============================= Working with relative path =============================");
		Path path = Paths.get("/zoo/animals/bear/koala/food.txt");
		System.out.println("Original path: " + path);
		System.out.println("Original absolute path: " + path.toAbsolutePath());
		System.out.println("Name 1 of original absolute path: " + path.toAbsolutePath().getName(1));
		System.out.println("Subpath 1 - 3 of original path: " + path.subpath(1,3));
		System.out.println("Name 1 of subpath 1 - 3 of original path: " + path.subpath(1,3).getName(1));
		
		System.out.println(path.subpath(1,3).getName(1).toAbsolutePath());
	}
	
	private static void checkFileExistence() {
		System.out.println("============================= File existance with real path =============================");
		try {
			System.out.println(Paths.get("zebar/food.source").toRealPath());
		} catch(IOException e) {
			System.out.println(e);
		}
		try {
			System.out.println(Paths.get(".").toRealPath());
		} catch(IOException e) {
			System.out.println(e);
		}
	}
}