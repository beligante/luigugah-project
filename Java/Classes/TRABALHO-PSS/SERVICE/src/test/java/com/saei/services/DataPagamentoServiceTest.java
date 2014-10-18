package com.saei.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

public class DataPagamentoServiceTest {

	private static final SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");
	
	@Test
	public void testeRetornoNulloQuandoDataEPassadaNulla(){
		Assert.assertNull(DataPagamentoService.getDataPagamentoProximoMesByDataAtual(null, 5));
	}
	@Test
	public void testeRetornoNulloQuandoDiaVencimentoEInvalido(){
		Assert.assertNull(DataPagamentoService.getDataPagamentoProximoMesByDataAtual(new Date(), -1));
		Assert.assertNull(DataPagamentoService.getDataPagamentoProximoMesByDataAtual(new Date(), 95));
	}
	
	
	@Test
	public void testaCorretudeDoRetornoDoMetodos(){
		Date parametro = getData("16/10/2014");
		Date retorno = getData("05/11/2014");
		
		Assert.assertTrue(retorno.equals(DataPagamentoService.getDataPagamentoProximoMesByDataAtual(parametro, 5)));
		
		parametro = getData("01/11/2013");
		retorno = getData("10/12/2013");
	
		Assert.assertTrue(retorno.equals(DataPagamentoService.getDataPagamentoProximoMesByDataAtual(parametro, 10)));

		parametro = getData("05/09/2014");
		retorno = getData("05/10/2014");
	
		Assert.assertTrue(retorno.equals(DataPagamentoService.getDataPagamentoProximoMesByDataAtual(parametro, 5)));
		
		parametro = getData("20/03/2014");
		retorno = getData("12/04/2014");
	
		Assert.assertTrue(retorno.equals(DataPagamentoService.getDataPagamentoProximoMesByDataAtual(parametro, 12)));
	}
	
	public void testaValidadeRetornoDiaPagamentoDado(){
		Date data = new Date();
		
		Assert.assertFalse(DataPagamentoService.isDiaPagamentoValido(90, 5, data));
		Assert.assertFalse(DataPagamentoService.isDiaPagamentoValido(-3, 5, data));
		
		Assert.assertFalse(DataPagamentoService.isDiaPagamentoValido(5, 0, data));
		Assert.assertFalse(DataPagamentoService.isDiaPagamentoValido(5, -1, data));
		
		Assert.assertFalse(DataPagamentoService.isDiaPagamentoValido(5, 5, null));
		
		Assert.assertFalse(DataPagamentoService.isDiaPagamentoValido(31, 12, data));
		Assert.assertFalse(DataPagamentoService.isDiaPagamentoValido(30, 12, data));
		

		Assert.assertTrue(DataPagamentoService.isDiaPagamentoValido(9, 10, data));
		Assert.assertTrue(DataPagamentoService.isDiaPagamentoValido(10, 25, data));
		Assert.assertTrue(DataPagamentoService.isDiaPagamentoValido(1, 12, data));
		Assert.assertTrue(DataPagamentoService.isDiaPagamentoValido(3, 24, data));
	}
	
	private static Date getData(String dataStr){
		try {
			return SDF.parse(dataStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
