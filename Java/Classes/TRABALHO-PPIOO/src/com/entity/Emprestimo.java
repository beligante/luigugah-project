package com.entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Emprestimo extends Entity{
	private Usuario usuario;
	private Exemplar exemplar;
	private Date dataEmprestimo, dataDevolucao;
	private Boolean devolvido;
	
	
	public Emprestimo(){
		this.dataEmprestimo = new Date();
		calculaDataDevolucao();
		this.devolvido = false;
	}
	
	
	public Boolean isAtrasado(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date dataAtual = new Date();
		Date dataDev = dataDevolucao;
		try{
			dataAtual = sdf.parse(sdf.format(dataAtual));
			dataDev = sdf.parse(sdf.format(dataDev));
			
			dataAtual = sdf.parse(sdf.format(dataAtual));
			dataDev = sdf.parse(sdf.format(dataDev));
		
			return dataAtual.after(dataDev);
		}
		catch (Exception e){};
		return new Boolean (false);
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
	
	public Emprestimo usuario(Usuario usuario){
		this.usuario = usuario;
		return this;
	}
	
	public Emprestimo exemplar(Exemplar exemplar) {
		this.exemplar = exemplar;
		return this;
	}
	
	
	

	
}
