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
	
	public void setIsAlcolatra(boolean isAlcolatra) {
		this.isAlcolatra = isAlcolatra;
	}
	
	public boolean getIsAlcolatra() {
		return this.isAlcolatra;
	}
	
	public void setIsDiabetico(boolean isDiabetico) {
		this.isDiabetico = isDiabetico;
	}
	
	public boolean getIsDiabetico() {
		return this.isDiabetico;
	}
	
	public void setIsCardiaco(boolean isCardiaco) {
		this.isCardiaco = isCardiaco;
	}

	public boolean getIsCardiaco() {
		return this.isCardiaco;
	}
	
	public void setCirurgias(List<String> cirurgias) {
		this.cirurgias = cirurgias;
	}
	
	public List<String> getCirurgias() {
		return this.cirurgias;
	}
	
	public boolean addCirurgias(String cirurgia) {
		if (this.cirurgias != null) {
			this.cirurgias.add(cirurgia);
			return true;
		} return false;
	}
	
	public void setAlergias(List<String> alergias) {
		this.alergias = alergias;
	}
	
	public List<String> getAlergias() {
		return this.alergias;
	}
	
	public boolean addAlergias(String alergia) {
		if (this.alergias != null) {
			this.alergias.add(alergia);
			return true;
		} return false;
	}
	
	public void setColesterol(Float colesterol) {
		this.colesterol = colesterol;
	}
	
	public Float getColesterol() {
		return this.colesterol;
	}
	
}
