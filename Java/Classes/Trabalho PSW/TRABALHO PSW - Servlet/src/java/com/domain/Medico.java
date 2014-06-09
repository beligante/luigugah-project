package com.domain;

public class Medico extends Usuario{

    public Medico() {
            super();
    }

    @Override
    public String getFuncao() {
        return Medico.class.getSimpleName();
    }
}
