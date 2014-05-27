package com.domain;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@javax.persistence.Entity
public class Medico extends Usuario{

	public Medico() {
		super();
	}
}
