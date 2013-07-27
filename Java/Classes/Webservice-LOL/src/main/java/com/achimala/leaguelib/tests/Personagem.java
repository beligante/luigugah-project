package com.achimala.leaguelib.tests;

import java.io.Serializable;

public class Personagem implements Serializable{

	private static final long serialVersionUID = 1L;

	private String nome, sobrenome;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	private int idade;
}
