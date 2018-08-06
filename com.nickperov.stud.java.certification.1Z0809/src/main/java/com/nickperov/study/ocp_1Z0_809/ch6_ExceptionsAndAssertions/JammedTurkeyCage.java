package com.nickperov.study.ocp_1Z0_809.ch6_ExceptionsAndAssertions;

public class JammedTurkeyCage implements AutoCloseable {
	
	public void close() throws IllegalStateException {
		throw new IllegalStateException("Cage door does not close");
	}
	
	public static void main(String[] args) {
		try (JammedTurkeyCage t = new JammedTurkeyCage()) {
			System.out.println(" put turkeys in");
		} catch (IllegalStateException e) {
			System.out.println(" caught: " + e.getMessage());
		}
		
		System.out.println("===================== 1 Suppreessed Exception ===========================");
		
		try (JammedTurkeyCage t = new JammedTurkeyCage()) { 
			throw new IllegalStateException(" turkeys ran off");
		} catch (IllegalStateException e) {
			System.out.println(" caught: " + e.getMessage());
			for (Throwable t: e.getSuppressed())
				System.out.println(t.getMessage());
		}
		
		System.out.println("===================== 2 Suppreessed Exceptions ===========================");
		
		try (JammedTurkeyCage t1 = new JammedTurkeyCage();
				JammedTurkeyCage t2 = new JammedTurkeyCage()) {
			throw new IllegalStateException(" turkeys ran off");
		} catch (IllegalStateException e) {
			e.printStackTrace();
			/*System.out.println(" caught: " + e.getMessage());
			for (Throwable t: e.getSuppressed())
				System.out.println(t.getMessage());*/
		}
	}
}
