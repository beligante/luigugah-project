package com.controller;

import java.util.Collection;
import java.util.Date;

import com.entity.Devolucao;
import com.entity.Emprestimo;
import com.entity.Reserva;
import com.repository.Repository;

public class DevolucaoController extends AbstractController<Devolucao, Repository<Devolucao>>{
	
	private EmprestimoController emprestimoController;
	private ReservaController reservaController;
	
	public void registraDevolucao(Emprestimo emprestimo){
		Devolucao devolucao = new Devolucao();
		devolucao.emprestimo(emprestimo).registarDevolucao();
		this.save(devolucao);
		emprestimoController.save(emprestimo);
	}
	
	@Override
	protected void removeImpl(Devolucao entidade) {
		getRepository().merge(entidade);
	}

	@Override
	protected void saveImpl(Devolucao entidade) {
		Collection<Reserva> reservas= reservaController
											.getReservasAbertasByObra(entidade.getEmprestimo().getExemplar().getObra());
		
		if(reservas!= null && reservas.size() > 0){
			for(Reserva reserva : reservas){
				reserva.setDataInicioContagem(new Date());
				reservaController.save(reserva);
			}
		}
		getRepository().remove(entidade);
		
	}

	public EmprestimoController getEmprestimoController() {
		return emprestimoController;
	}

	public void setEmprestimoController(EmprestimoController emprestimoController) {
		this.emprestimoController = emprestimoController;
	}

}
