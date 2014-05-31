package com.domain;

import com.enums.TipoAtendimento;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.Type;

@javax.persistence.Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "PACIENTE")
public class Paciente extends Pessoa{
	
        @Column(name="tipoAtendimento")
        @Enumerated(EnumType.STRING)
        private TipoAtendimento tipoAtendimento;
	
        @Column(name="isFumante")
        @Type(type = "yes_no")
	private boolean isFumante;
	
        @Column(name="isAlcolatra")
	@Type(type = "yes_no")
        private boolean isAlcolatra;
	
        @Column(name="isDiabetico")
	@Type(type = "yes_no")
        private boolean isDiabetico;
	
        @Column(name="isCardiaco")
	@Type(type = "yes_no")
        private boolean isCardiaco;
	
        @ElementCollection
        @CollectionTable(name="paciente_cirurgias", joinColumns=@JoinColumn(name="cirurgia_id"))
        private List<String> cirurgias;
	
	@ElementCollection
        @CollectionTable(name="paciente_alergias", joinColumns=@JoinColumn(name="alergias_id"))
        private List<String> alergias;
	
        @Column(name="colesterol")
	private float colesterol;
	
	public Paciente() {
		
	}
	
	public void setTipoAtendimento(TipoAtendimento tipoatendimento) {
		this.tipoAtendimento = tipoatendimento;
	}
	
	public TipoAtendimento getTipoAtendimento() {
		return this.tipoAtendimento;
	}
	
	public void setIsFumante(boolean isFumante) {
		this.isFumante = isFumante;		
	}
	
	public boolean getIsFumante() {
		return this.isFumante;
	}
	
	public void setIsAlcolatra(boolean isAlcolatra) {
		this.isAlcolatra = isAlcolatra;
	}
	
	public boolean getIsAlcolatra() {
		return this.isAlcolatra;
	}
	
	public void setIsDiabetico(boolean isDiabetico) {
		this.isDiabetico = isDiabetico;
	}
	
	public boolean getIsDiabetico() {
		return this.isDiabetico;
	}
	
	public void setIsCardiaco(boolean isCardiaco) {
		this.isCardiaco = isCardiaco;
	}

	public boolean getIsCardiaco() {
		return this.isCardiaco;
	}
	
	public void setCirurgias(List<String> cirurgias) {
		this.cirurgias = cirurgias;
	}
	
	public List<String> getCirurgias() {
		return this.cirurgias;
	}
	
	public boolean addCirurgias(String cirurgia) {
		if (this.cirurgias != null) {
			this.cirurgias.add(cirurgia);
			return true;
		} return false;
	}
	
	public void setAlergias(List<String> alergias) {
		this.alergias = alergias;
	}
	
	public List<String> getAlergias() {
		return this.alergias;
	}
	
	public boolean addAlergias(String alergia) {
		if (this.alergias != null) {
			this.alergias.add(alergia);
			return true;
		} return false;
	}
	
	public void setColesterol(Float colesterol) {
		this.colesterol = colesterol;
	}
	
	public Float getColesterol() {
		return this.colesterol;
	}
	
}
