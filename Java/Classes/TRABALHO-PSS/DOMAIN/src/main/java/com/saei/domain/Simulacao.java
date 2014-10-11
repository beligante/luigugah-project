package com.saei.domain;

import java.math.BigDecimal;

public class Simulacao {
	private BigDecimal valorOriginal;
	private BigDecimal juros;
	private int quantidadeParcelas;
	private BigDecimal valorParcelas;
	private BigDecimal valorFinal;
	private BigDecimal entrada;
	private int diaVencimentoBoleto;
	
	public BigDecimal getValorOriginal() {
		return valorOriginal;
	}
	public void setValorOriginal(BigDecimal valorOriginal) {
		this.valorOriginal = valorOriginal;
	}
	public BigDecimal getJuros() {
		return juros;
	}
	public void setJuros(BigDecimal juros) {
		this.juros = juros;
	}
	public int getQuantidadeParcelas() {
		return quantidadeParcelas;
	}
	public void setQuantidadeParcelas(int quantidadeParcelas) {
		this.quantidadeParcelas = quantidadeParcelas;
	}
	public BigDecimal getValorParcelas() {
		return valorParcelas;
	}
	public void setValorParcelas(BigDecimal valorParcelas) {
		this.valorParcelas = valorParcelas;
	}
	public BigDecimal getValorFinal() {
		return valorFinal;
	}
	public void setValorFinal(BigDecimal valorFinal) {
		this.valorFinal = valorFinal;
	}
	
	public void setEntrada(BigDecimal entrada) {
		this.entrada = entrada;	
	}
	
	public BigDecimal getEntrada() {
		return this.entrada;	
	}
	@Override
	public String toString() {
		return "Simulacao [valorOriginal=" + valorOriginal + ", juros=" + juros
				+ ", quantidadeParcelas=" + quantidadeParcelas
				+ ", valorParcelas=" + valorParcelas + ", valorFinal="
				+ valorFinal + ", entrada=" + entrada + "]";
	}

	public int getDiaVencimentoBoleto() {
		return diaVencimentoBoleto;
	}
	public void setDiaVencimentoBoleto(int diaVencimentoBoleto) {
		this.diaVencimentoBoleto = diaVencimentoBoleto;
	}
	
	
}
