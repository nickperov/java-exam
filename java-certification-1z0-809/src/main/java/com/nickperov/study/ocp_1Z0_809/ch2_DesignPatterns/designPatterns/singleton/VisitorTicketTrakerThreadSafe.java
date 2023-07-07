package com.nickperov.study.ocp_1Z0_809.ch2_DesignPatterns.designPatterns.singleton;

/*
 * Example of singleton (lazy initialization)
 * thread safe
 */
public class VisitorTicketTrakerThreadSafe {
	
	private static VisitorTicketTrakerThreadSafe instance;
	
	private VisitorTicketTrakerThreadSafe() {}
	
	public static synchronized VisitorTicketTrakerThreadSafe getInstance() {
		if (instance == null) {
			instance = new VisitorTicketTrakerThreadSafe();
		}
		return instance;
	}

}
