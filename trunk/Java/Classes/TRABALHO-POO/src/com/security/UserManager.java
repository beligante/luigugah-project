package com.security;

import com.controller.UserController;
import com.domain.Credencial;
import com.repository.UserRepository;

public class UserManager {
	
	private UserRepository repository;
	private Credencial credencial;
	
	public void login(Credencial credencial){
		this.credencial = credencial;
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
