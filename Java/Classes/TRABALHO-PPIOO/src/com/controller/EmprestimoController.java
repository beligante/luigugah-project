package com.controller;

import java.util.Collection;

import com.entity.Emprestimo;
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
	
	@Override
	protected void removeImpl(Emprestimo entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void saveImpl(Emprestimo entidade) {
		// TODO Auto-generated method stub
		
	}

}
