package com.controller;

import com.entity.Reserva;
import com.repository.Repository;

public class ReservaController extends AbstractController<Reserva, Repository<Reserva>>{

	@Override
	protected void removeImpl(Reserva reserva) {
		getRepository().remove(reserva);
		
	}

	@Override
	protected void saveImpl(Reserva reserva) {
		getRepository().merge(reserva);
		
	}

}
