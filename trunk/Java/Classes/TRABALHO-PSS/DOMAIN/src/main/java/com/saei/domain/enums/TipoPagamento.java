package com.saei.domain.enums;

public enum TipoPagamento {
	
	BOLETO_MENSAL("Boleto Mensal");
	
	private String label;


	private TipoPagamento(String label){ this.label = label;}

	
	public static TipoPagamento findByName(String name){
		for(TipoPagamento tipo : TipoPagamento.values()){
			if(tipo.name().equalsIgnoreCase(name)){
				return tipo;
			}
		}
		
		return null;
	}
	
	public String getLabel(){return this.label;}
}
