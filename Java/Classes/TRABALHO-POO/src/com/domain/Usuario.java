package com.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

@Table(name = "usuario")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@javax.persistence.Entity
@DiscriminatorColumn(name = "usuario_tipo")
public abstract class Usuario extends Pessoa {

    @Column(name = "login")
    protected String user;

    @Column(name = "password")
    protected String password;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return getNome();
    }

}
