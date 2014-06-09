package com.domain;

public class Secretaria extends Usuario{
	
	public Secretaria() {
		super();
	}	

    @Override
    public String getFuncao() {
        return Secretaria.class.getSimpleName();
    }
}
