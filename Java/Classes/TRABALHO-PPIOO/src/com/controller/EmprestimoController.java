package com.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.entity.Emprestimo;
import com.entity.Exemplar;
import com.entity.Obra;
import com.entity.Reserva;
import com.entity.Usuario;
import com.repository.EmprestimoRepository;

public class EmprestimoController extends AbstractController<Emprestimo, EmprestimoRepository>{

	private ExemplarController exemplarController;
	private ReservaController reservaController;
	
	public boolean isUsuarioExcedenteCota(Usuario usuario){
		
		Collection<Emprestimo> emprestimos = getRepository().getEmprestimosByUsuario(usuario);
		
		if(emprestimos != null && emprestimos.size() > 0){
			return (usuario.getPerfil().getCotaEmprestimo() <= emprestimos.size());
		}
		
		return false;
	}
	
	public boolean isUsuarioPossuiDebito(Usuario usuario){return false;}
	
	public boolean isUsuarioPossuiAtrasos(Usuario usuario){
		Collection<Emprestimo> emprestimos = getRepository().getEmprestimosByUsuario(usuario);
		
		if(emprestimos != null && emprestimos.size() > 0){
			
			boolean atraso = false;
			for(Emprestimo emprestimo : emprestimos){
				if(emprestimo.isAtrasado()){
					atraso = true;
					break;
				}
			}
			return atraso;
		}
		
		return false;
	}
	
	public boolean isUsurioHabilitadoAEmprestarObra(Usuario usuario, Obra obra){
		Collection<Exemplar> exemplaresNaoEmprestados = exemplarController.getExemplaresNaoEmprestados(obra);
		
		if(exemplaresNaoEmprestados != null && exemplaresNaoEmprestados.size() > 0){
			Collection<Reserva> reservasAbertasParaObra = reservaController.getReservasAbertasByObra(obra);
			
			if(isUsuarioOnListaReserva(usuario, reservasAbertasParaObra)){
				int posicaoFilaUsuario = getPosicaoUsuarioAtFilaDeReservas(usuario, reservasAbertasParaObra);
				if(posicaoFilaUsuario >= 0 && exemplaresNaoEmprestados.size() <= (posicaoFilaUsuario+1)){
					
					return true;
				}
			}else if(exemplaresNaoEmprestados.size() > reservasAbertasParaObra.size()){
				return true;
			}
		}
		return false;
		
	}
	
	private boolean isUsuarioOnListaReserva(Usuario usuario, Collection<Reserva> reservas){
		if(reservas != null && reservas.size() > 0 ){
			for(Reserva reserva : reservas){
				if(usuario.compareTo(reserva.getUsuario()) == 0){
					return true;
				}
			}
		}
		return false;
	}
	
	private int getPosicaoUsuarioAtFilaDeReservas(Usuario usuario, Collection<Reserva> reservas){
		
		List<Integer> posicoesFila = new ArrayList<Integer>();
		
		int posicaoFilaUsuario = -1;
		
		if(reservas != null && reservas.size() > 0 ){
			for(Reserva reserva : reservas){
				posicoesFila.add(reserva.getPosicaoFila());
				if(usuario.compareTo(reserva.getUsuario()) == 0){posicaoFilaUsuario = reserva.getPosicaoFila();}
			}
			
			Collections.sort(posicoesFila);
			return posicoesFila.indexOf(posicaoFilaUsuario);
			
		}
		return -1;
	}
	
	
	@Override
	protected void removeImpl(Emprestimo entidade) {
		getRepository().remove(entidade);
		
	}

	@Override
	protected void saveImpl(Emprestimo entidade) {
		getRepository().merge(entidade);
		
	}
	
	public ExemplarController getExemplarController() {
		return exemplarController;
	}

	public void setExemplarController(ExemplarController exemplarController) {
		this.exemplarController = exemplarController;
	}

	public ReservaController getReservaController() {
		return reservaController;
	}

	public void setReservaController(ReservaController reservaController) {
		this.reservaController = reservaController;
	}

}
