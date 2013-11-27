package com.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.xml.crypto.Data;

public class teste {

	public static void main(String[] args) throws ParseException {
		
		HashMap<String, Long> mp =  new HashMap<String, Long>();
		
		mp.put("L_L", 1L);
		
		System.out.println(mp.get("L_L"));
		
		System.out.println(new Credential().user("L").senha("L").compareTo(new Credential().user("L").senha("L")));
		
	}
	
}
