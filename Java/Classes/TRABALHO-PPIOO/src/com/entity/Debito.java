package com.entity;

public class Debito extends Entity {
	private Float valor;
	private Usuario usuario;
	private Emprestimo emprestimo;
	private Long diasAtraso;
	private boolean isPago;
	
	public Debito(){
		isPago = false;
	}
	
	public Float getValor() {
		return valor;
	}
	public void setValor(Float valor) {
		this.valor = valor;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Emprestimo getEmprestimo() {
		return emprestimo;
	}
	public void setEmprestimo(Emprestimo emprestimo) {
		this.emprestimo = emprestimo;
	}
	public Long getDiasAtraso() {
		return diasAtraso;
	}
	public void setDiasAtraso(Long diasAtraso) {
		this.diasAtraso = diasAtraso;
	}

	public Debito usuario(Usuario usuario){
		this.usuario = usuario;
		return this;
	}
	
	public Debito emprestimo(Emprestimo emprestimo){
		this.emprestimo = emprestimo;
		return this;
	}
	
	public Debito diasAtraso(Long dias){
		this.diasAtraso = dias;
		return this;
	}
	public boolean isPago() {
		return isPago;
	}
	
	public void pagar(){
		this.isPago = true;
	}
}
