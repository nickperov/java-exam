package com.nickperov.study.ocp_1Z0_809.ch2_DesignPatterns.designPatterns.singleton;

/*
 * Example of singleton (lazy initialization)
 * thread safe with Double-Check Locking
 */
public class VisitorTicketTrakerTSDoubleChlLock {

	private static volatile VisitorTicketTrakerTSDoubleChlLock instance;
	
	private VisitorTicketTrakerTSDoubleChlLock() {}
	
	public static VisitorTicketTrakerTSDoubleChlLock getInstance() {
		if (instance == null) {
			synchronized (VisitorTicketTrakerTSDoubleChlLock.class) {
				if (instance == null)
					instance = new VisitorTicketTrakerTSDoubleChlLock();
			}
		}
		return instance;
	}
}
