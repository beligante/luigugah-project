package com.saei.services;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
	
	public static void main(String[] args){
		BigDecimal big1 = new BigDecimal(10);
		BigDecimal big2 = new BigDecimal(11);
		BigDecimal big3 = new BigDecimal(10);
		BigDecimal big4 = new BigDecimal(9);
		

		System.out.println(big1.compareTo(big2));
		System.out.println(big1.compareTo(big3));
		System.out.println(big1.compareTo(big4));
	}

}
