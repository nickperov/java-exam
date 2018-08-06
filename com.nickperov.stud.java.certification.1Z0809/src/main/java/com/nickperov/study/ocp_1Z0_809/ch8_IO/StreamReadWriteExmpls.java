package com.nickperov.study.ocp_1Z0_809.ch8_IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class StreamReadWriteExmpls {
	
	public static void main(String[] args) throws IOException {
		streamMarking();
		skippingData();
		copyFileSample();
		copyBufferFileSample();
		copyTextFileSample();
		copyTextFileWithEncoding();
	}
	
	private static InputStream getInputStream() throws UnsupportedEncodingException {
		String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		return new ByteArrayInputStream(str.getBytes("UTF-8"));
	}
	
	private static void streamMarking() throws IOException {
		System.out.println("========================= Mark/reset stream =========================");
		InputStream is = getInputStream();
		System.out.println((char)is.read());
		if (is.markSupported()) {
			is.mark(100);
			System.out.println((char)is.read());
			System.out.println((char)is.read());
			System.out.println((char)is.read());
			System.out.println((char)is.read());
			is.reset();
		}
		System.out.println((char)is.read());
		System.out.println((char)is.read());
		System.out.println((char)is.read());
		System.out.println((char)is.read());
		System.out.println((char)is.read());
	}
	
	private static void skippingData() throws IOException {
		System.out.println("========================= Skip data in the stream =========================");
		InputStream is = getInputStream();
		System.out.println((char)is.read());
		is.skip(10);
		System.out.println((char)is.read());
		System.out.println((char)is.read());
		System.out.println((char)is.read());
	}
	
	private static void copyFileSample() throws IOException {
		System.out.println("========================= Copy file =========================");
		
		File source = new File("src/resources/Database.txt");
		File destination = new File("src/resources/DB_Copy" + new Date().getTime() + ".txt");
		
		copy(source, destination);
		
		System.out.println("Copy: " + source.getName() + " -> " + destination.getName() + " done");
	}
	
	private static void copy(File source, File destination) throws IOException {
		try (InputStream in = new FileInputStream(source);
				OutputStream out = new FileOutputStream(destination)) {
			int b;
			while((b = in.read()) != -1) {
				out.write(b);
			}
		}
	}
	
	private static void copyBufferFileSample() throws IOException {
		System.out.println("========================= Copy file =========================");
		
		File source = new File("src/resources/Database.txt");
		File destination = new File("src/resources/DB_Copy" + new Date().getTime() + ".txt");
		
		copyBuffered(source, destination);
		
		System.out.println("Copy: " + source.getName() + " -> " + destination.getName() + " done");
	}
	
	private static void copyBuffered(File source, File destination) throws IOException {
		try (InputStream in = new BufferedInputStream(new FileInputStream(source));
				OutputStream out = new BufferedOutputStream(new FileOutputStream(destination))) {
			byte[] buffer = new byte[1024];
			int lengthRead;
			while((lengthRead = in.read(buffer)) > 0) {
				out.write(buffer, 0, lengthRead);
				out.flush();
			}
		}
	}
	
	private static void copyTextFileSample() throws FileNotFoundException, IOException {
		System.out.println("========================= Copy text file =========================");
		
		File source = new File("src/resources/Database.txt");
		File destination = new File("src/resources/DB_Copy" + new Date().getTime() + ".txt");
		
		List<String> data = readFile(source);
		writeFile(data, destination);
		
		System.out.println("Copy: " + source.getName() + " -> " + destination.getName() + " done");
	}
	
	private static List<String> readFile(File source) throws FileNotFoundException, IOException {
		List<String> data = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
			String s;
			while ((s = reader.readLine()) != null) {
				data.add(s);
			}
		}
		return data;
	}
	
	private static void writeFile(List<String> data, File destination) throws IOException {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(destination))) {
			for (String s : data) {
				writer.write(s);
				writer.newLine();
			}
		}
	}
	
	private static void copyTextFileWithEncoding() throws FileNotFoundException, IOException {
		System.out.println("================= Copy text file with enconding =======================");
		
		System.out.println("Default charset: " + Charset.defaultCharset().name());
		
		File source = new File("src/resources/Dictionary.txt");
		String data = readTextFileDefEncoding(source);
		
		String charSetName = "UTF-16";
		Charset utf16 = Charset.forName(charSetName);
		
		File destination1 = new File("src/resources/Dictionary_copy_" + charSetName + "_" +new Date().getTime() + ".txt");
		
		writeTextFileEncoding(data, destination1, utf16);
		
		System.out.println("Copy text with UTF-16 done to " + destination1.getName());
		
		charSetName = "Windows-1251";
		Charset w1251 = Charset.forName(charSetName);
		
		File destination2 = new File("src/resources/Dictionary_copy_" + charSetName + "_" + new Date().getTime() + ".txt");
		
		writeTextFileEncoding(data, destination2, w1251);
		
		System.out.println("Copy text with Windows-1252 done to " + destination2.getName());
		
		System.out.println();
		System.out.println("------------------------------------");
		
		System.out.println("Read utf16 file with default encoding");
		System.out.println(readTextFileDefEncoding(destination1));;
		
		System.out.println("------------------------------------");
		
		System.out.println("Read utf16 file with utf16 encoding");
		System.out.println(readTextFileWithEncoding(destination1, Charset.forName("UTF-16")));
		
		
		System.out.println("------------------------------------");
		
		System.out.println("Read w1251 file with default encoding");
		System.out.println(readTextFileDefEncoding(destination2));
	}
	
	private static void writeTextFileEncoding(String data, File destination, Charset utf16) throws FileNotFoundException, IOException {
		try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(destination))) {
			int group = 8;
			byte[] bytes = data.getBytes(utf16);
			int index = 0;
			while (true) {
				int length = Math.min(group, bytes.length - index);
				if (length == 0)
					break;
				
				out.write(Arrays.copyOfRange(bytes, index, index + length));
				out.flush();
				
				index = index + length;
			}
		}
	}
	
	private static String readTextFileWithEncoding(File source, Charset charSet) {
		StringBuilder sb = new StringBuilder();
		try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(source))) {
			byte[] buffer = new byte[16];
			int lengthRead;
			while ((lengthRead = in.read(buffer)) > 0) {
				String str;
				if (charSet != null)
					str = new String(buffer, 0, lengthRead, charSet);
				else
					// Read with default encoding
					str = new String(buffer, 0, lengthRead);
				
		//		System.out.println("++++++++++++++++++++++++++++++" + str);
				sb.append(str);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	private static String readTextFileDefEncoding(File source) {
		return readTextFileWithEncoding(source, null);
	}
}
