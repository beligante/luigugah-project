package com.saei.services;

import java.util.Calendar;
import java.util.Date;

public class DataPagamentoService {
	
	public static Date getDataPagamentoProximoMesByDataAtual(Date dataAtual, int diaVencimento){
		
		if(dataAtual == null || diaVencimento < 0){return null;}
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dataAtual);
		calendar.add(Calendar.MONTH, 1);
		int ultimoDiaDoMes = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		if(diaVencimento > ultimoDiaDoMes){return null;}
		calendar.set(Calendar.DAY_OF_MONTH, diaVencimento);
		
		return calendar.getTime();
	}
	
	public static boolean isDiaPagamentoValido(int dia, int quantidadeParcelas, Date dataAtual){
		
		if(dia < 0 || quantidadeParcelas < 1 || dataAtual == null){
			return false;
		}
		
		Date dataPagamento = dataAtual;
		
		for(int contador = 0; contador < quantidadeParcelas; contador++){
			dataPagamento = getDataPagamentoProximoMesByDataAtual(dataPagamento, dia);
			if(dataAtual == null){return false;}
		}
		
		return true;
	}

}
