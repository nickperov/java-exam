package com.nickperov.study.ocp_1Z0_809.ch9_NIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileInteractionExmpls {
	
	public static void main(String[] args) throws IOException {
		checkFileExistance();
		
		checkFileUniqueness();
		
		manageDirectories();
		
		copyFile();
		
		bufferedRead();
		
		readAllFileLines();
		
		readFileLines();
	}
	
	private static void checkFileExistance() {
		System.out.println("================== Check file existance ==================");
		
		String pathStr1 = "/ostrich/features.png";
		System.out.println("Is File " + pathStr1 + " exists? " + Files.exists(Paths.get(pathStr1))); // if file exists
		
		String pathStr2 = "src/resources";
		System.out.println("Is Directory " + pathStr2 + " exists? " + Files.exists(Paths.get(pathStr2))); // if file exists
	}
	
	private static void checkFileUniqueness() throws IOException {
		System.out.println("================== Is the same file ==================");
		
		String pathStr1 = "C:\\SoftwareDevelopment\\My_Eclipse_Projects\\STUD\\1Z0-809\\src\\resources\\Dictionary.txt";
		String pathStr2 = "src/resources/Dictionary.txt";
		Path path1 = Paths.get(pathStr1);
		Path path2 = Paths.get(pathStr2);
		
		System.out.println("Are file: " + path1 + " and file: " + path2 + " the same? " +  Files.isSameFile(path1, path2));		
	}
	
	private static void manageDirectories() throws IOException {
		System.out.println("================== Manage directories ==================");
		
		Path path = Paths.get("src/resources/test1");
		
		Files.deleteIfExists(path);
		
		if (checkPathExistance(path))
			return;
		
		System.out.println("Create directory");
		Files.createDirectories(path);
		
		if (!checkPathExistance(path))
			return;
		
		System.out.println("Remove directory");
		Files.delete(path);
		
		checkPathExistance(path);
	}
	
	private static void copyFile() throws IOException {
		System.out.println("================== Copy file ==================");
		
		Path pathOrigin = Paths.get("src/resources/Database.txt");
		Path pathCopy = Paths.get("src/resources/Database_copy.txt");
		
		if (checkPathExistance(pathOrigin)) {
			if (!checkPathExistance(pathCopy)) {
				System.out.println("Copy file");
				Files.copy(pathOrigin, pathCopy);
				// Files.copy(pathOrigin, pathCopy, StandardCopyOption.ATOMIC_MOVE); Unsupported copy option
				
				if (checkPathExistance(pathCopy)) {
					System.out.println("Remove file");
					Files.delete(pathCopy);
					
					checkPathExistance(pathCopy);
				}
			}
		}
	}
	
	private static void bufferedRead() {
		System.out.println("================== Buffered read ==================");
		Path path = Paths.get("src/resources/Dictionary.txt");
		try (BufferedReader reader = Files.newBufferedReader(path, Charset.defaultCharset())) {
			System.out.println("Read file: " + path);
			String currentLine = null;
			int i = 1;
			while ((currentLine = reader.readLine()) != null)
				System.out.println("Line " + i++ + ": " + currentLine);
		} catch (IOException e) {
			
		}
	}
	
	private static void readAllFileLines() throws IOException {
		System.out.println("================== Read all file lines ==================");
		Path path = Paths.get("src/resources/Dictionary.txt");
		List<String> lines = Files.readAllLines(path);
		
		for (String line : lines)
			System.out.println(line);
	}
	
	private static void readFileLines() throws IOException {
		System.out.println("================== Read filtered file lines ==================");
		Path path = Paths.get("src/resources/Dictionary.txt");
		Files.lines(path).filter(l -> l.contains("developer")).forEach(System.out::println);
	}
	
	private static boolean checkPathExistance(Path path) {
		if (Files.isDirectory(path)) {
			System.out.println("Directory: " + path + " is exists? " + Files.exists(path));
		} else {
			System.out.println("File: " + path + " is exists? " + Files.exists(path));
		}
		return Files.exists(path);
	}

}
