package com.saei.services;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
	
	public static void main(String[] args){
		Date dataAtual = new Date();
		Date dataProximoMes = DataPagamentoService.getDataPagamentoProximoMesByDataAtual(new Date(), 10);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println(sdf.format(dataAtual));
		System.out.println(sdf.format(dataProximoMes));
	}

}
