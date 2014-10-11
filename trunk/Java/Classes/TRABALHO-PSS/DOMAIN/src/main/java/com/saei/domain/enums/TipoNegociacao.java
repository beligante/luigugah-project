package com.saei.domain.enums;


public enum TipoNegociacao {
	
	ALUGUEL("Aluguel"), VENDA("Venda"), COMPRA("Compra");
	
	private String label;


	private TipoNegociacao(String label){ this.label = label;}

	
	public static TipoNegociacao findByName(String name){
		for(TipoNegociacao tipo : TipoNegociacao.values()){
			if(tipo.name().equalsIgnoreCase(name)){
				return tipo;
			}
		}
		
		return null;
	}
	
	public String getLabel(){return this.label;}
}
