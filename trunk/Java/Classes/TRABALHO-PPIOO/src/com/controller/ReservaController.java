package com.controller;

import java.util.ArrayList;
import java.util.Collection;

import com.entity.Obra;
import com.entity.Reserva;
import com.repository.Repository;

public class ReservaController extends AbstractController<Reserva, Repository<Reserva>>{

	protected Collection<Reserva> getReservasByObra(Obra obra){
		Collection<Reserva> reservas = getRepository().getAll();
		
		if (reservas != null && reservas.size() > 0){
			Collection<Reserva> query = new ArrayList<Reserva>();
			
			for (Reserva reserva : reservas){
				if (reserva.getObra().compareTo(obra) == 0){
					query.add(reserva);
				}
			}
			return query;
		}
		return null;
	}
	
	@Override
	protected void removeImpl(Reserva reserva) {
		getRepository().remove(reserva);
		
	}

	@Override
	protected void saveImpl(Reserva reserva) {
		getRepository().merge(reserva);
		
	}

}
