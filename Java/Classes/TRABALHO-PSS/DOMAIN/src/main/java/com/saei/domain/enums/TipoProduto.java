package com.saei.domain.enums;

public enum TipoProduto {
	
	
	APARTAMENTO("Apartamento"),
	APARTAMENTO_DUPLEX("Apartamento Duplex"),
	APARTAMENTO_KITNET("Apartamento kitnet"),
	CASA("Casa"),
	GALPAO_INDUSTRIAL("Galpao (Industrial)"),
	PREDIO("Predio"),
	SALAO_COMERCIAL("Sal�o Comercial"),
	SOBRADO("Sobrado"),
	TERRENO("Terreno");
	
	private String label;
	private TipoProduto(String label){
		this.label = label;
	}
	
	public String getLabel(){return label;}
	
}
