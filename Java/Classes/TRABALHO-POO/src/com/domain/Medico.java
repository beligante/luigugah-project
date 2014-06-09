package com.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@javax.persistence.Entity
@DiscriminatorValue("medico")
public class Medico extends Usuario {

    public Medico() {
        super();
    }

}
