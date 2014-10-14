package com.saei.services;

import java.math.BigDecimal;
import java.math.MathContext;

import com.saei.domain.Simulacao;

public class SimulacaoService {
	
	private static final BigDecimal CEM = new BigDecimal(100);

	public static Simulacao generateSimulation(BigDecimal valorOriginal, 
												BigDecimal juros, 
												BigDecimal entrada,
												int quantidadeParcelas){
		
		BigDecimal valorJuros = valorOriginal
									.subtract(entrada)
									.divide(CEM, BigDecimal.ROUND_HALF_UP)
									.multiply (juros.setScale(2, BigDecimal.ROUND_HALF_UP));
		
		BigDecimal valorParcela = valorOriginal
										.subtract(entrada)
										.add(valorJuros)
										.divide(new BigDecimal(quantidadeParcelas), 
												BigDecimal.ROUND_HALF_UP)
										.setScale(2, BigDecimal.ROUND_HALF_UP);
		
		BigDecimal valorTotal = valorParcela
									.multiply(new BigDecimal(quantidadeParcelas))
									.add(entrada);
	
		Simulacao simulacao = new Simulacao();
		simulacao.setJuros(juros.setScale(2, BigDecimal.ROUND_HALF_UP));
		simulacao.setEntrada(entrada.setScale(2, BigDecimal.ROUND_HALF_UP));
		simulacao.setQuantidadeParcelas(quantidadeParcelas);
		simulacao.setValorFinal(valorTotal.setScale(2, BigDecimal.ROUND_HALF_UP));
		simulacao.setValorOriginal(valorOriginal.setScale(2, BigDecimal.ROUND_HALF_UP));
		simulacao.setValorParcelas(valorParcela.setScale(2, BigDecimal.ROUND_HALF_UP));
		
		return simulacao;
	}
	
}
