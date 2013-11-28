package com.entity;


public class Reserva extends Entity {
	
	private Usuario usuario;
	private Obra obra;
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

	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Reserva obra(Obra obra){
		this.setObra(obra);
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

	public Obra getObra() {
		return obra;
	}

	public void setObra(Obra obra) {
		this.obra = obra;
	}

}
