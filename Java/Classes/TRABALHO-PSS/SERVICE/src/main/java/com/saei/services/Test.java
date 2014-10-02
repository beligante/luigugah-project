package com.saei.services;

import java.math.BigDecimal;

public class Test {
	
	public static void main(String[] args){
		System.out.println(SimulacaoService.generateSimulation(new BigDecimal(1100), new BigDecimal(10), new BigDecimal(100), 10));
	}

}
