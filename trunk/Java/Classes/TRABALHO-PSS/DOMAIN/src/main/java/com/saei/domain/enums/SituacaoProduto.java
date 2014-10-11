package com.saei.domain.enums;

public enum SituacaoProduto {
	VENDIDO, ALUGADO, DISPONIVEL;
	
	
	public static SituacaoProduto findByName(String name){
		for(SituacaoProduto tipo : SituacaoProduto.values()){
			if(tipo.name().equalsIgnoreCase(name)){
				return tipo;
			}
		}
		
		return null;
	}
}
