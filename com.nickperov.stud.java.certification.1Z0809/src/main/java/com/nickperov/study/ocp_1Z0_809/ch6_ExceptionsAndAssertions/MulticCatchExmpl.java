package com.nickperov.study.ocp_1Z0_809.ch6_ExceptionsAndAssertions;

import java.io.Closeable;
import java.io.IOException;

public class MulticCatchExmpl {
	public static void main(String[] args) {
		
		try {
			// do some work 
		} catch(RuntimeException e) {
			e = new RuntimeException();
		}
		
		try {
			throw new IOException();
		} catch(IOException | RuntimeException e) { 
		//	e = new RuntimeException(); // DOES NOT COMPILE }
		}
		
		try (TestACloseable t = new TestACloseable()) {
			
		}
		
	}
	
	static class TestACloseable implements AutoCloseable {

		@Override
		public void close()/* throws Exception*/ {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	static class TestCloseable implements Closeable {

		int i = 0;
		
		@Override
		public void close() throws IOException {
		}
		
	}
}
