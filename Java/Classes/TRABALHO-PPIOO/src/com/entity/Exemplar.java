package com.entity;

public class Exemplar extends Entity {

	private Obra obra;
	private Boolean emprestado;
	
	public Obra getObra() {
		return obra;
	}
	public void setObra(Obra obra) {
		this.obra = obra;
	}
	public Boolean isEmprestado() {
		return emprestado;
	}
	
	public Exemplar obra(Obra obra){
		this.obra = obra;
		return this;
	}
	
	public Exemplar emprestar(){
		this.emprestado = true;
		return this;
	}
	
	public Exemplar devolver(){
		this.emprestado = false;
		return this;
	}
}
