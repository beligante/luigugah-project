package com.entity;

import java.util.Date;

import com.entity.Perfil;
import com.enums.Sexo;

public class Usuario extends Entity {
	
	private String nome, cpf, rg, telefone, endereco;
	private Date dataNascimento;
	private Perfil perfil;
	private Sexo sexo;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Perfil getPerfil() {
		return perfil;
	}
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	public Sexo getSexo() {
		return sexo;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	
	public Usuario nome(String nome){
		this.nome = nome;
		return this;
	}
	public Usuario cpf(String cpf){
		this.cpf = cpf;
		return this;
	}
	public Usuario rg(String rg){
		this.rg = rg;
		return this;
	}
	public Usuario telefone(String tel){
		this.telefone = tel;
		return this;
	}
	public Usuario endereco(String endereco){
		this.endereco = endereco;
		return this;
	}
	public Usuario dataNascimento(Date nascimento){
		this.dataNascimento = nascimento;
		return this;
	}
	public Usuario sexo(Sexo sexo){
		this.sexo = sexo;
		return this;
	}
	public Usuario perfil(Perfil perfil){
		this.perfil = perfil;
		return this;
	}
	
	
	
}
