package com.controller;

import com.entity.Entity;
import com.repository.Repository;

public abstract class AbstractController
			<Entidade extends Entity, Repositorio extends Repository<Entidade>> {
	
	Repositorio repository;
	
	
	public AbstractController<Entidade, Repositorio> save(Entidade entidade) {
		this.saveImpl(entidade);
		return this;
	}
	
	protected abstract AbstractController<Entidade, Repositorio> saveImpl(Entidade entidade);
}
