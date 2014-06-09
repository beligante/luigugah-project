package com.domain;

import java.util.Date;

import com.enums.Sexo;

public class Pessoa extends Entity{
	
	private String nome;
	private String cpf;
	private String rg;
	private Date dataNascimento;
	private String endereco;
	private String telefone;
	private String email;
	private Sexo sexo;
	
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
	
	public void setDataNascimento(Date dataNasc) {
		this.dataNascimento = dataNasc;
	}
	
	public Date getDataNascimento() {
		return this.dataNascimento;
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

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Sexo getSexo() {
		return sexo;
	}
        
        @Override
        public String toString(){
            return this.nome;
        }
}
