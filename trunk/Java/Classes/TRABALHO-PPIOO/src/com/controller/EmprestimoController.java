package com.controller;

import java.util.ArrayList;
import java.util.Collection;

import com.entity.Emprestimo;
import com.entity.Exemplar;
import com.entity.Obra;
import com.entity.Usuario;
import com.repository.EmprestimoRepository;

public class EmprestimoController extends AbstractController<Emprestimo, EmprestimoRepository>{

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
	
	public boolean isUsurioHabilitadoAEmprestarObra(Obra obra){
		Collection<Exemplar> exemplaresNaoEmprestados = 
						filtraExemplaresEmprestados(getRepository().getEmprestimosByObra(obra));
	}
	
	@Override
	protected void removeImpl(Emprestimo entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void saveImpl(Emprestimo entidade) {
		// TODO Auto-generated method stub
		
	}


	private Collection<Exemplar> filtraExemplaresEmprestados(Collection<Exemplar> exemplares){
		Collection<Exemplar> listaFiltrada = new ArrayList<Exemplar>();
		
		for(Exemplar exemplar : exemplares){
			if(!exemplar.isEmprestado()){
				listaFiltrada.add(exemplar);
			}
		}
		
		return listaFiltrada;
	}
}
