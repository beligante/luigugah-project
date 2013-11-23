package com.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.xml.crypto.Data;

public class teste {

	public static void main(String[] args) throws ParseException {
		
		Calendar c = Calendar.getInstance();
		Date d =  new Date();
		
		c.add(Calendar.DAY_OF_MONTH, 90);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date e =  new Date();
		
		d = sdf.parse(sdf.format(d));
		e = sdf.parse(sdf.format(e));
		
	}
	
}
