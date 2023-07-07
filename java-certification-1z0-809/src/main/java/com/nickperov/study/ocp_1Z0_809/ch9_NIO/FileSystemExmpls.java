package com.nickperov.study.ocp_1Z0_809.ch9_NIO;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class FileSystemExmpls {
	
	public static void main(String[] args) throws URISyntaxException {
		checkDefaultFileSystem();
		
		checkRemoteFileSystem();
	}
	
	private static void checkDefaultFileSystem() {
		FileSystem fs = FileSystems.getDefault();
		System.out.println(fs);
	}
	
	private static void checkRemoteFileSystem() throws URISyntaxException {
		FileSystem fs = FileSystems.getFileSystem(new URI("ftp://www.selikof.net"));
		Path path = fs.getPath("duck.txt");
		
		System.out.println(path);
	}
}
