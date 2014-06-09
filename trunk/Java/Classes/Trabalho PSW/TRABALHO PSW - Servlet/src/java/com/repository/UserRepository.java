package com.repository;

import java.util.HashMap;
import java.util.Map;

import com.domain.Credencial;
import com.domain.Usuario;

public class UserRepository extends Repository<Usuario>{
	
	private Map<String, String> loginMap;
	private Map<String, Long> userMap;
	
	public UserRepository() {
		super();
		loginMap = new HashMap<String, String>();
		userMap = new HashMap<String, Long>();
	}
	
	public Repository<Usuario> merge(Usuario usuario){
            loginMap.put(usuario.getUser(), usuario.getPassword());
		userMap.put(usuario.getUser(), usuario.getId());
		return super.merge(usuario);		
	}
	
	public Repository<Usuario> remove(Usuario usuario){
		loginMap.remove(usuario.getUser());
		userMap.remove(usuario.getUser());		return super.remove(usuario);
		
	} 

	public Credencial getCredencialByUser(String user){
		String password = loginMap.get(user);
		if (password != null){
			return new Credencial(user, password);
		}
		return null;
	}

	public Usuario getUsuarioByUser(String user){
		Long id = userMap.get(user);
		if (id != null){
			return repositorio.get(id);
		}
		return null;
	}
}
