package com.entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Reserva extends Entity {
	
	private Usuario usuario;
	private Obra obra;
	private boolean retirado;
	private int posicaoFila;
	private Date dataInicioContagem;
	private static final int DIAS_CONTAGEM = 10;
	
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

	public Date getDataInicioContagem() {
		return dataInicioContagem;
	}

	public void setDataInicioContagem(Date dataInicioContagem) {
		this.dataInicioContagem = dataInicioContagem;
	}
	
	public boolean isExpirado(){
		if(dataInicioContagem == null){ return false;}
		
		Calendar c = Calendar.getInstance();
		c.setTime(dataInicioContagem);
		c.add(Calendar.DAY_OF_MONTH, DIAS_CONTAGEM);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date dataAtual = new Date();
		Date dataEstipuladaParaRetirada = c.getTime();
		try{
			dataAtual = sdf.parse(sdf.format(dataAtual));
			dataEstipuladaParaRetirada = sdf.parse(sdf.format(dataEstipuladaParaRetirada));
			
			dataAtual = sdf.parse(sdf.format(dataAtual));
			dataEstipuladaParaRetirada = sdf.parse(sdf.format(dataEstipuladaParaRetirada));
		
			return dataAtual.after(dataEstipuladaParaRetirada);
		}
		catch (Exception e){};
		return false;
		
	}

}
