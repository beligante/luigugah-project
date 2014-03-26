package com.controller;

import com.domain.Consulta;
import com.repository.Repository;

public class ConsultaController extends AbstractController<Consulta, Repository<Consulta>>{

	@Override
	protected void removeImpl(Consulta entidade) {
		getRepository().remove(entidade);
		
	}

	@Override
	protected void saveImpl(Consulta entidade) {
		getRepository().remove(entidade);
		
	}

}
