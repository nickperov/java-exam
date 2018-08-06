package com.nickperov.study.ocp_1Z0_809.ch9_NIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

public class FileAttributesExmpls {
	
	public static void main(String[] args) throws IOException {
		
		readingCommonFileAttributes();
		
		readingAdditionalFileAttributes();
		
		readBassicAttributes();
		
		modifyBassicAttributes();
	}
	
	private static void readingCommonFileAttributes() {
		System.out.println("========================= Read common file attributes =========================");
		
		Path path = Paths.get("src/resources/Dictionary.txt");
		System.out.println("Check path: " + path);
		
		System.out.println("Is regular file: " + Files.isRegularFile(path));
		System.out.println("Is directory: " + Files.isDirectory(path));
		System.out.println("Is symbolic link: " + Files.isSymbolicLink(path));
	}
	
	private static void readingAdditionalFileAttributes() throws IOException {
		System.out.println("========================= Read additional file attributes =========================");
		Path path = Paths.get("src/resources/Dictionary.txt");
		System.out.println("Check path: " + path);
		
		System.out.println("Is hidden file: " + Files.isHidden(path));
		System.out.println("Is readable file: " + Files.isReadable(path));
		System.out.println("Is executable file: " + Files.isExecutable(path));
		System.out.println("File size: " + Files.size(path) + " bytes");
		System.out.println("Last modified: " + Files.getLastModifiedTime(path));
		System.out.println("Owner: " + Files.getOwner(path));
	}
	
	private static void readBassicAttributes() throws IOException {
		System.out.println("========================= Read attributes data =========================");
		Path path = Paths.get("src/resources/Dictionary.txt");
		System.out.println("Check path: " + path);
		
		System.out.println("Read basic attributes");
		BasicFileAttributes basicData = Files.readAttributes(path, BasicFileAttributes.class);
		
		System.out.println("Is regular file: " + basicData.isRegularFile());
		System.out.println("Is directory: " + basicData.isDirectory());
		System.out.println("Is symbolic link: " + basicData.isSymbolicLink());
		System.out.println("Path not a file, directory, nor symbolic link: " + basicData.isOther());
		System.out.println("Size: " + basicData.size() + " bytes");
		
		System.out.println("Creation date/time: " + basicData.creationTime());
		System.out.println("Last modified date/time: " + basicData.lastModifiedTime());
		System.out.println("Last accessed date/time: " + basicData.lastAccessTime());
		
		System.out.println("Unique file identifier (if available): " + basicData.fileKey());
	}
	
	private static void modifyBassicAttributes() throws IOException {
		System.out.println("========================= Modify attributes view =========================");
		Path path = Paths.get("src/resources/Dictionary.txt");
		System.out.println("Check path: " + path);
		BasicFileAttributeView basicDataView = Files.getFileAttributeView(path, BasicFileAttributeView.class);
		
		BasicFileAttributes basicData = basicDataView.readAttributes();
		FileTime lastModifyTime = basicData.lastModifiedTime();
		System.out.println("Current last modification time: " + lastModifyTime);
		
		FileTime newLastModifyTime = FileTime.fromMillis(lastModifyTime.toMillis() + 5000);
		System.out.println("Set modification time to: " + newLastModifyTime);
		basicDataView.setTimes(newLastModifyTime, null, null);
		
		System.out.println("New last modification time: " + Files.getLastModifiedTime(path));
	}
}