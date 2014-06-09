package com.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@javax.persistence.Entity
@DiscriminatorValue("secretaria")
public class Secretaria extends Usuario {

    public Secretaria() {
        super();
    }

}
