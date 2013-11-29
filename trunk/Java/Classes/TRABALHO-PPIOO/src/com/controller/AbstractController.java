package com.controller;

import com.entity.Entity;
import com.repository.Repository;

public abstract class AbstractController
			<Entidade extends Entity, Repositorio extends Repository<Entidade>> {
	 
	private Repositorio repository;
	
	public void save(Entidade entidade) {
		this.saveImpl(entidade); 
	}
	
	public void remove(Entidade entidade){
		this.removeImpl(entidade);
	}
	
	protected abstract void removeImpl(Entidade entidade);

	protected abstract void saveImpl(Entidade entidade);

	protected Repositorio getRepository() {
		return repository;
	}

	protected void setRepository(Repositorio repository) {
		this.repository = repository;
	}
}
