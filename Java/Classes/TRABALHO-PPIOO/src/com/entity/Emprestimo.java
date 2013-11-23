package com.entity;

import java.util.Calendar;
import java.util.Date;

public class Emprestimo {
	private Usuario usuario;
	private Exemplar exemplar;
	private Date dataEmprestimo, dataDevolucao;
	private Boolean devolvido;
	
	
	public Emprestimo(){
		this.dataEmprestimo = new Date();
		calculaDataDevolucao();
		this.devolvido = false;
	}
	
	private void calculaDataDevolucao(){
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, usuario.getPerfil().getDuracaoEmprestimo());
		this.dataDevolucao = c.getTime();		
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public Exemplar getExemplar() {
		return exemplar;
	}


	public void setExemplar(Exemplar exemplar) {
		this.exemplar = exemplar;
	}


	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}

	public Date getDataDevolucao() {
		return dataDevolucao;
	}

	public Boolean getDevolvido() {
		return devolvido;
	}

	public void setDevolvido(Boolean devolvido) {
		this.devolvido = devolvido;
	}
	
	
	
	

	
}
