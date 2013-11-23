package com.entity;

import java.util.Date;

import com.enums.Categoria;

public class Obra {
	
	private String nome, ator, editora, isbn;
	private Categoria categoria;
	private Date dataPublicacao;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getAtor() {
		return ator;
	}
	public void setAtor(String ator) {
		this.ator = ator;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Date getDataPublicacao() {
		return dataPublicacao;
	}
	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}
	
	public Obra nome(String nome){
		this.nome = nome;
		return this;
	}
	public Obra ator(String ator){
		this.ator = ator;
		return this;
	}
	public Obra editora(String editora){
		this.editora = editora;
		return this;
	}
	public Obra isbn(String isbn){
		this.isbn = isbn;
		return this;
	}
	public Obra dataPublicacao(Date data){
		this.dataPublicacao = data;
		return this;
	}
	public Obra categoria(Categoria categoria){
		this.categoria = categoria;
		return this;
	}
	

}
