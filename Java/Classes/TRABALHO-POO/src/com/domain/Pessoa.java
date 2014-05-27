package com.domain;

import java.util.Date;

import com.enums.Sexo;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Pessoa extends Entity{
	
        @Column(name="nome")
	private String nome;
        
	@Column(name="cpf")
	private String cpf;
	
        @Column(name="rg")
	private String rg;
	
        @Column(name="dataNascimento")
	private Date dataNascimento;
	
        @Column(name="endereco")
	private String endereco;
	
        @Column(name="telefone")
	private String telefone;
	
        @Column(name="email")
	private String email;
	
        @Enumerated(EnumType.STRING)
        @Column(name="sexo")
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
