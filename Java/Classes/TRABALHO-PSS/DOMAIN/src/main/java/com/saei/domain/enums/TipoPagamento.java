package com.saei.domain.enums;

public enum TipoPagamento {
	
	BOLETO_MENSAL;

	
	public static TipoPagamento findByName(String name){
		for(TipoPagamento tipo : TipoPagamento.values()){
			if(tipo.name().equalsIgnoreCase(name)){
				return tipo;
			}
		}
		
		return null;
	}
}
