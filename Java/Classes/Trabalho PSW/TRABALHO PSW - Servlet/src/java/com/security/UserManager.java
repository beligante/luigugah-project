package com.security;

import com.controller.UserController;
import com.domain.Credencial;
import com.domain.Usuario;
import com.repository.UserRepository;

public class UserManager {
	
	private UserRepository repository;
	private Credencial credencial;
	
	public Usuario login(Credencial credencial){
		this.credencial = credencial;
		return new UserController(this).getLoginByCredencial();
	}

	public UserRepository getRepository() {
		return repository;
	}

	public void setRepository(UserRepository repository) {
		this.repository = repository;
	}

	public Credencial getCredencial() {
		return credencial;
	}
	
}
