package com.controller;

import java.io.ObjectInputStream.GetField;
import java.util.Collection;

import com.entity.Credential;
import com.entity.Usuario;
import com.repository.UserRepository;

public class UsuarioController extends AbstractController<Usuario, UserRepository> {

	@Override
	protected void removeImpl(Usuario entidade) {
		
		
	}

	@Override
	protected void saveImpl(Usuario entidade) {
		
		
	}

	public void getAutentication(String user, String senha){
		
	}
	
	public Collection<Usuario> getAllUsers(){ return getRepository().getAll();}
	public Usuario getAutenticacao(Credential credencial){
		return getRepository().getUsuarioByAutenticacao(credencial.getAuthKey());
	}
}
