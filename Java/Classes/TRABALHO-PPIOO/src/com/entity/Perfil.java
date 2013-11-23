package com.entity;

import java.util.ArrayList;
import java.util.List;

import com.enums.Regras;

public class Perfil {
	
	private String nome;
	private List<Regras> regras;

	Perfil(){
		regras = new ArrayList<Regras>();
	}
	
	public List<Regras> getRegras() {
		return regras;
	}

	public void addRegra(Regras regra) {
		this.regras.add(regra);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Perfil nome(String nome){
		this.nome = nome;
		return this;
	}
}
