package com.entity;

import java.util.Date;

public class Devolucao extends Entity {
	private Emprestimo emprestimo;

	public Debito registarDevolucao(){
		if(emprestimo.isAtrasado()){
			Debito d = new Debito()
							.emprestimo(emprestimo)
							.usuario(emprestimo.getUsuario())
							.diasAtraso(calculaDiasAtrasoDevolucao());
			return d;
		}
		
		emprestimo.getExemplar().devolver();
		emprestimo.setDevolvido(true);
		
		return null;
	}
	
	private Long calculaDiasAtrasoDevolucao(){
		
		long diff = new Date().getTime() - emprestimo.getDataDevolucao().getTime();
		long diffDays = diff / (24 * 60 * 60 * 1000);
		
		return diffDays;
	}
	
}
