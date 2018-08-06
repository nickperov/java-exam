package com.nickperov.study.ocp_1Z0_809.ch2_DesignPatterns.designPatterns.singleton;

/*
 * Example of singleton (lazy initialization)
 * not thread safe
 */
public class VisitorTicketTraker {
	
	private static VisitorTicketTraker instance;
	
	private VisitorTicketTraker() {}
	
	public static VisitorTicketTraker getInstance() {
		if (instance == null) {
			instance = new VisitorTicketTraker(); // NOT THERAD-SAFE
		}
		return instance;
	}
}