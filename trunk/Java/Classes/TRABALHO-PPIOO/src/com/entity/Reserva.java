package com.entity;


public class Reserva extends Entity {
	
	private Usuario usuario;
	private Exemplar exemplar;
	private boolean retirado;
	private int posicaoFila;
	
	private static int RESERVA_INSTANCE_COUNT = 0;
	
	public Reserva(){
		super();
		this.posicaoFila = RESERVA_INSTANCE_COUNT++;
		retirado = false;
	}
	
	public int getPosicaoFila(){
		return posicaoFila;
	}
	
	public Exemplar getExemplar() {
		return exemplar;
	}
	public void setExemplar(Exemplar exemplar) {
		this.exemplar = exemplar;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Reserva exemplar(Exemplar exemplar){
		this.exemplar = exemplar;
		return this;
	}
	
	public Reserva usuario(Usuario usuario){
		this.usuario = usuario;
		return this;
	}
	
	public boolean isRetirado(){return retirado;}
	
	public void retirar(){
		retirado = true;
	}

}
