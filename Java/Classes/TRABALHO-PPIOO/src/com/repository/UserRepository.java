package com.repository;

import java.util.HashMap;
import java.util.Map;

import com.entity.Credential;
import com.entity.Entity;
import com.entity.Usuario;

public class UserRepository extends Repository<Usuario> {
	
	public UserRepository() {
		super();
		mapaDeAutenticacao = new HashMap<String, Long>();
	}
	
	private Map<String, Long> mapaDeAutenticacao;
	
	public UserRepository merge(Usuario entidade){
		
		this.repositorio.put(entidade.getId(), entidade);
		this.mapaDeAutenticacao.put(getAutenticacaoKey(entidade), entidade.getId());
		return this;
	}

	private String getAutenticacaoKey(Usuario entidade){
		return entidade.getLogin() + "_" + entidade.getSenha();
	}

	public Usuario getUsuarioByAutenticacao(String autenticacaoKey){
		Long id = mapaDeAutenticacao.get(autenticacaoKey);
		return repositorio.get(id);
	}
}
