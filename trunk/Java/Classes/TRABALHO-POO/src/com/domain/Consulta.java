package com.domain;

import java.util.Date;

import com.enums.TipoAtendimento;
import com.enums.TipoConsulta;

public class Consulta extends Entity{
	
	private Date dataConsulta;
	private Medico medico;
	private Paciente paciente;
	private TipoConsulta tipoConsulta;
	public Date getDataConsulta() {
		return dataConsulta;
	}
	public void setDataConsulta(Date dataConsulta) {
		this.dataConsulta = dataConsulta;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public TipoConsulta getTipoConsulta() {
		return tipoConsulta;
	}
	public void setTipoConsulta(TipoConsulta tipoConsulta) {
		this.tipoConsulta = tipoConsulta;
	}
}
