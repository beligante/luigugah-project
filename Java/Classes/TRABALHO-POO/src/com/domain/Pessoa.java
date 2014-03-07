package com.domain;

public class Pessoa {
	
	private String nome;
	private String cpf;
	private String rg;
	private String datanasc;
	private String endereco;
	private String telefone;
	private String email;
	
	public Pessoa() {
		
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getCpf() {
		return this.cpf;
	}
	
	public void setRg(String rg) {
		this.rg = rg;
	}
	
	public String getRg() {
		return this.rg;
	}
	
	public void setDataNasc(String dataNasc) {
		this.datanasc = dataNasc;
	}
	
	public String getDataNasc() {
		return this.datanasc;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getEndereco() {
		return this.endereco;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getTelefone() {
		return this.telefone;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
}
