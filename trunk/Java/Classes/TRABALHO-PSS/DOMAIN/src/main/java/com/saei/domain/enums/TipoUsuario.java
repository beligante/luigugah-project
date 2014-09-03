package com.saei.domain.enums;

public enum TipoUsuario {
	ADMIN("Admin", 1), VENDEDOR("Vendedor", 2), CLIENTE("Cliente", 3);
	
	private String label;
	private Integer valor;
	
	private TipoUsuario(String label, Integer valor){
		
	}

	public String getLabel() {
		return label;
	}
	
	public Integer getValor(){
		return valor;
	}
}
