package com.domain;

import java.util.List;

import com.enums.TipoAtendimento;

public class Passiente {
	
	private TipoAtendimento tipoAtendimento;
	private boolean isFumante;
	private boolean isAlcolatra;
	private boolean isDiabetico;
	private boolean isCardiaco;
	private List<String> cirurgias;
	private List<String> alergias;
	private float colesterol;
	
	public Passiente() {
		
	}
	
	public void setTipoAtendimento(TipoAtendimento tipoatendimento) {
		this.tipoAtendimento = tipoatendimento;
	}
	
	public TipoAtendimento getTipoAtendimento() {
		return this.tipoAtendimento;
	}
	
	public void setIsFumante(boolean isFumante) {
		this.isFumante = isFumante;		
	}
	
	public boolean getIsFumante() {
		return this.isFumante;
	}

}
