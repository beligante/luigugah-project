package com.controller;

import com.entity.Devolucao;
import com.entity.Emprestimo;
import com.repository.Repository;

public class DevolucaoController extends AbstractController<Devolucao, Repository<Devolucao>>{
	
	private EmprestimoController emprestimoController;
	
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
		getRepository().remove(entidade);
		
	}

	public EmprestimoController getEmprestimoController() {
		return emprestimoController;
	}

	public void setEmprestimoController(EmprestimoController emprestimoController) {
		this.emprestimoController = emprestimoController;
	}

}
