package com.nickperov.study.ocp_1Z0_809.ch8_IO;

import java.io.File;
import java.util.Arrays;

public class FileExmpl {
	
	public static void main(String[] args) {
		fileConstants();
		
		simpleFile();
		
		makeChild();
		
		fileMethods();
	}
	
	private static void fileConstants() {
		System.out.println("================ File constants =============================");
		System.out.println("Path separator: " + File.pathSeparator);
		System.out.println("Separator: " + File.separator);
	}
	
	private static void simpleFile() {
		System.out.println("================ Get simple file =============================");
		File file = new File("/home/smith/data/zoo.txt");
		System.out.println("File: " + file + " - " + file.exists());
	}
	
	private static void makeChild() {
		System.out.println("================ Make child file =============================");
		File parent = new File("/home/smith");
		File child = new File(parent, "data/zoo.txt");
		
		System.out.println("File: " + child);
	}
	
	private static void fileMethods() {
		System.out.println("================ File methods =============================");
		File file = new File("src/resources/Dictionary.txt");
		System.out.println("File: " + file);
		System.out.println("Full path: " + file.getAbsolutePath());
		System.out.println("Exists: " + file.exists());
		System.out.println("Is file: " + file.isFile());
		System.out.println("Is directory: " + file.isDirectory());
		System.out.println("Length: " + file.length());
		System.out.println("Last modified: " + file.lastModified());
		File parent = file.getParentFile();
		System.out.println("Parent: " + parent);
		System.out.println("Parent is directory: " + parent.isDirectory());
		System.out.println("Parent files: " + Arrays.toString(parent.listFiles()));
	}
}