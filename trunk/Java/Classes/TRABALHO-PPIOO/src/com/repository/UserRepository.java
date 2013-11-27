package com.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.entity.Usuario;
import com.interfaces.Filter;

public class UserRepository extends Repository<Usuario> implements Filter<Usuario>{
	
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
	
	public Collection<Usuario> searchByName(String name){
		
		Collection<Usuario> usuarios = getAll();
		if(usuarios != null && usuarios.size() > 0)
		{
			Collection<Usuario> query = new ArrayList<Usuario>();
			for(Usuario usuario : usuarios){
				
				if(usuario.getNome().contains(name)){
					query.add(usuario);
				}
				
			}
			return query;
		}
		
		return null;
	}
}
