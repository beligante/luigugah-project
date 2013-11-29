package com.controller;

import java.util.Collection;

import com.entity.Exemplar;
import com.entity.Obra;
import com.repository.ExemplarRepository;

public class ExemplarController extends AbstractController<Exemplar, ExemplarRepository>{
	
	public Collection<Exemplar> getExemplaresNaoEmprestados(Obra obra){
		return getRepository().getExemplaresNaoEmprestados(obra);
	}
	
	@Override
	protected void removeImpl(Exemplar entidade) {
		getRepository().remove(entidade);
	}

	@Override
	protected void saveImpl(Exemplar entidade) {
		getRepository().merge(entidade);
	}

}
