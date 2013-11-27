package com.enums;

public enum Categoria {
	
	LIVRO(true), PERIODICO(false), ENCICLOPEDIA(false), 
	MIDIA(true), DICIONARIO(true), MAPA(false);
	
	private Boolean isEmprestavel;
	private Categoria(Boolean emprestavel) {
		setIsEmprestavel(emprestavel);
	}
	public Boolean getIsEmprestavel() {
		return isEmprestavel;
	}
	public void setIsEmprestavel(Boolean isEmprestavel) {
		this.isEmprestavel = isEmprestavel;
	}
}
