package com.controller;

import java.util.ArrayList;
import java.util.Collection;

import com.entity.Obra;
import com.entity.Reserva;
import com.repository.ReservaRepository;

public class ReservaController extends AbstractController<Reserva, ReservaRepository>{

	public Collection<Reserva> getReservasAbertasByObra(Obra obra){
		Collection<Reserva> reservas = getReservasByOra(obra);
		if(reservas != null && reservas.size() > 0){
			Collection<Reserva> query = new ArrayList<Reserva>();
			for(Reserva reserva : reservas){
				if(!reserva.isRetirado()){
					query.add(reserva);
				}
			}
			return query;
		}
		return null;
	}
	
	private Collection<Reserva> getReservasByOra(Obra obra){
		return getRepository().getReservasByObra(obra);
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
