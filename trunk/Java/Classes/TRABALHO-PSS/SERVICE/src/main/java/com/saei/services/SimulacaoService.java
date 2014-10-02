package com.saei.services;

import java.math.BigDecimal;

import com.saei.domain.Simulacao;

public class SimulacaoService {
	
	private static final BigDecimal CEM = new BigDecimal(100);

	public static Simulacao generateSimulation(BigDecimal valorOriginal, 
												BigDecimal juros, 
												BigDecimal entrada,
												int quantidadeParcelas){
		
		BigDecimal valorJuros = valorOriginal.subtract(entrada).divide(CEM, BigDecimal.ROUND_HALF_UP).multiply(juros);
		
		BigDecimal valorParcela = valorOriginal
										.subtract(entrada)
										.add(valorJuros)
										.divide(new BigDecimal(quantidadeParcelas), 
												BigDecimal.ROUND_HALF_UP);
		
		BigDecimal valorTotal = valorParcela.multiply(new BigDecimal(quantidadeParcelas));
	
		Simulacao simulacao = new Simulacao();
		simulacao.setJuros(juros);
		simulacao.setEntrada(entrada);
		simulacao.setQuantidadeParcelas(quantidadeParcelas);
		simulacao.setValorFinal(valorTotal);
		simulacao.setValorOriginal(valorOriginal);
		simulacao.setValorParcelas(valorParcela);
		
		return simulacao;
	}
	
}
