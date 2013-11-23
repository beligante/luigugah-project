package com.entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.xml.crypto.Data;

public class teste {

	public static void main(String[] args) {
		
		Calendar c = Calendar.getInstance();
		Date d =  new Date();
		
		c.add(Calendar.DAY_OF_MONTH, -20);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println(sdf.format(c.getTime()));
	}
	

}
