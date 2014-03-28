package com.controller;

import com.repository.UserRepository;
import com.security.UserManager;
import com.domain.Credencial;
import com.domain.Usuario;

public class UserController extends AbstractController<Usuario, UserRepository>{

	private Credencial credencial;
	
	public UserController(UserManager userManager){
		setRepository(userManager.getRepository());
		credencial = userManager.getCredencial();
	}
	
	public Usuario getLoginByCredencial(){
		Credencial databaseUser = getRepository().getCredencialByUser(credencial.getUser());
                
                if (databaseUser != null && databaseUser.equals(credencial)){
			return getRepository().getUsuarioByUser(credencial.getUser());
		}
		return null;
	}
	
	@Override
	protected void removeImpl(Usuario entidade) {
		getRepository().remove(entidade);	
	}

	@Override
	protected void saveImpl(Usuario entidade) {
		getRepository().merge(entidade);		
	}

}
