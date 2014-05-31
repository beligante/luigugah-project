package com.domain;

import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "cirurgias")
@javax.persistence.Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Cirurgia extends Entity {

    public Cirurgia() {
    }

    public Cirurgia(String cirurgia) {
        this.cirurgia = cirurgia;
    }

    @ManyToOne
    private Paciente paciente;

    @Column(name = "cirurgia")
    private String cirurgia;

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getCirurgia() {
        return cirurgia;
    }

    public void setCirurgia(String cirurgia) {
        this.cirurgia = cirurgia;
    }

    @Override
    public String toString() {
        return "Cirurgia{" + "cirurgia=" + cirurgia + '}';
    }
    
}
