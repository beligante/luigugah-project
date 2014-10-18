package com.saei.domain.enums;

public enum TipoSituacao {
	
	PENDENTE("Pendente"),CANCELADO("Cancelado"),CONTATO_EFETUADO("Contato Efetuado"),AGUARDANDO_RESPOSTA("Aguardando Resposta")
	,VENDIDO("Vendido");
	
	private String label;
	
	TipoSituacao (String label){
		this.label = label;
	}
	
	public String getLabel (){
		return this.label;
	}

	public static TipoSituacao findTipoSituacaoByName (String nome){
		for (TipoSituacao tipo : TipoSituacao.values()){
			if (tipo.name().equalsIgnoreCase(nome)){
				return tipo;
			}
		}
		
		return null;
	}
	
}
