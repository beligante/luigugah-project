package com.entity;

import java.util.ArrayList;
import java.util.List;

import com.enums.Regras;

public class Perfil extends Entity {
	
	private String nome;
	private Integer duracaoEmprestimo;
	private List<Regras> regras;
	private int cotaEmprestimo;

	public Perfil(){
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
	public Integer getDuracaoEmprestimo() {
		return duracaoEmprestimo;
	}
	public void setDuracaoEmprestimo(Integer duracaoEmprestimo) {
		this.duracaoEmprestimo = duracaoEmprestimo;
	}
	
	public Perfil nome(String nome){
		this.nome = nome;
		return this;
	}
	public Perfil duracaoEmprestimo(Integer duracaoEmprestimo){
		this.duracaoEmprestimo = duracaoEmprestimo;
		return this;
	}

	public int getCotaEmprestimo() {
		return cotaEmprestimo;
	}

	public void setCotaEmprestimo(int cotaEmprestimo) {
		this.cotaEmprestimo = cotaEmprestimo;
	}
}
