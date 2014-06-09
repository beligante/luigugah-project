package com.domain;

import java.util.Date;
import java.util.List;

public class Prontuario extends Entity{
	
	private Paciente paciente;
	private String sintomas;
	private String diagnosticoDaDoenca;
	private String prescricaoDeTratamento;
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
