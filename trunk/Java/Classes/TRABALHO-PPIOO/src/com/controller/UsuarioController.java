package com.controller;

import java.util.Collection;

import com.entity.Credential;
import com.entity.Usuario;
import com.repository.UserRepository;

public class UsuarioController extends AbstractController<Usuario, UserRepository> {

	@Override
	protected void removeImpl(Usuario usuario) {
		getRepository().remove(usuario);		
	}

	@Override
	protected void saveImpl(Usuario usuario) {
		getRepository().merge(usuario);		
	}

	public void getAutentication(String user, String senha){
		
	}
	
	public Collection<Usuario> getAllUsers(){ return getRepository().getAll();}
	public Usuario getAutenticacao(Credential credencial){
		return getRepository().getUsuarioByAutenticacao(credencial.getAuthKey());
	}
}
