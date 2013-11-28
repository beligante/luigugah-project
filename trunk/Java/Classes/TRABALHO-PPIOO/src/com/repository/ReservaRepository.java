package com.repository;

import java.util.ArrayList;
import java.util.Collection;

import com.entity.Obra;
import com.entity.Reserva;

public class ReservaRepository extends Repository<Reserva>{

	public Collection<Reserva> getReservasByObra(Obra obra){
		Collection<Reserva> reservas = getAll();
		
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
}
