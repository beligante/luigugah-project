package com.controller;

import com.domain.Paciente;
import com.repository.Repository;

public class PacienteController extends AbstractController<Paciente, Repository<Paciente>>{
	
	@Override
	protected void removeImpl(Paciente entidade) {
		getRepository().remove(entidade);
		
	}

	@Override
	protected void saveImpl(Paciente entidade) {
		getRepository().remove(entidade);
		
	}

}
