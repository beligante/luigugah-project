package com.controller;

import com.domain.Entity;
import com.domain.Paciente;
import com.repository.Repository;
import java.util.Collection;
import java.util.List;

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

	public void setRepository(Repositorio repository) {
		this.repository = repository;
        }
        
        public Collection<Entidade> searchById(Long id){
            return getRepository().search(id);
        }
}
