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

    @Override
    public String toString() {
        return "Usuario{" + "user=" + user + ", password=" + password + '}';
    }
}
