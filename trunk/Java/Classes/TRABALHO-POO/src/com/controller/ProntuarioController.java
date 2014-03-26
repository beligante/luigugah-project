package com.controller;

import com.domain.Prontuario;
import com.repository.Repository;

public class ProntuarioController extends AbstractController<Prontuario, Repository<Prontuario>>{

	@Override
	protected void removeImpl(Prontuario entidade) {
		getRepository().remove(entidade);
		
	}

	@Override
	protected void saveImpl(Prontuario entidade) {
		getRepository().remove(entidade);
		
	}


}
