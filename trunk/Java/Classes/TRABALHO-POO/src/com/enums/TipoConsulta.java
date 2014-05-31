package com.enums;

public enum TipoConsulta {

    NORMAL(60), RETORNO(30);

    private int duracaoConsulta;

    private TipoConsulta(int duracaoConsulta) {
        this.duracaoConsulta = duracaoConsulta;
    }

    public int getDuracaoConsulta() {
        return duracaoConsulta;
    }

}
