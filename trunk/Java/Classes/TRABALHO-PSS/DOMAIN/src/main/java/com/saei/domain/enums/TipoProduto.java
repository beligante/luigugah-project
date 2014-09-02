package com.saei.domain.enums;

public enum TipoProduto {
	
	
	APARTAMENTO("Apartamento"),
	APARTAMENTO_DUPLEX("Apartamento Duplex"),
	APARTAMENTO_KITNET("Apartamento kitnet"),
	CASA("Casa"),
	GALPÃO_INDUSTRIAL("Galpão (Industrial)"),
	PREDIO("Predio"),
	SALAO_COMERCIAL("Salão Comercial"),
	SOBRADO("Sobrado"),
	TERRENO("Terreno");
	
	private String label;
	private TipoProduto(String label){
		this.label = label;
	}
	
	public String getLabel(){return label;}
	
}
