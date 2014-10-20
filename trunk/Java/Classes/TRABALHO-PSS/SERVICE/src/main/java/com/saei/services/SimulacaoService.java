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
		
		checkAtributes(valorOriginal, juros, entrada, quantidadeParcelas);
		
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

	private static void checkAtributes(BigDecimal valorOriginal,
			BigDecimal juros, BigDecimal entrada, int quantidadeParcelas) {
		
		if(valorOriginal == null){
			throw new IllegalArgumentException("O Valor Original não pode ser nulo");
		}
		
		if(valorOriginal == new BigDecimal(0).setScale(2, BigDecimal.ROUND_HALF_UP)){
			throw new IllegalArgumentException("O Valor Original não pode ser 0");
		}
		
		if(valorOriginal.compareTo(new BigDecimal(0)) < 0){
			throw new IllegalArgumentException("O Valor Original não pode ser menor que 0");
		}
		
		if(entrada == null){
			throw new IllegalArgumentException("O valor de entrada não pode ser nulo");
		}
		
		if(quantidadeParcelas <= 0){
			throw new IllegalArgumentException("O numero de parcelas não pode ser menor que 0");
		}
		
		if(entrada.compareTo(valorOriginal) > 0 ){
			throw new IllegalArgumentException("O valor de entrada não pode ser maior que o valor original(total) do produto");
		}
		
	}
	
}
