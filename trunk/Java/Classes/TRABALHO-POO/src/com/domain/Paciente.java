package com.domain;

import com.enums.TipoAtendimento;
import com.utils.CollectionUtils;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Type;

@javax.persistence.Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "PACIENTE")
public class Paciente extends Pessoa {

    @Column(name = "tipoAtendimento")
    @Enumerated(EnumType.STRING)
    private TipoAtendimento tipoAtendimento;

    @Column(name = "isFumante")
    @Type(type = "yes_no")
    private boolean isFumante;

    @Column(name = "isAlcolatra")
    @Type(type = "yes_no")
    private boolean isAlcolatra;

    @Column(name = "isDiabetico")
    @Type(type = "yes_no")
    private boolean isDiabetico;

    @Column(name = "isCardiaco")
    @Type(type = "yes_no")
    private boolean isCardiaco;

    @OneToMany()
    @JoinColumn(name = "id")
    private List<Cirurgia> cirurgias;

    @OneToMany()
    @JoinColumn(name = "id")
    private List<Alergia> alergias;

    @Column(name = "colesterol")
    private float colesterol;

    public Paciente() {
        alergias = new ArrayList<Alergia>();
        cirurgias = new ArrayList<Cirurgia>();
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

    /**
     *
     * @param cirurgias
     */
    public void setCirurgias(List<Cirurgia> cirurgias) {
        this.cirurgias = cirurgias;
    }

    public List<Cirurgia> getCirurgias() {
        return this.cirurgias;
    }

    public boolean addCirurgias(String cirurgia) {
        if (this.cirurgias != null) {

            this.cirurgias.add(new Cirurgia(cirurgia));
            return true;
        }
        return false;
    }

    /**
     *
     * @param cirurgias
     */
    public void setCirurgias(ArrayList<String> cirurgias) {

        if (CollectionUtils.isNotEmpty(cirurgias)) {
            List<Cirurgia> cirurgiasList = new ArrayList<Cirurgia>();
            for (String cirurgia : cirurgias) {
                cirurgiasList.add(new Cirurgia(cirurgia));
            }
            this.cirurgias = cirurgiasList;
        }
    }

    public void setAlergias(ArrayList<String> alergias) {

        if (CollectionUtils.isNotEmpty(alergias)) {
            List<Alergia> alergiasList = new ArrayList<Alergia>();
            for (String alergia : alergias) {
                alergiasList.add(new Alergia(alergia));
            }
            this.alergias = alergiasList;
        }
    }

    public void setAlergias(List<Alergia> alergias) {

        this.alergias = alergias;
    }

    public List<Alergia> getAlergias() {
        return this.alergias;
    }

    public boolean addAlergias(String alergia) {
        if (this.alergias != null) {
            this.alergias.add(new Alergia(alergia));
            return true;
        }
        return false;

    }

    public void setColesterol(Float colesterol) {
        this.colesterol = colesterol;
    }

    public Float getColesterol() {
        return this.colesterol;
    }

}
