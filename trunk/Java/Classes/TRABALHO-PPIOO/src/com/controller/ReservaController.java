package com.controller;

import java.util.ArrayList;
import java.util.Collection;

import com.entity.Exemplar;
import com.entity.Obra;
import com.entity.Reserva;
import com.entity.Usuario;
import com.repository.ReservaRepository;

public class ReservaController extends AbstractController<Reserva, ReservaRepository>{

	private ExemplarController exemplarController;

	public ExemplarController getExemplarController() {
		return exemplarController;
	}

	public void setExemplarController(ExemplarController exemplarController) {
		this.exemplarController = exemplarController;
	}

	public boolean isUsuarioHabilitadoAReservarObra(Usuario usuario, Obra obra){
		Collection<Reserva> reservas = getReservasAbertasByObra(obra);
		if(reservas != null && reservas.size() > 0){
			for(Reserva reserva : reservas){
				if(usuario.compareTo(reserva.getUsuario()) == 0){
					return true;
				}
			}
		}
		return false;
	}
	
	public Collection<Reserva> getReservasAbertasByObra(Obra obra){
		Collection<Reserva> reservas = getReservasByOra(obra);
		if(reservas != null && reservas.size() > 0){
			Collection<Reserva> query = new ArrayList<Reserva>();
			for(Reserva reserva : reservas){
				if(!reserva.isRetirado() && !reserva.isExpirado()){
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
	
	public boolean isObraReservavel(Obra obra){
		Collection<Exemplar> exemplares = exemplarController.getExemplaresNaoEmprestados(obra);
		
		if(exemplares != null){
			return exemplares.size() < getCoutNumeroReservasByObra(obra);
		}
		return false;
	}
	
	private int getCoutNumeroReservasByObra(Obra obra) {
		Collection<Reserva> reservas = getRepository().getAll();
		
		int contador = 0;
		if(reservas != null && reservas.size() > 0){
			for(Reserva reserva : reservas){
				if(reserva.getObra().compareTo(obra) == 0){ contador++;}
			}
		}
		return contador;
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
