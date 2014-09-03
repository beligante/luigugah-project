package com.saei.domain.enums;

public enum TipoPessoa {
	FISCA("Fisica", 'F'), JURIDICA("Juridica", 'J');
	
	private String label;
	private Character sigla;
	
	private TipoPessoa(String label, Character sigla){
		
		this.label = (label);
		this.sigla = (sigla);
	}

	public String getLabel() {
		return label;
	}

	public Character getSigla() {
		return sigla;
	}

}
