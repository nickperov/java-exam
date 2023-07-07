package com.nickperov.study.ocp_1Z0_809.ch10_JDBC;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class MyFirstDatabaseConnection {
	
	public static void main(String[] args) throws SQLException {
		testDerbyDBConnection();
		
		derbyDBConnection();
		
		mySqlDBConnection();
		
		selectCount();
		
		selectDate();
		
		selectTime();
		
		selectTimeStamp();
		
		scrollResults();
		
		goToAbsoluteResults();
		
		goToRelativeResults();
	}
	
	private static void testDerbyDBConnection() throws SQLException {
		String url = "jdbc:derby:zoo";
		
		System.out.println("=== Test derby DB connection: " + url + " ===");
		
		Connection conn = DriverManager.getConnection(url);
		System.out.println(conn);
		conn.close();
	}
	
	private static void derbyDBConnection() throws SQLException {
		String url = "jdbc:derby:zoo";
		
		System.out.println("=== Connect to derby DB: " + url + " ===");
		
		try (Connection conn = DriverManager.getConnection(url);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select name from animal")) {
			
			while (rs.next()) {
				System.out.println(rs.getString(1));
			}
		}
	}
	
	private static void mySqlDBConnection() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/stud";
		
		System.out.println("=== Connect to MySql DB: " + url + " ===");
		String username = "root";
		String password = "MYSQL";
		
		try (Connection conn = DriverManager.getConnection(url, username, password);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select code from participants")) {
			
			while (rs.next()) {
				System.out.println(rs.getString(1));
			}
		}
	}
	
	private static void selectCount() throws SQLException {
		String url = "jdbc:derby:zoo";
		
		System.out.println("=== Select count(*) ===");
		
		try (Connection conn = DriverManager.getConnection(url);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select count(*) from animal")) {
			if (rs.next())
				System.out.println("Count: " + rs.getInt(1));
		}
	}
	
	private static void selectDate() throws SQLException {
		String url = "jdbc:derby:zoo";
		
		System.out.println("=== Select date ===");
		
		try (Connection conn = DriverManager.getConnection(url);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select date_born from animal")) {
			while (rs.next()) {
				Date sqlDate = rs.getDate(1);
				LocalDate localDate = sqlDate.toLocalDate();
				System.out.println("Date: " + localDate);
			}
		}
	}
	
	private static void selectTime() throws SQLException {
		String url = "jdbc:derby:zoo";
		
		System.out.println("=== Select time ===");
		
		try (Connection conn = DriverManager.getConnection(url);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select date_born from animal")) {
			while (rs.next()) {
				Time sqlTime = rs.getTime(1);
				LocalTime localTime = sqlTime.toLocalTime();
				System.out.println("Time: " + localTime);
			}
		}
	}
	
	private static void selectTimeStamp() throws SQLException {
		String url = "jdbc:derby:zoo";
		
		System.out.println("=== Select time stamp ===");
		
		try (Connection conn = DriverManager.getConnection(url);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select date_born from animal")) {
			while (rs.next()) {
				Timestamp sqlTimeStamp = rs.getTimestamp(1);
				LocalDateTime localDateTime = sqlTimeStamp.toLocalDateTime();
				System.out.println("Date - time: " + localDateTime);
			}
		}
	}
	
	private static void scrollResults() throws SQLException {
		String url = "jdbc:derby:zoo";
		
		System.out.println("=== Scroll result set ===");
		
		try (Connection conn = DriverManager.getConnection(url);
				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stmt.executeQuery("select id from species order by id")) {
		
			rs.afterLast();
			System.out.println(rs.previous()); // true
			System.out.println(rs.getInt(1)); // 2
			System.out.println(rs.previous()); // true
			System.out.println(rs.getInt(1)); // 1
			System.out.println(rs.last()); // true
			System.out.println(rs.getInt(1)); // 2
			System.out.println(rs.first()); // true
			System.out.println(rs.getInt(1)); // 1
			rs.beforeFirst(); // true
			try {
				System.out.println(rs.getInt(1)); // exception	
			} catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	

	private static void goToAbsoluteResults() throws SQLException {
		String url = "jdbc:derby:zoo";
		
		System.out.println("=== Go to absolute row num in result set ===");
		
		try (Connection conn = DriverManager.getConnection(url);
				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stmt.executeQuery("select name from animal order by id")) {
			
			if (rs.next()) {
				System.out.println(rs.getString(1));	
			}
			System.out.println("Goto 0");
			rs.absolute(0);
			while (rs.next()) {
				System.out.println(rs.getString(1));
			}
			System.out.println("Goto -2");
			rs.absolute(-2);
			System.out.println(rs.getString(1));
		}
	}
	
	private static void goToRelativeResults() throws SQLException {
		String url = "jdbc:derby:zoo";
		
		System.out.println("=== Go to relative row num in result set ===");
		
		try (Connection conn = DriverManager.getConnection(url);
				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stmt.executeQuery("select name from animal order by id")) {
			
			if (rs.next()) {
				System.out.println(rs.getString(1));	
			}
			System.out.println("Goto 0");
			rs.absolute(0);
			while (rs.next()) {
				System.out.println(rs.getString(1));
			}
			System.out.println("Goto -2");
			rs.absolute(-2);
			System.out.println(rs.getString(1));
		}
	}
}
