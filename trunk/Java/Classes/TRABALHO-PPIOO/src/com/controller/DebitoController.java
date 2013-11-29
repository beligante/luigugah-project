package com.controller;

import java.util.Collection;

import com.entity.Debito;
import com.entity.Usuario;
import com.repository.DebitoRepository;

public class DebitoController extends AbstractController<Debito, DebitoRepository>{

	
	public boolean isValorASerPagoValido(Debito debito, Float valor){
		return debito.getValor() == valor;
	}
	
	public Collection<Debito> getDebitosEmAbertoByUsuario(Usuario usuario){
		return getRepository().getDebitosEmAbertoByUsuario(usuario);
	}
	
	@Override
	protected void removeImpl(Debito entidade) {
		getRepository().remove(entidade);
		
	}

	@Override
	protected void saveImpl(Debito entidade) {
		getRepository().merge(entidade);
		
	}

	
}
