package com.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@javax.persistence.Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "prontuario")
public class Prontuario extends Entity{
	
        @OneToOne(fetch = FetchType.EAGER)
        private Paciente paciente;
        
        @Column(name="sintomas")
	private String sintomas;
	
        @Column(name="diagnosticoDaDoenca")
	private String diagnosticoDaDoenca;
	
        @Column(name="prescricaoDeTratamento")
	private String prescricaoDeTratamento;
	
        @Column(name="dataModificacao")
	private Date dataModificacao;
        
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public String getSintomas() {
		return sintomas;
	}
	public void setSintomas(String sintomas) {
		this.sintomas = sintomas;
	}
	public String getDiagnosticoDaDoenca() {
		return diagnosticoDaDoenca;
	}
	public void setDiagnosticoDaDoenca(String diagnosticoDaDoenca) {
		this.diagnosticoDaDoenca = diagnosticoDaDoenca;
	}
	public String getPrescricaoDeTratamento() {
		return prescricaoDeTratamento;
	}
	public void setPrescricaoDeTratamento(String prescricaoDeTratamento) {
		this.prescricaoDeTratamento = prescricaoDeTratamento;
	}
	public Date getDataModificacao() {
		return dataModificacao;
	}
	public void setDataModificacao(Date dataModificacao) {
		this.dataModificacao = dataModificacao;
	}
}
