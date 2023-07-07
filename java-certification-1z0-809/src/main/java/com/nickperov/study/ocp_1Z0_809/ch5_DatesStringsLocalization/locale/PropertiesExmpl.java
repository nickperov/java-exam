package com.nickperov.study.ocp_1Z0_809.ch5_DatesStringsLocalization.locale;

import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

public class PropertiesExmpl {
	
	public static void main(String[] args) {
		Properties props = new Properties();
		Locale en = new Locale("en", "EN");
		ResourceBundle rb = ResourceBundle.getBundle("test", en);
		
		System.out.println("=================Get Keys=================");
		rb.keySet().stream().forEach(System.out::println);
		System.out.println("=================Get Values=================");
		rb.keySet().stream().map(k -> rb.getString(k)).forEach(System.out::println);
		System.out.println("=================Organize properties=================");
		rb.keySet().stream().forEach(k -> props.put(k, rb.getString(k)));
		System.out.println(props.getProperty("Id"));
		System.out.println(props.getProperty("Number", "357323"));
	}
}