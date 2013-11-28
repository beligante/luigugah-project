package com.entity;

import java.text.ParseException;
import java.util.HashMap;

public class teste {

	public static void main(String[] args) throws ParseException {
		
		HashMap<String, Long> mp =  new HashMap<String, Long>();
		
		mp.put("L_L", 1L);
		
		System.out.println(mp.get("L_L"));
		
		System.out.println(new Credential().user("L").senha("L").compareTo(new Credential().user("L").senha("L")));
		
	}
	
}
