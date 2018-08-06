package com.nickperov.study.ocp_1Z0_809.ch8_IO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CalcCodeSource {
	
	private static String pattern = ".java";
	private static String rootPath = "../..";
	//private static String rootPath = "src/";
	//private static String rootPath = "C:/SoftwareDevelopment/CMA_Projects/Depox3Project/PNGX/SSYSjW_M2";
	private static int countFiles = 0;
	
	private static boolean isMultiThread = true;
	
	public static void main(String[] args) {
		
		File root = new File(rootPath);
		
		System.out.println("Calc number of code rows for root: " + root.getAbsolutePath());
		
		final long numOfRows;
		if (isMultiThread)
			numOfRows = calcRowsMultiThread(root);
		else
			numOfRows = calcRowsSingleThread(root);
		
		System.out.println("Number of rows: " + numOfRows + ", number of files: " + countFiles);
	}
	
	private static long calcRowsSingleThread(File root) {
		return calcDirectory(root);
	}
	
	private static long calcRowsMultiThread(File root) {
		List<File> srcFiles = new ArrayList<>();
		collectSrcFiles(root, srcFiles);
		CalcRows calcRows = new CalcRows(srcFiles, 0, srcFiles.size());
		ForkJoinPool pool = new ForkJoinPool();
		return pool.invoke(calcRows);
	}
	
	private static long calcDirectory(File directory) {
		if (!directory.isDirectory())
			return 0l;
	//	System.out.println("!!!! ====>" + directory.getAbsolutePath());
		long count = 0l;
		
		List<File> directories = Stream.of(directory.listFiles()).filter(file -> file.isDirectory()).collect(Collectors.toList());
		List<File> srcFiles = Stream.of(directory.listFiles()).filter(file -> file.isFile()).filter(ft -> ft.getName().endsWith(pattern)).collect(Collectors.toList());
		
		for (File dir : directories)
			count += calcDirectory(dir);
		
		for (File file : srcFiles)
			count += calcSrcFile(file);
		
		return count;
	}
	
	private static long calcSrcFile(File file) {
		if (!file.isFile())
			return 0l;
		
		//System.out.println("++++ ====>" + file.getAbsolutePath());
		countFiles++;
		
		try (BufferedReader fileReader = new BufferedReader(new FileReader(file))) {
			return fileReader.lines().count();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0l;
	}
	
	private static void collectSrcFiles(File directory, List<File> srcFilesAcumulator) {
		if (!directory.isDirectory())
			return;
		
		List<File> directories = Stream.of(directory.listFiles()).filter(file -> file.isDirectory()).collect(Collectors.toList());
		List<File> srcFiles = Stream.of(directory.listFiles()).filter(file -> file.isFile()).filter(ft -> ft.getName().endsWith(pattern)).collect(Collectors.toList());
		
		srcFilesAcumulator.addAll(srcFiles);
		
		for (File dir : directories)
			collectSrcFiles(dir, srcFilesAcumulator);
	}
	
	private static class CalcRows extends RecursiveTask<Long> {
		
		private static final long serialVersionUID = -4270294746929953633L;
		
		private List<File> srcFiles;
		int start;
		int end;
		
		private CalcRows(List<File> srcFiles, int start, int end) {
			this.srcFiles = srcFiles;
			this.start = start;
			this.end = end;
		}

		@Override
		protected Long compute() {
			if ((end - start) > 100) {
				// Split
				int middle = start + (end - start) / 2;
				CalcRows otherCalcRows = new CalcRows(srcFiles, middle, end);
				otherCalcRows.fork();
				return new CalcRows(srcFiles, start, middle).compute() + otherCalcRows.join();
			} else {
				// Calc
				long count = 0;
				for (int i = start; i < end; i++)
					count += calcSrcFile(srcFiles.get(i));
				return count;
			}
		}
	}
}


